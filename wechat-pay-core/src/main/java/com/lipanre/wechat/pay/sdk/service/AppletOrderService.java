package com.lipanre.wechat.pay.sdk.service;

import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderRequestDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderResponseDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletRefundRequestDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletRefundResponseDTO;

/**
 * {@code description}
 * 小程序订单service
 *
 * <br>
 * {@code date} 2024/11/29 8:58
 */
public interface AppletOrderService {

    /**
     * 小程序创建订单
     *
     * @param appletCreateOrderDTO 小程序创建订单dto
     * @return 小程序创建订单响应
     */
    AppletCreateOrderResponseDTO createOrder(AppletCreateOrderRequestDTO appletCreateOrderDTO);

    /**
     * 小程序订单退款
     *
     * @param appletRefundRequestDTO 小程度退款请求dto
     * @return 小程序退款响应dto
     */
    AppletRefundResponseDTO refund(AppletRefundRequestDTO appletRefundRequestDTO);

}
