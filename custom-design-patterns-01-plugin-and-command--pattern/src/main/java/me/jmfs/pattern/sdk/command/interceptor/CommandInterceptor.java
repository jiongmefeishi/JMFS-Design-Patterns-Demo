package me.jmfs.pattern.sdk.command.interceptor;

import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.config.CommandConfiguration;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: Command 执行拦截器
 */
public interface CommandInterceptor {

    <T> T execute(CommandConfiguration commandConfiguration, Command<T> command);

    /**
     * @return 获取下一个命令拦截器
     */
    CommandInterceptor getNext();

    /**
     * @param next 设置下一个需要执行的命令拦截器
     */
    void setNext(CommandInterceptor next);

}
