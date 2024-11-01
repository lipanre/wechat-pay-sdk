package com.lipanre.wechat.pay.sdk.notify;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

/**
 * {@code description}
 * 回调事件类型
 *
 * <br>
 * {@code date} 2024/11/1 11:45
 */
@RequiredArgsConstructor
public enum NotifyEventType {

    /**
     * 退款成功通知
     */
    REFUND_SUCCESS("REFUND.SUCCESS"),

    /**
     * 退款异常通知
     */
    REFUND_ABNORMAL("REFUND.ABNORMAL"),

    /**
     * 退款关闭通知
     */
    REFUND_CLOSED("REFUND.CLOSED"),

    ;

    private final String code;

    @JsonCreator
    public static NotifyEventType getEventType(String code) {
        Optional<NotifyEventType> first = Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst();
        return first.orElseThrow(() -> new RuntimeException("not support current callback event-type: " + code));
    }
}
