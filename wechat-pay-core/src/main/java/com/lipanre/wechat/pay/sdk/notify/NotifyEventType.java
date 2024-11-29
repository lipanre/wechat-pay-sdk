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
    REFUND_SUCCESS("REFUND.SUCCESS", PayScoreRefundInfo.class,
            (listener, data) -> listener.onRefundSuccess((PayScoreRefundInfo) data)),

    /**
     * 退款异常通知
     */
    REFUND_ABNORMAL("REFUND.ABNORMAL", PayScoreRefundInfo.class,
            (listener, data) -> listener.onRefundAbnormal((PayScoreRefundInfo) data)),

    /**
     * 退款关闭通知
     */
    REFUND_CLOSED("REFUND.CLOSED", PayScoreRefundInfo.class,
            (listener, data) -> listener.onRefundClose((PayScoreRefundInfo) data)),


    /**
     * 授权成功通知
     */
    PAYSCORE_USER_OPEN_SERVICE("PAYSCORE.USER_OPEN_SERVICE", PayScorePaymentInfo.class,
            (listener, data) -> listener.onUserOpenService((PayScorePaymentInfo) data)),

    /**
     * 解除授权成功通知
     */
    PAYSCORE_USER_CLOSE_SERVICE("PAYSCORE.USER_CLOSE_SERVICE", PayScorePaymentInfo.class,
            (listener, data) -> listener.onUserCloseService((PayScorePaymentInfo) data)),

    /**
     * 用户确认成功通知
     */
    PAYSCORE_USER_CONFIRM("PAYSCORE.USER_CONFIRM", PayScorePaymentInfo.class,
            (listener, data) -> listener.onUserConfirm((PayScorePaymentInfo) data)),

    /**
     * 支付成功通知
     */
    PAYSCORE_USER_PAID("PAYSCORE.USER_PAID", PayScorePaymentInfo.class,
            (listener, data) -> listener.onUserPaid((PayScorePaymentInfo) data)),

    TRANSACTION_SUCCESS("TRANSACTION.SUCCESS", AppletPayment.class,
            (listener, data) -> listener.onAppletPaid((AppletPayment) data)),
    ;

    private final String code;

    /**
     * 通知的解密后的数据json的具体类型
     */
    private final Class<? extends CallbackInfo> clazz;

    /**
     * 数据处理策略
     */
    private final BiConsumer<WechatPayListener, CallbackInfo> strategy;



    @JsonCreator
    public static NotifyEventType getEventType(String code) {
        Optional<NotifyEventType> first = Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst();
        return first.orElseThrow(() -> new NotSupportEventTypeException("not support current callback event-type: " + code));
    }
}
