package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.OrderState;
import com.lipanre.wechat.pay.sdk.enums.OrderStateDescription;
import com.lipanre.wechat.pay.sdk.model.OrderDetailModel;

/**
 * @author lipanre
 */
public abstract class OrderDetailResponse extends OrderDetailModel {
    /**
     * 商户号
     */
    @JsonProperty("mchid")
    private String mchId;
    /**
     * 服务订单状态
     */
    @JsonProperty("state")
    private OrderState state;
    /**
     * 订单状态说明
     */
    @JsonProperty("state_description")
    private OrderStateDescription stateDescription;

    /**
     * 微信支付服务订单号
     */
    @JsonProperty("order_id")
    private String orderId;
}
