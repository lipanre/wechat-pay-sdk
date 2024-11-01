package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * {@code description}
 * 退款订单信息
 *
 * <br>
 * {@code date} 2024/11/1 10:47
 */
@Data
public class RefundsOrderInfo {

    /**
     * 出资账户类型
     */
    private String account;

    /**
     * 出资金额
     */
    private Long amount;

}
