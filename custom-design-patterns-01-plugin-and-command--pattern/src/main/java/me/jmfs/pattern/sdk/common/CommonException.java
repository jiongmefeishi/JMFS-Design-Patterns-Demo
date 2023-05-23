package me.jmfs.pattern.sdk.common;

import com.google.common.base.Strings;
import lombok.Getter;
import me.jmfs.pattern.sdk.error.CommonErrorCode;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 通用异常
 */
@Getter
public class CommonException extends RuntimeException{

    private CommonErrorCode commonErrorCode;
    private CommonResultCode commonResultCode;

    public CommonException(CommonResultCode commonResultCode, CommonErrorCode commonErrorCode, String message) {
        super(message);
        this.commonErrorCode = commonErrorCode;
        this.commonResultCode = commonResultCode;
    }

    public CommonException(CommonResultCode commonResultCode, CommonErrorCode commonErrorCode, Throwable cause) {
        super(cause);
        this.commonErrorCode = commonErrorCode;
        this.commonResultCode = commonResultCode;
    }

    @Override
    public String getMessage() {
        if (!Strings.isNullOrEmpty(super.getMessage())) {
            return commonErrorCode.getDesc();
        }
        return commonErrorCode.getDesc() + "(" + super.getMessage() + ")";
    }
}
