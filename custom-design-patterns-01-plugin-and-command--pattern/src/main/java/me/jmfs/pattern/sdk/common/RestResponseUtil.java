package me.jmfs.pattern.sdk.common;

import me.jmfs.pattern.sdk.error.IErrorCode;

import java.util.UUID;

public class RestResponseUtil {

    public static <T> CommonRestResponse<T> addSuccessData(T data) {
        return addData(200, null, null, data);
    }

    /**
     * 返回错误响应
     * @param code 状态码
     * @param errorCode 错误码
     * @param message 错误信息
     * @param data 数据
     */
    public static <T> CommonRestResponse<T> addErrorData(Integer code, String errorCode, String message, T data) {
        return addData(code, errorCode, message, data);
    }

    public static <T> CommonRestResponse<T> addErrorData(Integer code, String errorCode, String message) {
        return addData(code, errorCode, message, null);
    }

    public static <T> CommonRestResponse addErrorData(IErrorCode iErrorCode) {
        return addData(iErrorCode.code(), iErrorCode.errorCode(), iErrorCode.errorMessage(),null);
    }

    public static <T> CommonRestResponse addErrorData(CommonRestResponse response) {
        CommonRestResponse commonRestResponse = new CommonRestResponse(response.getRequestId(),response.getCode(),response.getMessage());
        commonRestResponse.setStatusCode(response.getStatusCode());
        commonRestResponse.setSuccess(response.getSuccess());
        return commonRestResponse;
    }

    private static <T> CommonRestResponse<T> addData(Integer code, String errorCode, String message, T data) {
        CommonRestResponse<T> commonRestResponse = new CommonRestResponse<T>(getRequestId(), data);
        commonRestResponse.setStatusCode(code);
        commonRestResponse.setCode(errorCode);
        commonRestResponse.setMessage(message);
        commonRestResponse.setSuccess(CommonRestResponse.OK.equals(code));
        return commonRestResponse;
    }

    private static String getRequestId() {
        return UUID.randomUUID().toString();
    }
}
