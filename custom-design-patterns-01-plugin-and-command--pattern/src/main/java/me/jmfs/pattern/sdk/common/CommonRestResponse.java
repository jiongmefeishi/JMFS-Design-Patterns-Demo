package me.jmfs.pattern.sdk.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 通用结果
 */
@Data
@ToString
public class CommonRestResponse<T> implements Serializable {
    private static final long serialVersionUID = 7801949203978416054L;
    public static final Integer OK = 200;
    public static final Integer FAIL = 500;

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 响应码，200 为success
     */
    private Integer statusCode;

    /**
     * 是否成功标识
     */
    private Boolean success;

    /**
     * 错误码
     */
    private String code;

    /**
     * 返回的错误信息
     */
    private String message;

    /**
     * 返回的数据对象
     */
    private T data;

    public boolean isSuccess() {
        return OK.equals(statusCode);
    }

    public CommonRestResponse(String requestId, T data) {
        this.requestId = requestId;
        this.statusCode = OK;
        this.data = data;
    }

    public CommonRestResponse(String requestId, String errorCode, String errorMessage) {
        this.requestId = requestId;
        this.statusCode = FAIL;
        this.code = errorCode;
        this.message = errorMessage;
    }
}
