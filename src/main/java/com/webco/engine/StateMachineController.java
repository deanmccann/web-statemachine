package com.webco.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dean on 13/03/16.
 */
@Controller
@EnableAutoConfiguration
public class StateMachineController {

    private final static Log log = LogFactory.getLog(StateMachineController.class);	

    @Autowired
    public StateMachine<States, Events> stateMachine;
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

	@RequestMapping("/event") 
    public String greeting(@RequestParam(value="eventName", required=false, defaultValue="World") String name, Model model) {
		
	 stateMachine.sendEvent(Events.ARTIFACT_NOTIFICATION_EVENT);
	 stateMachine.sendEvent(Events.DEPLOY_NOTIFICATION_EVENT);
		
		
        model.addAttribute("name", Events.DEPLOY_NOTIFICATION_EVENT);
        return "index";
    }
     


	
}