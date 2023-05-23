package me.jmfs.pattern.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/23
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 扩展
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtensionDO {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;

    /**
     * 插件ID
     */
    private String pluginId;

    /**
     * 扩展实例ID
     */
    private String extensionId;

    /**
     * 扩展点
     */
    private String extensionPoint;

    /**
     * 扩展点暴露的path，如：/xxx/yyy
     */
    private String path;

    /**
     * 扩展点状态
     */
    private Integer status;
}
