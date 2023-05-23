package me.jmfs.pattern.sdk.command;

import me.jmfs.pattern.sdk.command.context.CommandContext;
import me.jmfs.pattern.sdk.command.listener.CommandListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/16
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令顶层抽象
 *
 * CQRS 模式 : 命令和查询责任分离
 */
public abstract class Command<Response> {

    private List<CommandListener<Response>> listeners = new ArrayList<>();

    public Response execute(CommandContext commandContext) {
        listeners.stream().forEach(listener -> listener.beforeInvoke(this));
        Response response = doInvoke(commandContext);
        listeners.stream().forEach(listener -> listener.afterInvoke(this, response));
        return response;
    }

    public abstract Response doInvoke(CommandContext commandContext);

    public Command<Response> addListeners(CommandListener<Response> listener) {
        this.listeners.add(listener);
        return this;
    }
}
