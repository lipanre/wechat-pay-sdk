package com.lipanre.wechat.pay.sdk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.PromotionScope;
import com.lipanre.wechat.pay.sdk.enums.PromotionType;
import lombok.Data;

/**
 * {@code description}
 * 退款优惠信息
 *
 * <br>
 * {@code date} 2024/11/1 11:09
 */
@Data
public class RefundPromotionInfo {

    /**
     * 券ID
     */
    @JsonProperty("promotion_id")
    private String promotionId;

    /**
     * 优惠范围
     */
    @JsonProperty("scope")
    private PromotionScope scope;

    /**
     * 优惠类型
     */
    @JsonProperty("type")
    private PromotionType type;

    /**
     * 优惠退款金额
     */
    @JsonProperty("refund_amount")
    private Long refundAmount;



}
