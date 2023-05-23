package me.jmfs.pattern.sdk.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 通用请求
 */
@Data
public class CommonRestRequest<T> implements Serializable {
    private static final long serialVersionUID = -1;

    /**
     * 请求ID，可采用UUID
     */
    private String requestId;

    /**
     * 访问数据license
     */
    private String accessKeySecret;

    /**
     * 请求体
     */
    private T data;

    /**
     * 数据签名
     */
    private String sign;
}
