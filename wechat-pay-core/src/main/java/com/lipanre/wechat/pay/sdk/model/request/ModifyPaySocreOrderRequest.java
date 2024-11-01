package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.model.OrderModel;
import com.lipanre.wechat.pay.sdk.model.PostDiscount;
import com.lipanre.wechat.pay.sdk.model.PostPayment;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * {@code description}
 * 修改订单请求
 *
 * <br>
 * {@code date} 2024/11/1 10:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyPaySocreOrderRequest extends OrderModel {

    /**
     * 后付费项目
     */
    private List<PostPayment> postPayments;

    /**
     * 后付费商户优惠
     */
    private List<PostDiscount> postDiscounts;

    /**
     * 总金额
     */
    private Long totalAmount;

    /**
     * 修改原因
     */
    private String reason;

}
