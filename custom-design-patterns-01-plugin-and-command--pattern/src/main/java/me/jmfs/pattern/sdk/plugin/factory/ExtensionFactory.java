package me.jmfs.pattern.sdk.plugin.factory;

import com.google.common.base.Preconditions;
import me.jmfs.pattern.sdk.plugin.execute.ExtensionExecutable;
import me.jmfs.pattern.sdk.plugin.point.IExtensionPoint;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 通过SPI(同步串行接口)注册到扩展定义到仓库中，各个微服务组件可以自定义扩展实现，而无需所有定义都定义在工程中
 */
public class ExtensionFactory {

    private static Map<String, ExtensionExecutable> registry = new HashMap<>(32);

    static {
        ServiceLoader<ExtensionExecutable> extensionExecutables = ServiceLoader.load(ExtensionExecutable.class);
        for (ExtensionExecutable extensionExecutable : extensionExecutables) {
            registry.put(extensionExecutable.getPoint(), extensionExecutable);
        }
    }

    /**
     * 获取扩展执行器
     * @param extensionPoint 扩展点
     * @param endpoint 扩展交互 endpoint
     * @param path 扩展交互 path
     * @return
     */
    public static ExtensionExecutable getInstance(IExtensionPoint extensionPoint, String endpoint,
                                                  String path) {
        Preconditions.checkNotNull(endpoint, "PluginEndpointIsNotAllowNull");
        if (registry.containsKey(extensionPoint.getPoint())) {
            ExtensionExecutable extension = registry.get(
                extensionPoint.getPoint());
            extension.defineUrl(endpoint, path, extensionPoint.getDefaultPath());
            return extension;
        }
        throw new IllegalArgumentException("ExtensionPointNotSupport");
    }
}
