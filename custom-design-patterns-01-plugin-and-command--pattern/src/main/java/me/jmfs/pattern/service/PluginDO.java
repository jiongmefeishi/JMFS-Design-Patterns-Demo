package me.jmfs.pattern.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 插件DO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PluginDO {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;

    /**
     * 插件ID
     */
    private String pluginId;

    /**
     * 插件名
     */
    private String pluginName;

    /**
     * 插件描述
     */
    private String description;

    /**
     * 插件交互 endpoint
     */
    private String endpoint;

    /**
     * 插件是否激活
     */
    private Integer activated;


}
