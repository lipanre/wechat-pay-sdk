package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lipanre.wechat.pay.sdk.common.Constant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
@ToString(callSuper = true)
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
    @JsonFormat(pattern = Constant.API_DATE_PATTERN)
    private LocalDateTime successTime;
    /**
     * 金额信息
     */
    private Amount amount;
}
