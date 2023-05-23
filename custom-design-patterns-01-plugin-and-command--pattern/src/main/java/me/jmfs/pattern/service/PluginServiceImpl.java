package me.jmfs.pattern.service;

import com.google.common.base.Strings;
import me.jmfs.pattern.sdk.command.executor.CommandExecutor;
import me.jmfs.pattern.sdk.common.CommonMd5HexKey;
import me.jmfs.pattern.service.cmd.QueryActivatedExtensionListCmd;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class PluginServiceImpl implements PluginService, InitializingBean {

    private final static String PLUGIN_KEY = "plugin";
    private final static String PLUGIN_DEFAULT_NAME = "DefaultPlugin";
    private final static String PLUGIN_DEFAULT_DESCRIPTION = "默认插件";

    @Value("${custom.plugin.extension.default.init}")
    private Boolean extensionInit;

    @Value("${custom.plugin.extension.endpoint}")
    private String extensionEndpoint;

    @Value("${custom.plugin.extension.activated}") 
    private String extensionActivated;

    @Resource
    private CommandExecutor commandExecutor;

    @Resource
    private PluginDao pluginDao;

    /**
     * 初始化插件注册到数据库
     */
    private void init() {
        if (extensionInit && !Strings.isNullOrEmpty(extensionEndpoint)) {
            String pluginId = initPlugin();
            initExtension(pluginId,"ThirdAuthTwoFactorToken", "/thirdAuthTwoFactorToken");
            initExtension(pluginId,"ThirdLoginVerification", "/thirdLoginVerification");
        }
    }

    /**
     * 注册插件
     */
    private String initPlugin() {
        String pluginId = CommonMd5HexKey.generatorMd5HexKey(PLUGIN_KEY);
        PluginDO pluginDO = pluginDao.findByPluginId(pluginId);
        if (pluginDO == null) {
            pluginDao.insertPlugin(pluginId, PLUGIN_DEFAULT_NAME, PLUGIN_DEFAULT_DESCRIPTION, extensionEndpoint, extensionActivated);
        } else {
            pluginDao.updatePlugin(pluginId, PLUGIN_DEFAULT_NAME, PLUGIN_DEFAULT_DESCRIPTION, extensionEndpoint, extensionActivated);
        }
        return pluginId;
    }

    /**
     * 注册扩展能力
     * @param pluginId 插件ID
     * @param extensionPoint 扩展点
     * @param extensionPointPath 扩展点请求路径
     */
    private void initExtension(String pluginId, String extensionPoint, String extensionPointPath) {
        String extensionId = CommonMd5HexKey.generatorMd5HexKey(extensionPoint, extensionPointPath);
        ExtensionDO dbExtensionDO = pluginDao.findExtensionDO(extensionId);
        ExtensionDO extensionDO = ExtensionDO.builder()
            .pluginId(pluginId)
            .path(extensionPointPath)
            .extensionId(extensionId)
            .extensionPoint(extensionPoint)
            .status(1)
            .build();
        if (dbExtensionDO != null) {
            extensionDO.setId(dbExtensionDO.getId());
            extensionDO.setStatus(dbExtensionDO.getStatus());
            extensionDO.setCreateTime(dbExtensionDO.getCreateTime());
            pluginDao.updateExtensionDO(extensionDO);
        } else {
            pluginDao.insertExtensionDO(extensionDO);
        }
    }

    @Override
    public Long register(Plugin plugin) {
        return null;
    }

    @Override
    public void delete(String code) {

    }

    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public Extension listActivatedExtension(String extensionPoint) {
        return commandExecutor.execute(new QueryActivatedExtensionListCmd(extensionPoint));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
