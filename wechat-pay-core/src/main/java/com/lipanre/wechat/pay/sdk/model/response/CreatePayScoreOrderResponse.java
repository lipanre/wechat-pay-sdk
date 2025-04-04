package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 创建订单响应
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CreatePayScoreOrderResponse extends PayScoreOrderDetailResponse {

    /**
     * 用于微信小程序跳转授权token
     */
    @JsonProperty("package")
    private String token;
}
