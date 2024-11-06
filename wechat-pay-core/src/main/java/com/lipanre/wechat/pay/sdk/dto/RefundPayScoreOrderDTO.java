package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.RefundsGoodsDetail;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 退款支付分订单DTO
 *
 * @author lipanre
 */
@Data
@RequiredArgsConstructor
public class RefundPayScoreOrderDTO {

    /**
     * 微信支付订单号
     */
    private final String transactionId;

    /**
     * 商户退款单号
     */
    private final String outRefundNo;

    /**
     * 金额信息 <br>
     * 对象内部的信息参考文档进行填充：<br>
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_26.shtml">申请退款</a>
     */
    private final Amount amount;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 退款资金来源
     */
    private FundsAccount fundsAccount;

    /**
     * 退款商品 <br>
     * 对象内部的信息参考文档进行填充：<br>
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_26.shtml">申请退款</a>
     */
    private List<RefundsGoodsDetail> goodsDetail;

}
