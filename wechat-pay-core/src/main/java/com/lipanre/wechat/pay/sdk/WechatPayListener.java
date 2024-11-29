package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.notify.AppletPayment;
import com.lipanre.wechat.pay.sdk.notify.PayScorePaymentInfo;
import com.lipanre.wechat.pay.sdk.notify.PayScoreRefundInfo;

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
    void onRefundSuccess(PayScoreRefundInfo refundInfo);

    /**
     * 退款异常回调
     *
     * @param refundInfo 退款信息
     */
    void onRefundAbnormal(PayScoreRefundInfo refundInfo);

    /**
     * 退款关闭回调
     *
     * @param refundInfo 退款信息
     */
    void onRefundClose(PayScoreRefundInfo refundInfo);

    /**
     * 用户授权成功时回调
     *
     * @param paymentInfo 支付回调信息
     */
    void onUserOpenService(PayScorePaymentInfo paymentInfo);

    /**
     * 用户关闭授权时回调
     *
     * @param paymentInfo 支付信息
     */
    void onUserCloseService(PayScorePaymentInfo paymentInfo);

    /**
     * 用户确认成功通知
     *
     * @param paymentInfo 支付信息
     */
    void onUserConfirm(PayScorePaymentInfo paymentInfo);

    /**
     * 用户支付成功时回调
     *
     * @param paymentInfo 支付信息
     */
    void onUserPaid(PayScorePaymentInfo paymentInfo);

    /**
     * 当小程序支付成功时回调
     *
     * @param appletPayment 小程序支付信息
     */
    void onAppletPaid(AppletPayment appletPayment);
}
