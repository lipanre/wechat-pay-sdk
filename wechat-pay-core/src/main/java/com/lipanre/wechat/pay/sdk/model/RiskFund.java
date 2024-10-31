package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * 风险金
 * @author lipanre
 */
@Data
public class RiskFund {

    /**
     * 风险金名称
     */
    private String name;

    /**
     * 风险金额
     */
    private Long amount;

    /**
     * 风险说明
     */
    private String description;

}
