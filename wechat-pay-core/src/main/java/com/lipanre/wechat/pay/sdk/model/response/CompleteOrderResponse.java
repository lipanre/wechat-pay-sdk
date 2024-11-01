package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 完结订单响应
 *
 * <br>
 * {@code date} 2024/11/1 10:19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CompleteOrderResponse extends OrderDetailResponse {

    /**
     * 商户收款总金额
     */
    @JsonProperty("total_amount")
    private Long totalAmount;

    /**
     * 是否需要收款
     */
    @JsonProperty("need_collection")
    private Boolean needCollection;

}
