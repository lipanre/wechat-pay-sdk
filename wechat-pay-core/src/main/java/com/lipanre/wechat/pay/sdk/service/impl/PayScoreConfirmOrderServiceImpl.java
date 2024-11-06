package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.Converter;
import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.service.PayScoreConfirmOrderService;

/**
 * 支付分订单需确认订单serviceImpl
 *
 * @author lipanre
 */
public class PayScoreConfirmOrderServiceImpl extends PayScoreOrderServiceImpl implements PayScoreConfirmOrderService {

    public PayScoreConfirmOrderServiceImpl(PayProperties payProperties, HttpService httpService) {
        super(payProperties, httpService);
    }
}
