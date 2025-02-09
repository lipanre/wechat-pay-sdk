package com.lipanre.wechat.pay.sdk.enums;

/**
 * 小程序退款资金来源
 *
 * @author lipanre
 */
public enum AppletFundsAccount {

    /**
     * 仅对旧资金流商户适用(请参考旧资金流介绍区分)，传此枚举指定从可用余额账户出资，否则默认使用未结算资金退款
     */
    AVAILABLE,

    /**
     * 仅对出行预付押金退款适用，指定从未结算资金出资
     */
    UNSETTLED,

    ;

}
