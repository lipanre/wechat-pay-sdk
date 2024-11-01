package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 同步订单响应
 *
 * <br>
 * {@code date} 2024/11/1 10:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SyncOrderResponse extends OrderDetailResponse {

    /**
     * 用户标识
     */
    private String openid;

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
