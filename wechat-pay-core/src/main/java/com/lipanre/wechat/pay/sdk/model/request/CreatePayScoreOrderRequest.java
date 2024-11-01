package com.lipanre.wechat.pay.sdk.model.request;

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
public class CreatePayScoreOrderRequest extends OrderDetailModel {

    /**
     * 用户标识
     */
    private String openid;


    /**
     * 是否需要用户确认
     */
    private Boolean needUserConfirm;





}
