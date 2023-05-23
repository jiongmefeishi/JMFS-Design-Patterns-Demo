package me.jmfs.pattern.sdk.command.invoker;

import me.jmfs.pattern.sdk.command.*;
import me.jmfs.pattern.sdk.command.config.CommandConfiguration;
import me.jmfs.pattern.sdk.command.context.CommandContext;
import me.jmfs.pattern.sdk.command.context.Context;
import me.jmfs.pattern.sdk.command.interceptor.CommandInterceptor;
import me.jmfs.pattern.sdk.command.interceptor.AbstractCommandInterceptor;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 默认命令调用器实现
 */
public class DefaultCommandInvoker extends AbstractCommandInterceptor {

    @Override
    public <T> T execute(CommandConfiguration commandConfiguration, Command<T> command) {
        CommandContext commandContext = Context.getCommandContext();
        return command.execute(commandContext);
    }

    @Override
    public CommandInterceptor getNext() {
        return null;
    }

    @Override
    public void setNext(CommandInterceptor next) {
        throw new UnsupportedOperationException("CommandInvoker must be the last interceptor in the chain");
    }
}
