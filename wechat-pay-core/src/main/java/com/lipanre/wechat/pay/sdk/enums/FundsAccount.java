package com.lipanre.wechat.pay.sdk.enums;

/**
 * {@code description}
 * 资金账户
 *
 * <br>
 * {@code date} 2024/11/1 11:01
 */
public enum FundsAccount {

    /**
     * 未结算资金
     */
    UNSETTLED,

    /**
     * 可用余额
     */
    AVAILABLE,

    /**
     * 不可用余额
     */
    UNAVAILABLE,

    /**
     * 运营户
     */
    OPERATION,

    /**
     * 基本账户（含可用余额和不可用余额）
     */
    BASIC,

    ;
}
