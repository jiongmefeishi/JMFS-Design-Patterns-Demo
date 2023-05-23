package me.jmfs.pattern.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Extension {

    /**
     * 插件ID
     */
    private Long pluginId;

    /**
     * 插件Endpoint如：127.0.0.1
     */
    private String endpoint;

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
