package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("account")
    private String account;

    /**
     * 出资金额
     */
    @JsonProperty("amount")
    private Long amount;

}
