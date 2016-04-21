package demo;


import com.webco.engine.Events;
import com.webco.engine.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
    public class ApplicationSbVersion implements CommandLineRunner {
      /**
            public static void main(String[] args) throws Exception {
                SpringApplication.run(ApplicationSbVersion.class, args);
            }
       **/



    @Autowired
    public StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.ARTIFACT_NOTIFICATION_EVENT);
        stateMachine.sendEvent(Events.DEPLOY_NOTIFICATION_EVENT);
    }

    }
