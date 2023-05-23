package me.jmfs.pattern.sdk.plugin.execute;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import me.jmfs.pattern.sdk.common.CommonRestResponse;
import me.jmfs.pattern.sdk.common.RestResponseUtil;
import me.jmfs.pattern.sdk.plugin.rpc.HttpRpcClientResponse;
import me.jmfs.pattern.sdk.plugin.rpc.HttpRpcClientUtil;

import static me.jmfs.pattern.sdk.error.ApiServerErrorCode.PLUGIN_EXTENSION_POINT_INVOKE_EXCEPTION;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 抽象扩展执行器
 */
@Slf4j
public abstract class AbstractExecutableExtension<Request, Response>
    implements ExtensionExecutable<Request, Response>, Cloneable {

    private static final String URL_PREFIX = "http://";
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * 插件保留的服务地址
     */
    private String endpoint;

    /**
     * 用户自定义的扩展点path，为空时使用默认path
     */
    private String path;

    /**
     * 调用外部扩展实现, 请求体统一设置为body，并采用JSON格式
     *
     * @param request 请求
     * @return 扩展插件调用结果
     */
    @Override
    public CommonRestResponse<Response> syncExecute(Request request, TypeToken responseTypeToken) {
        try {
            log.info("Extension invoke before path {} request {} ", path, request);
            HttpRpcClientResponse response = HttpRpcClientUtil.getInstance().post(getUrl(), gson.toJson(request),
                HttpRpcClientUtil.JSON_CONTENT_TYPE);
            log.info("Extension invoke after path {} request {} response {}", path, request, response.getContent());
            if (response != null && !Strings.isNullOrEmpty(response.getContent())) {
                return gson.fromJson(response.getContent(), responseTypeToken.getType());
            }
        } catch (Throwable e) {
            log.error("PluginExtensionInvokeException", "{extension}", getPoint(), e);
            return RestResponseUtil.addErrorData(PLUGIN_EXTENSION_POINT_INVOKE_EXCEPTION);
        }

        return RestResponseUtil.addErrorData(PLUGIN_EXTENSION_POINT_INVOKE_EXCEPTION);
    }

    @Override
    public void defineUrl(String endpoint, String path, String defaultPath) {
        Preconditions.checkNotNull(endpoint);
        this.endpoint = endpoint;
        if (!Strings.isNullOrEmpty(path)) {
            this.path = path;
        } else {
            this.path = defaultPath;
        }
    }

    public String getUrl() {
        StringBuilder urlBuilder = new StringBuilder("");
        if (!endpoint.startsWith("http")) {
            urlBuilder.append(URL_PREFIX);
        }
        urlBuilder.append(endpoint);
        if (path.startsWith("/")) {
            urlBuilder.append(path);
        } else {
            urlBuilder.append("/");
            urlBuilder.append(path);
        }
        return urlBuilder.toString();
    }
}
