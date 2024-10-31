package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lipanre
 */
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
}
