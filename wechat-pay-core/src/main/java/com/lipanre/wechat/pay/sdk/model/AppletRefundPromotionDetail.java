package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

import java.util.List;

/**
 * 小程序退款优惠信息
 *
 * @author lipanre
 */
@Data
public class AppletRefundPromotionDetail {

    /**
     * 【券ID】代金券id，单张代金券的编号
     */
    private String promotionId;

    /**
     * 【优惠退款金额】 代金券退款的金额
     */
    private Long refundAmount;

    /**
     * 【退款商品】 指定商品退款时传的退款商品信息。
     */
    private List<OrderGoodsDetail> goodsDetail;

}
