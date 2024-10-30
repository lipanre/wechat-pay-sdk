package com.lipanre.wechat.pay.sdk.config;

import lombok.Data;

/**
 * 微信支付配置属性
 *
 * @author lipanre
 */
@Data
public class PayProperties {

    /**
     * 微信服务id
     * <br>
     * 获取方式：联系微信官方运营人员
     */
    private String serviceId;

    /**
     * 与商户绑定的appId
     * <br>
     * 获取方式：<a href="https://developers.weixin.qq.com/community/develop/article/doc/0002ea97958958f87389d9a2b5fc13">获取APPID</a>
     */
    private String appId;

}
