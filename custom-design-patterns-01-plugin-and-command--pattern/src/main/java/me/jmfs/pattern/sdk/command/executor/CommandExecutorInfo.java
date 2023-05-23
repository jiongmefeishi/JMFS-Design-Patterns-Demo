package me.jmfs.pattern.sdk.command.executor;

import lombok.Data;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令执行器信息
 */
@Data
public class CommandExecutorInfo {

    /**
     * 执行器名称
     */
    private String name;

    private long completedTask;

    private int queueSize;

    private int activeCount;

    private int hangCount;

    private int blockingCount;

    private int taskQueueFinishedCount;

    public CommandExecutorInfo(String name) {
        this.name = name;
    }

    private int maxPoolSize;

    private int corePoolSize;

    public void setCompletedTask(long completedTask) {
        this.completedTask = completedTask;
    }

    public long getCompletedTask() {
        return completedTask;
    }

    public void setQueueSize(int queueSize) {

        this.queueSize = queueSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public int getActiveCount() {
        return activeCount;
    }
}
