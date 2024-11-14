package com.lipanre.wechat.pay.sdk.model.response;

import com.lipanre.wechat.pay.sdk.enums.OrderState;
import com.lipanre.wechat.pay.sdk.enums.OrderStateDescription;
import com.lipanre.wechat.pay.sdk.model.OrderDetailModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public abstract class PayScoreOrderDetailResponse extends OrderDetailModel {
    /**
     * 商户号
     */
    private String mchid;
    /**
     * 服务订单状态
     */
    private OrderState state;
    /**
     * 订单状态说明
     */
    private OrderStateDescription stateDescription;

    /**
     * 微信支付服务订单号
     */
    private String orderId;
}
