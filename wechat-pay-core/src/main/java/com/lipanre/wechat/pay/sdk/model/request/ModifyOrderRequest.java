package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ModifyOrderRequest extends OrderModel {

    /**
     * 后付费项目
     */
    @JsonProperty("post_payments")
    private List<PostPayment> postPayments;

    /**
     * 后付费商户优惠
     */
    @JsonProperty("post_discounts")
    private List<PostDiscount> postDiscounts;

    /**
     * 总金额
     */
    @JsonProperty("total_amount")
    private Long totalAmount;

    /**
     * 修改原因
     */
    @JsonProperty("reason")
    private String reason;

}
