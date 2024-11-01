package com.lipanre.wechat.pay.sdk.enums;

/**
 * @author lipanre
 */
public enum PromotionType {

    /**
     * 充值
     */
    CASH,

    /**
     * 免充值
     */
    NOCASH,

    /**
     * 代金券，需要走结算资金的充值型代金券
     */
    COUPON,

    /**
     * 优惠券，不走结算资金的免充值型优惠券
     */
    DISCOUNT,
    ;
}
