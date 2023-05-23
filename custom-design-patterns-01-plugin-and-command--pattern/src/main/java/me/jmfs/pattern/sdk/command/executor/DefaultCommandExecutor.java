package me.jmfs.pattern.sdk.command.executor;

import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.config.CommandConfiguration;
import me.jmfs.pattern.sdk.command.interceptor.CommandInterceptor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 默认命令执行器实现
 */
public class DefaultCommandExecutor extends CommandExecutor {

    protected ExecutorService executor;

    protected CommandExecutorInfoHolder commandExecutorInfoHolder;

    private BlockingQueue<Runnable> blockingQueue;

    private CommandConfiguration config;

    private CommandInterceptor firstInterceptor;

    public DefaultCommandExecutor(CommandConfiguration commandConfiguration, CommandInterceptor firstInterceptor) {
        this.config = commandConfiguration;
        this.firstInterceptor = firstInterceptor;
    }

    public CommandConfiguration getDefaultConfiguration() {
        return this.config;
    }

    @Override
    public <Response> Response execute(Command<Response> command) {
        //在这里可以做拦截
        return firstInterceptor.execute(this.config, command);
    }

    @Override
    public String getCommandExecutorName() {
        return "default";
    }

    @Override
    public CommandExecutorInfo getCommandExecutorInfo() {
        CommandExecutorInfo commandExecutorInfo = this.commandExecutorInfoHolder.getCommandExecutorInfo();
        if (this.executor instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executor;
            commandExecutorInfo.setMaxPoolSize(threadPoolExecutor.getMaximumPoolSize());
            commandExecutorInfo.setCorePoolSize(threadPoolExecutor.getCorePoolSize());
            commandExecutorInfo.setCompletedTask(threadPoolExecutor.getCompletedTaskCount());
            commandExecutorInfo.setQueueSize(threadPoolExecutor.getQueue().size());
            commandExecutorInfo.setActiveCount(threadPoolExecutor.getActiveCount());
        }
        return commandExecutorInfo;
    }

    private static class CommandExecutorInfoHolder {

        public CommandExecutorInfoHolder(CommandExecutorInfo commandExecutorInfo) {
            this.commandExecutorInfo = commandExecutorInfo;
        }

        private CommandExecutorInfo commandExecutorInfo;

        public CommandExecutorInfo getCommandExecutorInfo() {
            return commandExecutorInfo;
        }
    }

}
