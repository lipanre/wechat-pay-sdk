package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.model.AppletOrderAmount;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * {@code description}
 * 小程序下单dto
 *
 * <br>
 * {@code date} 2024/11/29 10:11
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class AppletCreateOrderRequestDTO {

    /**
     * 【商户订单号】 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
     */
    private final String outTradeNo;

    /**
     * 【商品描述】 商品描述
     */
    private final String description;

    /**
     * 【订单金额】 订单金额信息
     */
    private final AppletOrderAmount amount;

    /**
     * 微信用户唯一标识
     */
    private final String openId;




}
