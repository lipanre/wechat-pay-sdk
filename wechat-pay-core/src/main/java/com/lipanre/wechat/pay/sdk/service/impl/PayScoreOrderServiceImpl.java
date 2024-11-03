package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.CancelPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CompletePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.RefundPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.factory.PayScoreOrderUrlFactory;
import com.lipanre.wechat.pay.sdk.model.request.CancelPayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.CompletePayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.CreatePayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.RefundPayScoreRequest;
import com.lipanre.wechat.pay.sdk.model.response.CancelPayScoreOrderResponse;
import com.lipanre.wechat.pay.sdk.model.response.CompletePayScoreOrderResponse;
import com.lipanre.wechat.pay.sdk.model.response.CreatePayScoreOrderResponse;
import com.lipanre.wechat.pay.sdk.model.response.RefundPayScoreOrderResponse;
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

    /**
     * http服务对象
     */
    private final HttpService httpService;


    @Override
    public CreatePayScoreOrderResponse createOrder(CreatePayScoreOrderDTO createPayScoreOrderDTO) {
        CreatePayScoreOrderRequest request = converter.convert(createPayScoreOrderDTO, CreatePayScoreOrderRequest.class);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getCreateOrderUrl(), request, CreatePayScoreOrderResponse.class);
    }

    @Override
    public CancelPayScoreOrderResponse cancelOrder(String outOrderNo, CancelPayScoreOrderDTO cancelPayScoreOrderDTO) {
        CancelPayScoreOrderRequest request = converter.convert(cancelPayScoreOrderDTO, CancelPayScoreOrderRequest.class);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        return httpService.post(PayScoreOrderUrlFactory.getCancelOrderUrl(outOrderNo), request, CancelPayScoreOrderResponse.class);
    }

    @Override
    public CompletePayScoreOrderResponse completeOrder(String outOrderNo, CompletePayScoreOrderDTO completePayScoreOrderDTO) {
        CompletePayScoreOrderRequest request = converter.convert(completePayScoreOrderDTO, CompletePayScoreOrderRequest.class);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getCompleteOrderUrl(outOrderNo), request, CompletePayScoreOrderResponse.class);
    }

    @Override
    public RefundPayScoreOrderResponse refundOrder(RefundPayScoreOrderDTO refundPayScoreOrderDTO) {
        RefundPayScoreRequest request = converter.convert(refundPayScoreOrderDTO, RefundPayScoreRequest.class);
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getRefundOrderUrl(), request, RefundPayScoreOrderResponse.class);
    }
}
