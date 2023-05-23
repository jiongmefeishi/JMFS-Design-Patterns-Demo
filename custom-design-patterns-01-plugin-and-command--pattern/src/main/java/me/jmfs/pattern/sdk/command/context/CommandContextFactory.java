package me.jmfs.pattern.sdk.command.context;

import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.ComponentHolder;
import org.springframework.context.ApplicationContext;

/**
 * 命令上下文工厂
 */
public class CommandContextFactory {

    private ApplicationContext applicationContext;

    public CommandContextFactory(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public CommandContext createCommandContext(Command<?> cmd) {
        CommandContext commandContext = new CommandContext(cmd);
        commandContext.setComponentHolder(new ComponentHolder(applicationContext));
        return commandContext;
    }

}
