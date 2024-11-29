package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * 支付者
 */
@Data
public class Payer {

    /**
     * 【用户标识】 用户在普通商户AppID下的唯一标识。 下单前需获取到用户的OpenID
     */
    private String openid;
}