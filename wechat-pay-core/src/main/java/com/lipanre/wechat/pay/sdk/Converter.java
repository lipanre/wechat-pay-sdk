package com.lipanre.wechat.pay.sdk;

import com.lipanre.wechat.pay.sdk.dto.CancelPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CompletePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.RefundPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.model.request.CancelPayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.CompletePayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.CreatePayScoreOrderRequest;
import com.lipanre.wechat.pay.sdk.model.request.RefundPayScoreRequest;
import org.mapstruct.Mapper;
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
}
