package me.jmfs.pattern.sdk.error;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: api 服务错误码
 */
public enum ApiServerErrorCode implements IErrorCode {
    PARAMETER_ILLEGAL_API_PARAM_MISS(400001, "ApiParamEmpty", "非法的参数,Api参数缺失"),
    NoAuthority(400003, "NoAuthority", "用户未授权"),
    SERVER_INNER_ERROR(500000, "ServerInnerError", "服务端内部错误"),
    SERVER_API_REQ_ERROR(500001, "ApiRequestError", "API请求失败"),
    SERVER_API_RES_PARSE_ERROR(500002, "ApiResponseParseError", "API响应解析失败"),
    PARAMETER_ILLEGAL_LICENSE(500003, "LicenseIllegal", "License不合法"),
    NOT_FOUND_PLUGIN_EXTENSION_POINT(500101, "NotFoundPluginExtensionPoint", "未发现插件扩展点"),
    NOT_FOUND_ACTIVATED_PLUGIN_EXTENSION_POINT(500102, "NotFoundActivatedPluginExtensionPoint", "未发现激活的插件扩展点"),
    PLUGIN_EXTENSION_POINT_INVOKE_EXCEPTION(500103, "PluginExtensionPointInvokeError", "插件扩展调用失败"),
    ;

    private Integer code;
    private String errorCode;
    private String errorMessage;

    ApiServerErrorCode(Integer code, String errorCode, String errorMessage) {
        this.code = code;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String errorCode() {
        return this.errorCode;
    }

    @Override
    public String errorMessage() {
        return this.errorMessage;
    }
}
