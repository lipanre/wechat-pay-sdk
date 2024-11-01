package com.lipanre.wechat.pay.sdk.service;

import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.model.response.CreatePayScorePayScoreOrderResponse;

/**
 * 订单相关service
 *
 * @author lipanre
 */
public interface PayScoreOrderService {

    /**
     * 创建支付分订单
     *
     * @param createPayScoreOrderDTO 创建订单dto
     */
    CreatePayScorePayScoreOrderResponse createOrder(CreatePayScoreOrderDTO createPayScoreOrderDTO);

}
