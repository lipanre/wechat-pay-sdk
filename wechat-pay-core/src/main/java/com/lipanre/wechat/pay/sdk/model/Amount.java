package com.lipanre.wechat.pay.sdk.model;

import com.lipanre.wechat.pay.sdk.enums.Currency;
import lombok.Data;

import java.util.List;

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
    private Long refund;

    /**
     * 退款出资账户及金额
     */
    private List<RefundsOrderInfo> from;

    /**
     * 原订单金额
     */
    private Long total;

    /**
     * 退款币种
     */
    private Currency currency;

    /**
     * 用户支付币种
     */
    private Currency payerCurrency;

    /**
     * 用户支付金额
     */
    private Long payerTotal;

    /**
     * 用户退款金额
     */
    private Long payerRefund;

    /**
     * 应结退款金额
     */
    private Long settlementRefund;

    /**
     * 应结订单金额
     */
    private Long settlementTotal;

    /**
     * 优惠退款金额
     */
    private Long discountRefund;

    /**
     * 手续费退款金额
     */
    private Long refundFee;

}
