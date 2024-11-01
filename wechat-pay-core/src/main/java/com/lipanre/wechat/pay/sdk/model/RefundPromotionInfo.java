package com.lipanre.wechat.pay.sdk.model;

import com.lipanre.wechat.pay.sdk.enums.PromotionScope;
import com.lipanre.wechat.pay.sdk.enums.PromotionType;
import lombok.Data;

import java.util.List;

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
    private String promotionId;

    /**
     * 优惠范围
     */
    private PromotionScope scope;

    /**
     * 优惠类型
     */
    private PromotionType type;

    /**
     * 优惠券面额
     */
    private Long amount;

    /**
     * 优惠退款金额
     */
    private Long refundAmount;

    /**
     * 商品列表
     */
    private List<RefundsGoodsDetail> goodsDetail;

}
