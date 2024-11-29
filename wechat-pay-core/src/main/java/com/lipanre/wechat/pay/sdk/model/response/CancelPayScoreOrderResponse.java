package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.OrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 取消订单响应
 *
 * <br>
 * {@code date} 2024/11/1 9:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CancelPayScoreOrderResponse extends OrderModel {

    /**
     * 商户号
     */
    @JsonProperty("mchid")
    private String mchId;

    /**
     * 微信支付服务订单号
     */
    private String orderId;

}
