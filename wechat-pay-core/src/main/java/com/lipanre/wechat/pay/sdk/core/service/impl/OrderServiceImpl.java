package com.lipanre.wechat.pay.sdk.core.service.impl;

import com.lipanre.wechat.pay.sdk.core.config.PayProperties;
import com.lipanre.wechat.pay.sdk.core.service.OrderService;
import lombok.RequiredArgsConstructor;

/**
 * 订单serviceImpl
 *
 * @author lipanre
 */
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    /**
     * 支付相关配置属性
     */
    private final PayProperties payProperties;



}
