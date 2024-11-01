package com.lipanre.wechat.pay.sdk.enums;

/**
 * {@code description}
 * 退款渠道
 *
 * <br>
 * {@code date} 2024/11/1 10:56
 */
public enum RefundChannel {

    /**
     * 原路退款
     */
    ORIGINAL,

    /**
     * 退回到余额
     */
    BALANCE,

    /**
     * 原账户异常退到其他余额账户
     */
    OTHER_BALANCE,

    /**
     * 原银行卡异常退到其他银行卡
     */
    OTHER_BANKCARD,

    ;

}
