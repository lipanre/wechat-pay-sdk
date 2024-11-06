package com.lipanre.wechat.pay.sdk.notify;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lipanre.wechat.pay.sdk.WechatPayListener;
import com.lipanre.wechat.pay.sdk.exception.NotSupportEventTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * {@code description}
 * 回调事件类型
 *
 * <br>
 * {@code date} 2024/11/1 11:45
 */
@Getter
@RequiredArgsConstructor
public enum NotifyEventType {

    /**
     * 退款成功通知
     */
    REFUND_SUCCESS("REFUND.SUCCESS", RefundInfo.class,
            (listener, data) -> listener.onRefundSuccess((RefundInfo) data)),

    /**
     * 退款异常通知
     */
    REFUND_ABNORMAL("REFUND.ABNORMAL", RefundInfo.class,
            (listener, data) -> listener.onRefundAbnormal((RefundInfo) data)),

    /**
     * 退款关闭通知
     */
    REFUND_CLOSED("REFUND.CLOSED", RefundInfo.class,
            (listener, data) -> listener.onRefundClose((RefundInfo) data)),

    ;

    private final String code;

    /**
     * 通知的解密后的数据json的具体类型
     */
    private final Class<? extends CallbackInfo> clazz;

    /**
     * 数据处理函数
     */
    private final BiConsumer<WechatPayListener, CallbackInfo> consumer;



    @JsonCreator
    public static NotifyEventType getEventType(String code) {
        Optional<NotifyEventType> first = Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst();
        return first.orElseThrow(() -> new NotSupportEventTypeException("not support current callback event-type: " + code));
    }
}
