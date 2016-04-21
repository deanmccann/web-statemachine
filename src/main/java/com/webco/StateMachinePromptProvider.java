package com.webco;

/**
 * Created by dean on 23/02/16.
 */
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class StateMachinePromptProvider extends DefaultPromptProvider {

    @Override
    public String getPrompt() {
        return "sm>";
    }


    @Override
    public String getProviderName() {
        return "State machine prompt provider";
    }

}
