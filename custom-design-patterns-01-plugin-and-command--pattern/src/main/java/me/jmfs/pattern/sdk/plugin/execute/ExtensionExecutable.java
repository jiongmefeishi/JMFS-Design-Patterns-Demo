package me.jmfs.pattern.sdk.plugin.execute;

import com.google.gson.reflect.TypeToken;
import me.jmfs.pattern.sdk.common.CommonRestResponse;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 扩展执行器抽象接口
 */
public interface ExtensionExecutable<Request, Response> {

    /**
     * 获取扩展点
     *
     * @return 返回扩展点
     */
    String getPoint();

    /**
     * 定义与扩展实现通信时的URL
     *
     * @param endpoint 通信交互endpoint
     * @param path 通信URL
     */
    void defineUrl(String endpoint, String path, String defaultPath);

    /**
     * 同步调用
     * @param request 请求
     * @param responseTypeToken 类似 new TypeToken<RestResponse<Response>>() {}
     * @return 返回扩展调用结果
     */
    CommonRestResponse<Response> syncExecute(Request request, TypeToken responseTypeToken);
}
