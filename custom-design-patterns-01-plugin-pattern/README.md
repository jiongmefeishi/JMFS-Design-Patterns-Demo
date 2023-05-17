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


