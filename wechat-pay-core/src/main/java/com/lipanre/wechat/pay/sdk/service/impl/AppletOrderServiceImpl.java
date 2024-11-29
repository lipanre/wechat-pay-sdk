package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.Converter;
import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.MerchantProperties;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderDTO;
import com.lipanre.wechat.pay.sdk.factory.AppletUrlFactory;
import com.lipanre.wechat.pay.sdk.model.request.AppletCreateOrderRequest;
import com.lipanre.wechat.pay.sdk.model.response.AppletCreateOrderResponse;
import com.lipanre.wechat.pay.sdk.service.AppletOrderService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

/**
 * {@code description}
 * 小程序订单serviceImpl
 *
 * <br>
 * {@code date} 2024/11/29 8:58
 */
@RequiredArgsConstructor
public class AppletOrderServiceImpl implements AppletOrderService {

    /**
     * 类型转换器
     */
    private final Converter converter = Mappers.getMapper(Converter.class);

    /**
     * 微信支付相关配置
     */
    private final MerchantProperties merchantProperties;

    /**
     * 支付相关属性
     */
    private final PayProperties payProperties;

    /**
     * http-service
     */
    private final HttpService httpService;


    @Override
    public AppletCreateOrderResponse createOrder(AppletCreateOrderDTO appletCreateOrderDTO) {
        AppletCreateOrderRequest appletCreateOrderRequest = converter.convert(appletCreateOrderDTO, merchantProperties, payProperties);
        return httpService.post(AppletUrlFactory.getCreateOrderUrl(), appletCreateOrderRequest, AppletCreateOrderResponse.class);
    }
}
