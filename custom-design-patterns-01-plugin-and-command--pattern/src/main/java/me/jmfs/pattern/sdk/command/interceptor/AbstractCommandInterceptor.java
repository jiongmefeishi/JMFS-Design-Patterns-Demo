package me.jmfs.pattern.sdk.command.interceptor;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 顶层抽象命令拦截器
 */
public abstract class AbstractCommandInterceptor implements CommandInterceptor {

    /**
     * 下一个命令拦截器
     */
    protected CommandInterceptor next;

    @Override
    public CommandInterceptor getNext() {
        return next;
    }

    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }

}
