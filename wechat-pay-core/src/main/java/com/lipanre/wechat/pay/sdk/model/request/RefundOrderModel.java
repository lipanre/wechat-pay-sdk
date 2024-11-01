package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.RefundsGoodsDetail;
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
    @JsonProperty("transaction_id")
    private String transactionId;
    /**
     * 商户退款单号
     */
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    /**
     * 金额信息
     */
    @JsonProperty("amount")
    private Amount amount;

}
