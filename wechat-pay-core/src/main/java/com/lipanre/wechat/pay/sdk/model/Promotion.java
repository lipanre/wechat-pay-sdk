package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.PromotionScope;
import com.lipanre.wechat.pay.sdk.enums.PromotionType;
import lombok.Data;

import java.util.List;

/**
 * 优惠信息
 *
 * @author lipanre
 */
@Data
public class Promotion {

    /**
     * 券ID
     */
    @JsonProperty("coupon_id")
    private String couponId;

    /**
     * 优惠名称
     */
    @JsonProperty("name")
    private String name;

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
     * 优惠券面额
     */
    @JsonProperty("amount")
    private Integer amount;

    /**
     * 活动ID
     */
    @JsonProperty("stock_id")
    private String stockId;

    /**
     * 微信出资
     */
    @JsonProperty("wechatpay_contribute")
    private Integer wechatpayContribute;

    /**
     * 商户出资
     */
    @JsonProperty("merchant_contribute")
    private Long merchantContribute;

    /**
     * 其他出资
     */
    @JsonProperty("other_contribute")
    private Long otherContribute;

    /**
     * 优惠币种
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * 单品列表
     */
    @JsonProperty("goods_detail")
    private List<GoodsDetail> goodsDetail;
}
