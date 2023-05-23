package me.jmfs.pattern.service;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 插件模型定义
 * <p></p>
 * 平台向插件保留什么能力？
 * 插件像平台保留什么能力？
 * 插件需要保证可序列化
 */
@Data
public class Plugin implements Serializable {

    /**
     * 插件编码
     */
    String code;

    /**
     * 插件名称
     */
    String name;

    /**
     * 插件描述
     */
    String desc;

    /**
     * 插件保留出来的访问地址
     */
    String endpoint;

    /**
     * 是否激活
     */
    Boolean activated;

    /**
     * 插件扩展点列表
     */
    private List<String> extensionPoints;
}
