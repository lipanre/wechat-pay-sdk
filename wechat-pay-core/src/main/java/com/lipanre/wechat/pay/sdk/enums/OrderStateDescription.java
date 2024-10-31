package com.lipanre.wechat.pay.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态描述
 *
 * @author lipanre
 */
@Getter
@AllArgsConstructor
public enum OrderStateDescription {

    USER_CONFIRM("用户确认"),

    MCH_COMPLETE("商户完结"),

    ;

    private final String description;

}
