package me.jmfs.pattern.sdk.plugin.request.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 扩展执行请求
 */
@Data
public class ExecutableExtensionRequest implements ExtensionRequest {

    @JsonProperty("requestId")
    @SerializedName("requestId")
    private String requestId;

    public ExecutableExtensionRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}