package me.jmfs.pattern.sdk.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrorCode {

    COMMAND_EXECUTE_ERROR(5001, "命令执行失败")
    ;

    private int code;
    private String desc;
}
