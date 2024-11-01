package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.OrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 取消订单请求
 *
 * <br>
 * {@code date} 2024/11/1 9:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CancelOrderRequest extends OrderModel {

    /**
     * 取消原因
     */
    @JsonProperty("reason")
    private String reason;

}
