package com.lipanre.wechat.pay.sdk.model;

import com.lipanre.wechat.pay.sdk.enums.Currency;
import lombok.Data;

import java.util.List;

/**
 * 小程序优惠明细
 *
 * @author lipanre
 */
@Data
public class AppletPromotionDetail {

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
    private Long amount;

    /**
     * 活动ID
     */
    private String stockId;

    /**
     * 微信出资，单位为分
     */
    private Long wechatpayContribute;

    /**
     * 商户出资，单位为分
     */
    private Long merchantContribute;

    /**
     * 其他出资，单位为分
     */
    private Long otherContribute;

    /**
     * CNY：人民币，境内商户号仅支持人民币
     */
    private Currency currency;

    /**
     * 单品列表信息
     */
    private List<GoodsDetail> goodsDetail;


    /**
     * 优惠范围
     */
    public enum PromotionScope {

        /**
         * 全场代金券
         */
        GLOBAL,

        /**
         * 单品优惠
         */
        SINGLE,
        ;
    }

    /**
     * 优惠类型
     */
    public enum PromotionType {

        /**
         * 充值型代金券
         */
        CASH,

        /**
         * 免充值型代金券
         */
        NOCASH

    }

}
