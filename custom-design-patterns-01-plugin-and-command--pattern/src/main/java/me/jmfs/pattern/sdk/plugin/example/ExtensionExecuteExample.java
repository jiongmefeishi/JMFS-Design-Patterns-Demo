package me.jmfs.pattern.sdk.plugin.example;

import lombok.extern.slf4j.Slf4j;
import me.jmfs.pattern.sdk.command.executor.CommandExecutor;
import me.jmfs.pattern.sdk.plugin.point.ExtensionPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 扩展执行示例
 */
@Slf4j
@Component
public class ExtensionExecuteExample implements InitializingBean {

    @Resource
    private CommandExecutor commandExecutor;

    @Override
    public void afterPropertiesSet() throws Exception {
        Boolean verificationResult =
            commandExecutor.execute(new ExampleQueryThirdLoginVerificationResultCmd(ExtensionPoint.ThirdLoginVerification.getPoint()));
        log.info("ExtensionExecuteExample exec ExampleQueryThirdLoginVerificationResultCmd, result is : {}", verificationResult);
    }
}
