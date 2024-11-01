package com.lipanre.wechat.pay.sdk.model.response;

import com.lipanre.wechat.pay.sdk.model.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 修改订单响应
 *
 * <br>
 * {@code date} 2024/11/1 10:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyPayScorePayScoreOrderResponse extends PayScoreOrderDetailResponse {

    /**
     * 商户收款总金额
     */
    private Long totalAmount;

    /**
     * 是否需要收款
     */
    private Boolean needCollection;

    /**
     * 收款信息
     */
    private Collection collection;



}
