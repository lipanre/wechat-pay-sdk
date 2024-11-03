package com.lipanre.wechat.pay.sdk;

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

}
