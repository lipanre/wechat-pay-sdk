package com.lipanre.wechat.pay.sdk.model.response;

import lombok.Data;

/**
 * {@code description}
 * 小程序下单响应
 *
 * <br>
 * {@code date} 2024/11/29 10:10
 */
@Data
public class AppletCreateOrderResponse {

    /**
     * 【预支付交易会话标识】 预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepayId;

}
