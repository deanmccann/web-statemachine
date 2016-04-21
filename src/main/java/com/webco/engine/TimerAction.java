package com.webco.engine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * Created by dean on 21/02/16.
 */
public class TimerAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> context) {
        // do something in every 1 sec
        System.out.println(" >> TimerWait...");
    }
}