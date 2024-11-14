package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.Converter;
import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.CancelPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CompletePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.RefundPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.factory.PayScoreOrderUrlFactory;
import com.lipanre.wechat.pay.sdk.model.request.*;
import com.lipanre.wechat.pay.sdk.model.response.*;
import com.lipanre.wechat.pay.sdk.service.PayScoreOrderService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

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
     * http服务对象
     */
    private final HttpService httpService;

    /**
     * 对象转换器
     */
    protected final Converter converter = Mappers.getMapper(Converter.class);


    @Override
    public CreatePayScoreOrderResponse createOrder(CreatePayScoreOrderDTO createPayScoreOrderDTO) {
        CreatePayScoreOrderRequest request = converter.convert(createPayScoreOrderDTO);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getCreateOrderUrl(), request, CreatePayScoreOrderResponse.class);
    }

    @Override
    public CancelPayScoreOrderResponse cancelOrder(String outOrderNo, CancelPayScoreOrderDTO cancelPayScoreOrderDTO) {
        CancelPayScoreOrderRequest request = converter.convert(cancelPayScoreOrderDTO);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        return httpService.post(PayScoreOrderUrlFactory.getCancelOrderUrl(outOrderNo), request, CancelPayScoreOrderResponse.class);
    }

    @Override
    public CompletePayScoreOrderResponse completeOrder(String outOrderNo, CompletePayScoreOrderDTO completePayScoreOrderDTO) {
        CompletePayScoreOrderRequest request = converter.convert(completePayScoreOrderDTO);
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getCompleteOrderUrl(outOrderNo), request, CompletePayScoreOrderResponse.class);
    }

    @Override
    public RefundPayScoreOrderResponse refundOrder(RefundPayScoreOrderDTO refundPayScoreOrderDTO) {
        RefundPayScoreRequest request = converter.convert(refundPayScoreOrderDTO);
        request.setNotifyUrl(payProperties.getCallbackUrl());
        return httpService.post(PayScoreOrderUrlFactory.getRefundOrderUrl(), request, RefundPayScoreOrderResponse.class);
    }

    @Override
    public SearchPayScoreOrderResponse searchOrder(String outOrderNo) {
        SearchPayScoreOrderRequest request = new SearchPayScoreOrderRequest();
        request.apply(payProperties.getAppid(), payProperties.getServiceId());
        request.setOutOrderNo(outOrderNo);
        return httpService.get(PayScoreOrderUrlFactory.getSearchOrderUrl(), request, SearchPayScoreOrderResponse.class);
    }
}
