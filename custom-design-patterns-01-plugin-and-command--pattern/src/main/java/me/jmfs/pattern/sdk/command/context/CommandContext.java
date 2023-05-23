package me.jmfs.pattern.sdk.command.context;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.ComponentHolder;
import me.jmfs.pattern.sdk.common.CommonException;
import me.jmfs.pattern.sdk.common.CommonResultCode;
import me.jmfs.pattern.sdk.error.CommonErrorCode;
import org.springframework.context.ApplicationContext;

import java.util.LinkedList;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令执行上下文
 */
@Slf4j
public class CommandContext {

    /**
     * 待执行命令
     */
    protected Command<?> command;

    /**
     * 执行异常
     */
    protected Exception exception;

    /**
     * 组件容器
     */
    protected ComponentHolder componentHolder;

    /**
     * 是否支持上下文可重用
     */
    private boolean contextReusePossible;


    public LinkedList<String> getCommandNamesLink() {
        return commandNamesLink;
    }

    protected LinkedList<String> commandNamesLink = new LinkedList<>();

    public boolean isContextReusePossible() {
        return contextReusePossible;
    }

    public void setContextReusePossible(boolean contextReusePossible) {
        this.contextReusePossible = contextReusePossible;
    }


    public CommandContext(Command<?> command) {
        this.command = command;
    }

    public void addCommandName(Command<?> invokeCommand) {
        this.commandNamesLink.add(invokeCommand.getClass().getSimpleName());
    }

    public void exceptional(Exception e) {
        this.exception = e;
    }

    public void setComponentHolder(ComponentHolder componentHolder) {
        this.componentHolder = componentHolder;
    }

    /**
     * 利用反射从Spring IOC 获取类实例
     * @param clazz 反射类
     * @return 目标类bean实例
     */
    public <T> T getComponent(Class<T> clazz) {
        Preconditions.checkNotNull(componentHolder);
        return componentHolder.getBeanByType(clazz);
    }

    public ApplicationContext getApplicationContext(){
        return componentHolder.getApplicationContext();
    }

    public void close() {
        if (exception != null) {
            log.warn("Error while close command context", exception);
            rethrowExceptionIfNeeded();
        }
    }

    private void rethrowExceptionIfNeeded() {
        if (this.exception instanceof RuntimeException) {
            throw (RuntimeException)exception;
        }
        throw new CommonException(CommonResultCode.FAILURE, CommonErrorCode.COMMAND_EXECUTE_ERROR, exception);
    }

}
