package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

@Data
public class SceneInfo {

    /**
     * 【用户终端IP】 用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。
     */
    private String payerClientIp;

    /**
     * 【商户端设备号】 商户端设备号（门店号或收银设备ID）。
     */
    private String deviceId;

    /**
     * 【商户门店信息】 商户门店信息
     */
    private StoreInfo storeInfo;

    @Data
    public static class StoreInfo {

        /**
         * 【门店编号】 商户侧门店编号
         */
        private String id;

        /**
         * 【门店名称】 商户侧门店名称
         */
        private String name;

        /**
         * 【地区编码】 地区编码，详细请见省市区编号对照表。
         */
        private String areaCode;

        /**
         * 【详细地址】 详细的商户门店地址
         */
        private String address;

    }
}