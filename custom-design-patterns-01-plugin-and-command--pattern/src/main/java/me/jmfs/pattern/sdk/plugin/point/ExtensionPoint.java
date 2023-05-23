package me.jmfs.pattern.sdk.plugin.point;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 系统扩展点配置
 */
public enum ExtensionPoint implements IExtensionPoint {

    ThirdAuthTwoFactorToken("ThirdAuthTwoFactorToken", "第三方双因子认证扩展能力", ExtensionPointType.Action, "/thirdAuthTwoFactorToken"),
    ThirdLoginVerification("ThirdLoginVerification", "第三方登录认证扩展能力", ExtensionPointType.Action, "/thirdLoginVerification"),
    ;

    /**
     * @param point 扩展点
     * @param name 扩展点名称
     * @param type 扩展点类型
     * @param defaultPath 默认path
     */
    ExtensionPoint(String point, String name, ExtensionPointType type, String defaultPath) {
        this.point = point;
        this.name = name;
        this.type = type;
        this.defaultPath = defaultPath;
    }

    /**
     * 扩展点
     */
    private String point;

    /**
     * 扩展点名称
     */
    private String name;

    /***
     * 扩展点类型
     */
    private ExtensionPointType type;

    /**
     * 默认path
     */
    private String defaultPath;

    @Override
    public String getPoint() {
        return point;
    }

    @Override
    public String getDefaultPath() {
        return defaultPath;
    }
}
