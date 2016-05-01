package com.webco.engine;

import java.util.EnumSet;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


 @Configuration
 public class WebCoProcessor {


     @Configuration
     @EnableStateMachine
     static class StateMachineConfiguration
             extends EnumStateMachineConfigurerAdapter<States, Events> {

         @Override
         public void configure(StateMachineConfigurationConfigurer<States, Events> config)
                 throws Exception {
             config
                     .withConfiguration()
                     .autoStartup(true)
                     .listener(listener());
         }

         @Override
         public void configure(StateMachineStateConfigurer<States, Events> states)
                 throws Exception {
             states
                     .withStates()
                     .initial(States.READY)
                     .choice(States.RECIEVE)
                     //.end(States.RUNNING)
                     .states(EnumSet.allOf(States.class));
             //.state(States.AVAILABLE, action1(), doSomeAction())
             //.state(States.UNAVAILABLE, action1(), doSomeAction());
         }

         @Bean
         public Action<States, Events> action1() {
             return new Action<States, Events>() {

                 @Override
                 public void execute(StateContext<States, Events> context) {
                 }
             };
         }


         @Override
         public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
                 throws Exception {
             transitions
                     .withExternal()
                     .source(States.READY)
                     .target(States.RECIEVE)
                     .event(Events.ARTIFACT_NOTIFICATION_EVENT)
                     .and()
                     .withChoice()
                     .source(States.RECIEVE)
                     .first(States.AVAILABLE, guardAvailable())
                     .last(States.UNAVAILABLE)
                     .and()
                     .withExternal()
                     .source(States.AVAILABLE)
                     .target(States.RUNNING)
                     .event(Events.DEPLOY_NOTIFICATION_EVENT);
         }

         @Bean
         public TimerAction timerAction() {
             return new TimerAction();
         }


         @Bean
         public StateMachineListener<States, Events> listener() {
             return new StateMachineListenerAdapter<States, Events>() {

                 @Override
                 public void stateChanged(State<States, Events> from, State<States, Events> to) {
                     System.out.println(" >> State change to " + to.getId());
                 }
             };
         }


         @Bean
         public Guard<States, Events> guardAvailable() {
             return new Guard<States, Events>() {
                 @Override
                 public boolean evaluate(StateContext<States, Events> context) {

                     /**
                      * Find Artifact in Repo.
                      * TRUE if found.i.e. available for use
                      *
                      * For now simply return a random result.
                      *
                      */
                     Boolean artifactFoundInRepo = false;
                     if (context.getExtendedState().getVariables().get("frsArtifactFound") == null) {
                         artifactFoundInRepo = new Random().nextBoolean();
                         System.out.println(
                                 "\n >> Event : " + context.getEvent().name() +
                                         "\n >> artifactFoundInRepo " + artifactFoundInRepo);
                         //Store in the context
                         context.getExtendedState().getVariables().put("frsArtifactFound", artifactFoundInRepo);
                     }
                     return artifactFoundInRepo;

                 }
             };
         }


         @Bean
         public Action<States, Events> doSomeAction() {
             return new Action<States, Events>() {

                 @Override
                 public void execute(StateContext<States, Events> context) {
                     // do something

                     System.out.println(" > event " + context.getEvent() + " invoked call to action");

                 }
             };
         }


     }
 }