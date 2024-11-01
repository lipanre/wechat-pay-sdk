package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询订单响应
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchOrderResponse extends OrderDetailResponse {


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

    /**
     * 用户标识
     */
    private String openid;

}
