package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * {@code description}
 *
 *
 * <br>
 * {@code date} 2024/11/1 13:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundOrderDetailModel extends RefundOrderModel {
    /**
     * 微信支付退款单号
     */
    private String refundId;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 退款入账账户
     */
    private String userReceivedAccount;
    /**
     * 退款成功时间
     */
    private LocalDateTime successTime;
    /**
     * 金额信息
     */
    private Amount amount;
}
