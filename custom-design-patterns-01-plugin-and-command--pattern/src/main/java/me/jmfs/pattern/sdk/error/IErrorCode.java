package me.jmfs.pattern.sdk.error;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 错误顶层接口
 */
public interface IErrorCode {

    Integer code();

    String errorCode();

    String errorMessage();

}
