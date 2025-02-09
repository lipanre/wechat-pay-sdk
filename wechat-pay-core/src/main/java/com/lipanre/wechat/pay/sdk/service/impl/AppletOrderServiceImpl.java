package com.lipanre.wechat.pay.sdk.service.impl;

import com.lipanre.wechat.pay.sdk.Converter;
import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.config.MerchantProperties;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderRequestDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletCreateOrderResponseDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletRefundRequestDTO;
import com.lipanre.wechat.pay.sdk.dto.AppletRefundResponseDTO;
import com.lipanre.wechat.pay.sdk.factory.AppletUrlFactory;
import com.lipanre.wechat.pay.sdk.model.request.AppletCreateOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.AppletRefundOrderRequest;
import com.lipanre.wechat.pay.sdk.model.response.AppletCreateOrderResponse;
import com.lipanre.wechat.pay.sdk.model.response.AppletRefundOrderResponse;
import com.lipanre.wechat.pay.sdk.service.AppletOrderService;
import com.lipanre.wechat.pay.sdk.util.StrUtil;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
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

    public static final String SIGN_TYPE = "RSA";
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

    /**
     * 签名器
     */
    private final PrivateKeySigner signer;


    @Override
    public AppletCreateOrderResponseDTO createOrder(AppletCreateOrderRequestDTO appletCreateOrderDTO) {
        AppletCreateOrderRequest appletCreateOrderRequest = converter.convert(appletCreateOrderDTO, merchantProperties, payProperties);
        AppletCreateOrderResponse response = httpService.post(AppletUrlFactory.getCreateOrderUrl(), appletCreateOrderRequest, AppletCreateOrderResponse.class);
        AppletCreateOrderResponseDTO responseDTO = converter.convert(response);
        buildSignInfo(responseDTO);
        return responseDTO;
    }

    @Override
    public AppletRefundResponseDTO refund(AppletRefundRequestDTO appletRefundRequestDTO) {
        AppletRefundOrderRequest request = converter.convert(appletRefundRequestDTO, payProperties);
        AppletRefundOrderResponse response = httpService.post(AppletUrlFactory.getRefundUrl(), request, AppletRefundOrderResponse.class);
        return converter.convert(response);
    }

    /**
     * 构建签名信息
     *
     * @param dto 响应dto
     */
    private void buildSignInfo(AppletCreateOrderResponseDTO dto) {
        dto.setAppId(payProperties.getAppId());
        dto.setTimestamp((int) ((System.currentTimeMillis() + 5) / 1000));
        dto.setNonceStr(StrUtil.randomStr(32));
        dto.setSignType(SIGN_TYPE);
        dto.setPaySign(signer.sign(dto.buildToken()).getSign());
    }
}
