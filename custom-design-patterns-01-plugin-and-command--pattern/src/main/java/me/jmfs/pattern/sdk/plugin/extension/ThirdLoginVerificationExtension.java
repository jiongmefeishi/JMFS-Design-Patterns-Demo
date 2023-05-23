package me.jmfs.pattern.sdk.plugin.extension;


import me.jmfs.pattern.sdk.plugin.execute.AbstractExecutableExtension;
import me.jmfs.pattern.sdk.plugin.extension.annotation.ExtensionDescriptor;
import me.jmfs.pattern.sdk.plugin.point.ExtensionPoint;
import me.jmfs.pattern.sdk.plugin.request.ThirdLoginVerificationRequest;
import me.jmfs.pattern.sdk.plugin.result.ThirdLoginVerificationResult;

@ExtensionDescriptor(name = "第三方登录认证扩展能力", desc = "第三方登录认证扩展能力")
public class ThirdLoginVerificationExtension extends AbstractExecutableExtension<ThirdLoginVerificationRequest, ThirdLoginVerificationResult> {

    @Override
    public String getPoint() {
        return ExtensionPoint.ThirdLoginVerification.getPoint();
    }
}
