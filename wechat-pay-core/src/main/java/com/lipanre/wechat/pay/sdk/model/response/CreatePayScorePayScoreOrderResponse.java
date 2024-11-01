package com.lipanre.wechat.pay.sdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建订单响应
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreatePayScorePayScoreOrderResponse extends PayScoreOrderDetailResponse {

    /**
     * 用于微信小程序跳转授权token
     */
    ("package")
    private String token;
}
