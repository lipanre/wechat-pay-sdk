package com.lipanre.wechat.pay.sdk.exception;

/**
 * {@code description}
 * 不支持的事件类型异常
 *
 * <br>
 * {@code date} 2024/11/1 12:01
 */
public class NotSupportEventTypeException extends RuntimeException {


    public NotSupportEventTypeException(String message) {
        super(message);
    }
}
