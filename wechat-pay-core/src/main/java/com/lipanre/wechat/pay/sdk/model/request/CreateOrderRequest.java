package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.OrderDetailModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建订单请求对象
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateOrderRequest extends OrderDetailModel {

    /**
     * 用户标识
     */
    @JsonProperty("openid")
    private String openId;


    /**
     * 是否需要用户确认
     */
    @JsonProperty("need_user_confirm")
    private Boolean needUserConfirm;





}
