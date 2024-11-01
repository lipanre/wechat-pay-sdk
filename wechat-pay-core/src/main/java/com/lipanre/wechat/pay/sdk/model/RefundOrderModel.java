package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * {@code description}
 *
 *
 * <br>
 * {@code date} 2024/11/1 11:21
 */
@Data
public class RefundOrderModel {
    /**
     * 微信支付订单号
     */
    private String transactionId;
    /**
     * 商户退款单号
     */
    private String outRefundNo;
    /**
     * 金额信息
     */
    private Amount amount;

}
