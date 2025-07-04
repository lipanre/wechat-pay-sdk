package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.model.Device;
import com.lipanre.wechat.pay.sdk.model.OrderDetailModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 创建订单请求对象
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CreatePayScoreOrderRequest extends OrderDetailModel {

    /**
     * 用户标识
     */
    private String openid;


    /**
     * 是否需要用户确认
     */
    private Boolean needUserConfirm;

    /**
     * 设备信息
     */
    private Device device;

}
