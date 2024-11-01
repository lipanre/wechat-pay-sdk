package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.Currency;
import lombok.Data;

/**
 * {@code description}
 * 金额信息
 *
 * <br>
 * {@code date} 2024/11/1 10:41
 */
@Data
public class Amount {


    /**
     * 退款金额
     */
    @JsonProperty("refund")
    private Long  refund;

    /**
     * 退款出资账户及金额
     */
    @JsonProperty("from")
    private RefundsOrderInfo from;

    /**
     * 原订单金额
     */
    @JsonProperty("total")
    private Long total;

    /**
     * 退款币种
     */
    @JsonProperty("currency")
    private Currency currency;

    /**
     * 用户支付金额
     */
    @JsonProperty("payer_total")
    private Long payerTotal;

    /**
     * 用户退款金额
     */
    @JsonProperty("payer_refund")
    private Long payerRefund;

    /**
     * 应结退款金额
     */
    @JsonProperty("settlement_refund")
    private Long settlementRefund;

    /**
     * 应结订单金额
     */
    @JsonProperty("settlement_total")
    private Long settlementTotal;

    /**
     * 优惠退款金额
     */
    @JsonProperty("discount_refund")
    private Long discountRefund;

    /**
     * 手续费退款金额
     */
    @JsonProperty("refund_fee")
    private Long refundFee;

}
