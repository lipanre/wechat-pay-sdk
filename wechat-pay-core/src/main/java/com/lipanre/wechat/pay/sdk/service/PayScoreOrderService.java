package com.lipanre.wechat.pay.sdk.service;

import com.lipanre.wechat.pay.sdk.dto.CreateOrderDTO;

/**
 * 订单相关service
 *
 * @author lipanre
 */
public interface PayScoreOrderService {

    /**
     * 创建支付分订单
     *
     * @param createOrderDTO 创建订单dto
     */
    void createOrder(CreateOrderDTO createOrderDTO);

}
