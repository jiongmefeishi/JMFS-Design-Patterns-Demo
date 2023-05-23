package me.jmfs.pattern.sdk.command.executor;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令执行器顶层抽象
 */
public abstract class CommandExecutor implements CommandExecutable {

    /**
     * @return 获取执行器名称
     */
    public abstract String getCommandExecutorName();

    /**
     * @return 获取命令执行器信息
     */
    public abstract CommandExecutorInfo getCommandExecutorInfo();
}
