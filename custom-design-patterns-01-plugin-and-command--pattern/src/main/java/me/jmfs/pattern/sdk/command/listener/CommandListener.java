package me.jmfs.pattern.sdk.command.listener;

import me.jmfs.pattern.sdk.command.Command;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: Command 调用监听器
 */
public interface CommandListener<T> {

    /**
     * Command 调用前置处理
     */
    void beforeInvoke(Command<T> command);

    /**
     * Command 调用后置处理
     */
    void afterInvoke(Command<T> command, T response);
}
