package me.jmfs.pattern.service.cmd;

import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.context.CommandContext;
import me.jmfs.pattern.service.Extension;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 查询激活状态扩展能力 list
 */
public class QueryActivatedExtensionListCmd extends Command<Extension> {

    private String extensionPoint;

    public QueryActivatedExtensionListCmd(String extensionPoint) {
        this.extensionPoint = extensionPoint;
    }

    @Override
    public Extension doInvoke(CommandContext commandContext) {
        return null;
    }
}
