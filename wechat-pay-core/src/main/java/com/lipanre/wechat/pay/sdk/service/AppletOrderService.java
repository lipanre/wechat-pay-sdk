package com.lipanre.wechat.pay.sdk.service;

import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderDTO;
import com.lipanre.wechat.pay.sdk.model.request.AppletCreateOrderRequest;
import com.lipanre.wechat.pay.sdk.model.response.AppletCreateOrderResponse;

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
    AppletCreateOrderResponse createOrder(AppletCreateOrderDTO appletCreateOrderDTO);

}
