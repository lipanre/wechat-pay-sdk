package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.Converter;
import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.service.PayScoreNoConfirmOrderService;

/**
 * 支付分订单无需确认serviceImpl
 *
 * @author lipanre
 */
public class PayScoreNoConfirmOrderServiceImpl extends PayScoreOrderServiceImpl implements PayScoreNoConfirmOrderService {

    public PayScoreNoConfirmOrderServiceImpl(PayProperties payProperties, HttpService httpService) {
        super(payProperties, httpService);
    }
}
