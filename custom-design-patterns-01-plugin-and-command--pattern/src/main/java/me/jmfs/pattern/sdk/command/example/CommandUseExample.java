package me.jmfs.pattern.sdk.command.example;

import lombok.extern.slf4j.Slf4j;
import me.jmfs.pattern.sdk.command.executor.CommandExecutor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: command 模式使用案例(可直接作为SDK输出)
 *
 * 1、自定义 XXXCmd 继承 Command<Response>
 * 2、@Resource / @Autowired 引入命令执行器 CommandExecutor
 */
@Slf4j
@Component
public class CommandUseExample implements InitializingBean {

    @Resource
    private CommandExecutor commandExecutor;

    @Override
    public void afterPropertiesSet() throws Exception {

        int length = 5;
        String randomContent = commandExecutor.execute(new ExampleRandomStringByLengthCmd(length));
        log.info("[CommandUseExample] exec cmd , random string content length is : {}, content is: {}", length,
            randomContent);
    }
}
