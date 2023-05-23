package me.jmfs.pattern.sdk.plugin.rpc;

import java.util.Map;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: rcp client response
 */
public class HttpRpcClientResponse {

    private int statusCode;

    private String content;

    private Map<String, String> headers;

    public HttpRpcClientResponse(int statusCode, String content, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.content = content;
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
