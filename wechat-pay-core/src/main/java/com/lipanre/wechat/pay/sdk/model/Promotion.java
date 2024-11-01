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
    private String couponId;

    /**
     * 优惠名称
     */
    private String name;

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
    private Integer amount;

    /**
     * 活动ID
     */
    private String stockId;

    /**
     * 微信出资
     */
    private Integer wechatpayContribute;

    /**
     * 商户出资
     */
    private Long merchantContribute;

    /**
     * 其他出资
     */
    private Long otherContribute;

    /**
     * 优惠币种
     */
    private String currency;

    /**
     * 单品列表
     */
    private List<GoodsDetail> goodsDetail;
}
