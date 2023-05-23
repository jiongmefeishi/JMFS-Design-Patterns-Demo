package me.jmfs.pattern.sdk.command.interceptor;

import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.config.CommandConfiguration;
import me.jmfs.pattern.sdk.command.context.CommandContext;
import me.jmfs.pattern.sdk.command.context.CommandContextFactory;
import me.jmfs.pattern.sdk.command.context.Context;
import me.jmfs.pattern.sdk.command.interceptor.AbstractCommandInterceptor;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令上下文拦截器
 */
public class CommandContextInterceptor extends AbstractCommandInterceptor {

    /**
     * 命令上下文工厂
     */
    private CommandContextFactory commandContextFactory;

    public CommandContextInterceptor(CommandContextFactory commandContextFactory){
        this.commandContextFactory = commandContextFactory;
    }

    /**
     * 命令执行
     * @param commandConfiguration 命令配置
     * @param command 命令
     * @return 命令执行结果
     */
    @Override
    public <T> T execute(CommandConfiguration commandConfiguration, Command<T> command) {
        CommandContext commandContext = Context.getCommandContext();
        boolean contextReused = false;
        if (!commandConfiguration.isContextReusePossible() || commandContext == null) {
            commandContext = commandContextFactory.createCommandContext(command);
        } else {
            contextReused = true;
            commandContext.setContextReusePossible(true);
        }
        try {
            commandContext.addCommandName(command);
            Context.setCommandContext(commandContext);
            return next.execute(commandConfiguration, command);
        } catch (Exception e) {
            commandContext.exceptional(e);
        } finally {
            try {
                // 如果上下文没有被重用，则销毁上下文,标识command已经调用完毕
                if (!contextReused) {
                    commandContext.close();
                }
            } finally {
                Context.removeCommandContext();
            }
        }
        return null;
    }
}
