package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.service.PayScoreOrderService;
import lombok.RequiredArgsConstructor;

/**
 * 订单serviceImpl
 *
 * @author lipanre
 */
@RequiredArgsConstructor
public class PayScoreOrderServiceImpl implements PayScoreOrderService {

    /**
     * 支付相关配置属性
     */
    private final PayProperties payProperties;


}
