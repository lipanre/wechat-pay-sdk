package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.dto.*;
import com.lipanre.wechat.pay.sdk.model.request.*;
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
     * @return 小程序创建订单请求对象
     */
    @Mapping(target = "payer.openid", source = "openId")
    AppletCreateOrderRequest convert(AppletCreateOrderDTO appletCreateOrderDTO);
}
