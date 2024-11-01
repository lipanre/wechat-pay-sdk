package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.factory.PayScoreOrderUrlFactory;
import com.lipanre.wechat.pay.sdk.model.request.CreatePayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.response.CreatePayScorePayScoreOrderResponse;
import com.lipanre.wechat.pay.sdk.service.PayScoreOrderService;
import io.github.linpeilie.Converter;
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

    /**
     * 对象转换器
     */
    private final Converter converter;

    private final HttpService httpService;


    @Override
    public CreatePayScorePayScoreOrderResponse createOrder(CreatePayScoreOrderDTO createPayScoreOrderDTO) {
        CreatePayScoreOrderRequest request = converter.convert(createPayScoreOrderDTO, CreatePayScoreOrderRequest.class);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getCreateOrderUrl(), request, CreatePayScorePayScoreOrderResponse.class);
    }
}
