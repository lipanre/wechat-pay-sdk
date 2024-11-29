package com.lipanre.wechat.pay.sdk.model;

import com.lipanre.wechat.pay.sdk.enums.Currency;
import lombok.Data;

/**
 * 【订单金额】 订单金额信息
 */
@Data
public class AppletOrderAmount {

    /**
     * 【总金额】 订单总金额，单位为分。
     */
    private Long total;

    /**
     * 【货币类型】 CNY：人民币，境内商户号仅支持人民币。
     */
    private Currency currency;
}