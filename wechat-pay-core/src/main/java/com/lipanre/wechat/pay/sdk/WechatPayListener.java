package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.notify.CallbackInfo;
import com.lipanre.wechat.pay.sdk.notify.PaymentInfo;
import com.lipanre.wechat.pay.sdk.notify.RefundInfo;

/**
 * {@code description}
 * 微信支付监听器
 *
 * <br>
 * {@code date} 2024/11/1 13:24
 */
public interface WechatPayListener {

    /**
     * 退款成功回调
     *
     * @param refundInfo 退款信息
     */
    void onRefundSuccess(RefundInfo refundInfo);

    /**
     * 退款异常回调
     *
     * @param refundInfo 退款信息
     */
    void onRefundAbnormal(RefundInfo refundInfo);

    /**
     * 退款关闭回调
     *
     * @param refundInfo 退款信息
     */
    void onRefundClose(RefundInfo refundInfo);

    /**
     * 用户授权成功时回调
     *
     * @param paymentInfo 支付回调信息
     */
    void onUserOpenService(PaymentInfo paymentInfo);

    /**
     * 用户关闭授权时回调
     *
     * @param paymentInfo 支付信息
     */
    void onUserCloseService(PaymentInfo paymentInfo);

    /**
     * 用户确认成功通知
     *
     * @param paymentInfo 支付信息
     */
    void onUserConfirm(PaymentInfo paymentInfo);

    /**
     * 用户支付成功时回调
     *
     * @param paymentInfo 支付信息
     */
    void onUserPaid(PaymentInfo paymentInfo);
}
