package me.jmfs.pattern.sdk.command.config;

import me.jmfs.pattern.sdk.command.context.CommandContextFactory;
import me.jmfs.pattern.sdk.command.executor.CommandExecutor;
import me.jmfs.pattern.sdk.command.executor.DefaultCommandExecutor;
import me.jmfs.pattern.sdk.command.interceptor.CommandContextInterceptor;
import me.jmfs.pattern.sdk.command.interceptor.CommandInterceptor;
import me.jmfs.pattern.sdk.command.invoker.DefaultCommandInvoker;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 命令配置，包括bean注入（拦截器，执行器）
 */
@Configuration
public class CommandConfig {

    /**
     * 记录需要装配的命令拦截器
     */
    private List<CommandInterceptor> commandInterceptors = new ArrayList<>(8);

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 注册命令拦截器，显示注册
     */
    private void registerCommandInterceptor() {
        // 命令执行拦截器
        commandInterceptors.add(new CommandContextInterceptor(new CommandContextFactory(applicationContext)));
        // 默认命令拦截器
        commandInterceptors.add(new DefaultCommandInvoker());
    }

    /**
     * Spring bean 注册 CommandExecutor
     */
    @Bean
    public CommandExecutor commandExecutor() {
        registerCommandInterceptor();
        CommandInterceptor first = initInterceptorChain(commandInterceptors);
        return new DefaultCommandExecutor(new CommandConfiguration(), first);
    }

    /**
     * 初始化拦截器调用链
     * @param chain 调用链
     * @return 命令拦截器
     */
    public CommandInterceptor initInterceptorChain(List<CommandInterceptor> chain) {
        if (chain == null || chain.isEmpty()) {
            throw new BeanCreationException("invalid command interceptor chain configuration: " + chain);
        }
        AnnotationAwareOrderComparator.sort(chain);
        for (int i = 0; i < chain.size() - 1; i++) {
            chain.get(i).setNext(chain.get(i + 1));
        }
        return chain.get(0);
    }

}
