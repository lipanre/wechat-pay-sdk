package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.config.MerchantProperties;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.dto.*;
import com.lipanre.wechat.pay.sdk.model.request.*;
import com.lipanre.wechat.pay.sdk.model.response.AppletCreateOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * {@code description}
 * 对象转换器
 *
 * <br>
 * {@code date} 2024/11/6 13:28
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Converter {

    /**
     * 创建支付分订单dto转request
     *
     * @param createPayScoreOrderDTO dto
     * @return request
     */
    @Mapping(source = "openId", target = "openid")
    CreatePayScoreOrderRequest convert(CreatePayScoreOrderDTO createPayScoreOrderDTO);

    /**
     * 取消支付分订单dto转request
     *
     * @param cancelPayScoreOrderDTO dto
     * @return request
     */
    CancelPayScoreOrderRequest convert(CancelPayScoreOrderDTO cancelPayScoreOrderDTO);

    /**
     * 完结支付分订单dto转request
     *
     * @param completePayScoreOrderDTO dto
     * @return request
     */
    CompletePayScoreOrderRequest convert(CompletePayScoreOrderDTO completePayScoreOrderDTO);

    /**
     * 支付分订单退款
     *
     * @param refundPayScoreOrderDTO dto
     * @return request
     */
    RefundPayScoreRequest convert(RefundPayScoreOrderDTO refundPayScoreOrderDTO);

    /**
     * 小程序创建订单请求dto转request
     *
     * @param appletCreateOrderDTO 小程序创建订单dto
     * @param merchantProperties 商户相关配置
     * @param payProperties 支付相关配置
     * @return 小程序创建订单请求对象
     */
    @Mapping(target = "payer.openid", source = "appletCreateOrderDTO.openId")
    @Mapping(target = "appId", source = "payProperties.appId")
    @Mapping(target = "mchId", source = "merchantProperties.merchantId")
    @Mapping(target = "notifyUrl", expression = """
            java(payProperties.getCallbackUrl())
            """)
    AppletCreateOrderRequest convert(AppletCreateOrderRequestDTO appletCreateOrderDTO, MerchantProperties merchantProperties, PayProperties payProperties);

    /**
     * 小程序下单响应转换为小程序下单响应dto
     *
     * @param response 响应对象
     * @return 响应dto
     */
    AppletCreateOrderResponseDTO convert(AppletCreateOrderResponse response);
}
