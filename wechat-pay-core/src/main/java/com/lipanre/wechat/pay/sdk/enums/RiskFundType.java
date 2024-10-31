package com.lipanre.wechat.pay.sdk.enums;

/**
 * 风险金类型
 *
 * @author lipanre
 */
public enum RiskFundType {

    /**
     * 【先免模式】(评估不通过可交押金)
     * 押金
     */
    DEPOSIT,

    /**
     * 【先免模式】(评估不通过可交押金)
     * 预付款
     */
    ADVANCE,

    /**
     * 【先免模式】(评估不通过可交押金)
     * 保证金
     */
    CASH_DEPOSIT,

    /**
     * 【先享模式】（评估不通过不可使用服务）可填名称为
     * 预估订单费用
     */
    ESTIMATE_ORDER_COST,

    ;

}
