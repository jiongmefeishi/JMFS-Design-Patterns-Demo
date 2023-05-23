package me.jmfs.pattern.sdk.plugin.extension;

import me.jmfs.pattern.sdk.plugin.execute.AbstractExecutableExtension;
import me.jmfs.pattern.sdk.plugin.extension.annotation.ExtensionDescriptor;
import me.jmfs.pattern.sdk.plugin.point.ExtensionPoint;
import me.jmfs.pattern.sdk.plugin.request.ThirdTwoFactorAuthRequest;
import me.jmfs.pattern.sdk.plugin.result.ThirdTwoFactorAuthExecutionResult;

@ExtensionDescriptor(name = "第三方双因子认证扩展能力", desc = "第三方双因子认证扩展能力")
public class ThirdAuthTwoFactorTokenExtension
    extends AbstractExecutableExtension<ThirdTwoFactorAuthRequest, ThirdTwoFactorAuthExecutionResult> {

    @Override
    public String getPoint() {
        return ExtensionPoint.ThirdAuthTwoFactorToken.getPoint();
    }
}
