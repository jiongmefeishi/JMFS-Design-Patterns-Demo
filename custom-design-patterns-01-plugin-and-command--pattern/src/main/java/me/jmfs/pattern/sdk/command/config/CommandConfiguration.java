package me.jmfs.pattern.sdk.command.config;

import lombok.Getter;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令配置
 */
@Getter
public class CommandConfiguration {

    /**
     * 是否支持上下文可重用
     */
    private boolean contextReusePossible = false;
}
