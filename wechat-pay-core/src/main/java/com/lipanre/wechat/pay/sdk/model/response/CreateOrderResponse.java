package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建订单响应
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateOrderResponse extends OrderDetailResponse {

    /**
     * 用于微信小程序跳转授权token
     */
    @JsonProperty("package")
    private String token;


    /**
     * 是否需要用户确认
     */
    @JsonProperty("need_user_confirm")
    private Boolean needUserConfirm;


}
