### 扩展插件模式

场景来源：系统要进行能力扩展，采用的方式是在源码中引入外部SDK，运维升级带来了极大的成本

定义各个能力的扩展点，所有扩展点由外部扩展服务实现来定义,定义扩展点的标准API，用户实现具体扩展逻辑。


### 新增扩展能力步骤
例如增加第三方登录认证扩展能力

#### 新增扩展点&通信path

ExtensionPoint
```java
public enum ExtensionPoint implements IExtensionPoint {
    ThirdAuthTwoFactorToken("ThirdAuthTwoFactorToken", "第三方双因子认证扩展能力", ExtensionPointType.Action, "/thirdAuthTwoFactorToken"),
    ThirdLoginVerification("ThirdLoginVerification", "第三方登录认证扩展能力", ExtensionPointType.Action, "/thirdLoginVerification"),
    ;
}
```

#### 新增扩展能力对应的独特请求&返回
新增扩展能力执行请求
```java
@Data
@NoArgsConstructor
public class ThirdLoginVerificationRequest implements ExtensionRequest, Serializable {

}
```

新增扩展能力执行结果
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdLoginVerificationResult {

}
```

#### 定义扩展能力执行器
扩展能力执行器继承抽象扩展执行器、配置扩展请求&返回

```java
@ExtensionDescriptor(name = "第三方登录认证扩展能力", desc = "第三方登录认证扩展能力")
public class ThirdLoginVerificationExtension extends AbstractExecutableExtension<ThirdLoginVerificationRequest, ThirdLoginVerificationResult> {

    @Override
    public String getPoint() {
        return ExtensionPoint.ThirdLoginVerification.getPoint();
    }
}
```

#### 扩展能力执行
```java

```


### Command模式,CQRS
Command命令执行模式，职责分离，单独Command只执行自己的任务。

cmd 案例: 根据传入的 length 返回长度固定的随机字符串
1、定义 ExampleRandomStringByLengthCmd 继承 Command<Response>
```java
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
```

@Resource / @Autowired 引入命令执行器 CommandExecutor

```java
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
```

