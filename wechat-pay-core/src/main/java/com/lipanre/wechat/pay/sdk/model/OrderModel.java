package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * @author lipanre
 */
@Data
public abstract class OrderModel {
    /**
     * 商户服务订单号
     */
    private String outOrderNo;
    /**
     * 应用ID
     */
    private String appid;
    /**
     * 服务ID
     */
    private String serviceId;

    public void apply(String appId, String serviceId) {
        this.appid = appId;
        this.serviceId = serviceId;
    }
}
