package com.lipanre.wechat.pay.sdk.service;

import com.lipanre.wechat.pay.sdk.dto.CancelPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CompletePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.CreatePayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.dto.RefundPayScoreOrderDTO;
import com.lipanre.wechat.pay.sdk.model.response.*;

/**
 * 订单相关service
 *
 * @author lipanre
 */
public interface PayScoreOrderService {

    /**
     * 创建支付分订单
     *
     * @param createPayScoreOrderDTO 创建订单dto
     */
    CreatePayScoreOrderResponse createOrder(CreatePayScoreOrderDTO createPayScoreOrderDTO);

    /**
     * 取消支付分订单
     *
     * @param outOrderNo 商户订单号
     * @param cancelPayScoreOrderDTO 取消支付分订单dto
     * @return 取消支付分订单响应
     */
    CancelPayScoreOrderResponse cancelOrder(String outOrderNo, CancelPayScoreOrderDTO cancelPayScoreOrderDTO);

    /**
     * 完结支付分订单
     *
     * @param outOrderNo 商户订单号
     * @param completePayScoreOrderDTO 完结支付分订单dto
     * @return 完结支付分订单响应
     */
    CompletePayScoreOrderResponse completeOrder(String outOrderNo, CompletePayScoreOrderDTO completePayScoreOrderDTO);

    /**
     * 申请退款
     *
     * @param refundPayScoreOrderDTO 退款支付分订单
     * @return 退款支付分响应
     */
    RefundPayScoreOrderResponse refundOrder(RefundPayScoreOrderDTO refundPayScoreOrderDTO);

    /**
     * 查询订单信息
     *
     * @param outOrderNo 订单编号
     * @return 查询订单响应
     */
    SearchPayScoreOrderResponse searchOrder(String outOrderNo);

}
