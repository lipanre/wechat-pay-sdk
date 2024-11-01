package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lipanre
 */
@Data
public class OrderModel {
    /**
     * 商户服务订单号
     */
    @JsonProperty("out_order_no")
    private String outOrderNo;
    /**
     * 应用ID
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 服务ID
     */
    @JsonProperty("service_id")
    private String serviceId;

    public void apply(String appId, String serviceId) {
        this.appId = appId;
        this.serviceId = serviceId;
    }
}
