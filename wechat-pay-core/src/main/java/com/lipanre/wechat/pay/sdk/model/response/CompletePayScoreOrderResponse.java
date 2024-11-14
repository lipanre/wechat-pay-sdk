package com.lipanre.wechat.pay.sdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 完结订单响应
 *
 * <br>
 * {@code date} 2024/11/1 10:19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CompletePayScoreOrderResponse extends PayScoreOrderDetailResponse {

    /**
     * 商户收款总金额
     */
    private Long totalAmount;

    /**
     * 是否需要收款
     */
    private Boolean needCollection;

}
