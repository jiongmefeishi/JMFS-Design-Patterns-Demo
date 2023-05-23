package me.jmfs.pattern.service;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 插件服务
 */
public interface PluginService {

    /**
     * 注册插件
     */
    Long register(Plugin plugin);

    /**
     * 删除插件
     */
    void delete(String pluginId);

    /**
     * 激活插件
     */
    void activate(String pluginId);

    /**
     * 禁用插件
     */
    void deactivate(String pluginId);

    /**
     * 查找激活状态的扩展点实现
     * @param extensionPoint 扩展点
     */
    Extension listActivatedExtension(String extensionPoint);
}
