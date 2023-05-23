package me.jmfs.pattern.sdk.command.example;

import cn.hutool.core.util.RandomUtil;
import lombok.AllArgsConstructor;
import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.context.CommandContext;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: cmd 案例: 根据传入的 length 返回长度固定的随机字符串
 */
@AllArgsConstructor
public class ExampleRandomStringByLengthCmd extends Command<String> {

    private int contentLength;

    @Override
    public String doInvoke(CommandContext commandContext) {

        // 可以通过 CommandContext 提供的getComponent方法，从Spring中捞取 bean 实例
        // ExampleDao dao = commandContext.getComponent(ExampleDao.class);
        // TODO 真实执行逻辑

        return RandomUtil.randomString(contentLength);
    }
}
