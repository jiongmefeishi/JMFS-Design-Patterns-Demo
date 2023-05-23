package me.jmfs.pattern.service;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 */
public interface PluginDao {

    PluginDO findByPluginId(String pluginId);

    /**
     * 新增插件
     * @param pluginId 插件ID
     * @param pluginName 插件名称
     * @param description 插件描述
     * @param extensionEndpoint 插件调用交互端点
     * @param extensionActivated 是否激活
     */
    void insertPlugin(String pluginId, String pluginName, String description, String extensionEndpoint, String extensionActivated);

    /**
     * 更新插件
     * @param pluginId 插件ID
     * @param pluginName 插件名称
     * @param description 插件描述
     * @param extensionEndpoint 插件调用交互端点
     * @param extensionActivated 是否激活
     */
    void updatePlugin(String pluginId, String pluginName, String description, String extensionEndpoint, String extensionActivated);

    /**
     * 查询扩展点
     * @param extensionId 扩展ID
     */
    ExtensionDO findExtensionDO(String extensionId);

    /**
     * 新增扩展
     */
    void insertExtensionDO(ExtensionDO extensionDO);

    /**
     * 删除扩展
     */
    void updateExtensionDO(ExtensionDO extensionDO);
}
