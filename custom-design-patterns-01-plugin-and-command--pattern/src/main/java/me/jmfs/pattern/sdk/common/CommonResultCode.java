package me.jmfs.pattern.sdk.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResultCode {

    SUCCESS(200, "operation success"),
    FAILURE(500, "operation failure")
    ;

    private int code;
    private String desc;
}
