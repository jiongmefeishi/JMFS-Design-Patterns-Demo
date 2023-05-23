package me.jmfs.pattern.sdk.command.executor;

import me.jmfs.pattern.sdk.command.Command;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: Command执行器顶层接口
 */
public interface CommandExecutable {

    /**
     * 命令真实执行
     * @param command 命令
     * @param <Response> 执行返回
     */
    <Response> Response execute(Command<Response> command);
}
