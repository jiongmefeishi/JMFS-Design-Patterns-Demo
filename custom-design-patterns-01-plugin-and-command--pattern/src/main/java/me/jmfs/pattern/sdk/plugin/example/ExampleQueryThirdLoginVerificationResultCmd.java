package me.jmfs.pattern.sdk.plugin.example;

import com.google.common.base.Strings;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jmfs.pattern.sdk.command.Command;
import me.jmfs.pattern.sdk.command.context.CommandContext;
import me.jmfs.pattern.sdk.common.CommonRestResponse;
import me.jmfs.pattern.sdk.error.ApiServerErrorCode;
import me.jmfs.pattern.sdk.plugin.execute.ExtensionExecutable;
import me.jmfs.pattern.sdk.plugin.factory.ExtensionFactory;
import me.jmfs.pattern.sdk.plugin.point.ExtensionPoint;
import me.jmfs.pattern.sdk.plugin.request.ThirdLoginVerificationRequest;
import me.jmfs.pattern.sdk.plugin.result.ThirdLoginVerificationResult;
import me.jmfs.pattern.service.Extension;
import me.jmfs.pattern.service.PluginService;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 示例：根据插件扩展点获取扩展插件能力
 */
@Slf4j
@AllArgsConstructor
public class ExampleQueryThirdLoginVerificationResultCmd extends Command<Boolean> {

    private String extensionPoint;

    @Override
    public Boolean doInvoke(CommandContext commandContext) {

        // 根据扩展点，获取扩展能力
        Extension extension = commandContext.getComponent(PluginService.class).listActivatedExtension(
            ExtensionPoint.ThirdLoginVerification.getPoint());
        if (extension == null) {
            log.error(ApiServerErrorCode.NOT_FOUND_ACTIVATED_PLUGIN_EXTENSION_POINT.errorMessage());
            return null;
        }

        try {
            // 根据扩展点，获取扩展能力执行器
            ExtensionExecutable executor = ExtensionFactory.getInstance(ExtensionPoint.ThirdLoginVerification,
                extension.getEndpoint(),
                extension.getPath());

            // 执行扩展能力
            CommonRestResponse<ThirdLoginVerificationResult> response =
                executor.syncExecute(new ThirdLoginVerificationRequest(),
                new TypeToken<CommonRestResponse<ThirdLoginVerificationResult>>() {
                });
            if (response != null && !Strings.isNullOrEmpty(response.getData().getViewJson())) {
                // TODO 根据扩展执行结果判断认证状态
                return true;
            }
        } catch (Exception e) {
            log.error(ApiServerErrorCode.PLUGIN_EXTENSION_POINT_INVOKE_EXCEPTION.errorMessage() + e.getMessage(), e);
        }
        return false;
    }
}
