package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.model.OrderDetailModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 完结订单请求
 *
 * <br>
 * {@code date} 2024/11/1 10:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CompletePayScoreOrderRequest extends OrderDetailModel {

    /**
     * 总金额
     */
    private Long totalAmount;

    /**
     * 微信支付服务分账标记
     */
    private Boolean profitSharing;

    /**
     * 订单优惠标记
     */
    private String goodsTag;

}
