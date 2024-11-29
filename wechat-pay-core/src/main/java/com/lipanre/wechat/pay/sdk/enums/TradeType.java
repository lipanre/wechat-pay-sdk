package com.lipanre.wechat.pay.sdk.enums;

/**
 * 交易类型
 *
 * @author lipanre
 */
public enum TradeType {

    /**
     * 公众号支付
     */
    JSAPI,

    /**
     * 扫码支付
     */
    NATIVE,

    /**
     * App支付
     */
    App,

    /**
     * 付款码支付
     */
    MICROPAY,

    /**
     * H5支付
     */
    MWEB,

    /**
     * 刷脸支付
     */
    FACEPAY

}
