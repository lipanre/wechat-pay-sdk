package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.enums.RefundChannel;
import com.lipanre.wechat.pay.sdk.enums.RefundState;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.AppletRefundPromotionDetail;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 小程序退款请求响应
 *
 * @author lipanre
 */
@Data
public class AppletRefundResponseDTO {

    /**
     * 【微信支付退款单号】申请退款受理成功时，该笔退款单在微信支付侧生成的唯一标识
     */
    private String refundId;

    /**
     * 【商户退款单号】 商户申请退款时传的商户系统内部退款单号
     */
    private String outRefundNo;

    /**
     * 【微信支付订单号】微信支付侧订单的唯一标识
     */
    private String transactionId;

    /**
     * 【商户订单号】 商户下单时传入的商户系统内部订单号
     */
    private String outTradeNo;

    /**
     * 【退款渠道】 订单退款渠道
     */
    private RefundChannel channel;

    /**
     * 【退款入账账户】 取当前退款单的退款入账方，有以下几种情况
     * 1）退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:支付用户零钱
     * 3）退还商户:商户基本账户商户结算银行账户
     * 4）退回支付用户零钱通:支付用户零钱通
     * 5）退回支付用户银行电子账户:支付用户银行电子账户
     * 6）退回支付用户零花钱:支付用户零花钱
     * 7）退回用户经营账户:用户经营账户
     * 8）退回支付用户来华零钱包:支付用户来华零钱包
     * 9）退回企业支付商户:企业支付商户
     */
    private String userReceivedAccount;

    /**
     * 【退款成功时间】
     */
    private LocalDateTime successTime;

    /**
     * 【退款创建时间】
     */
    private LocalDateTime createTime;

    /**
     * 【退款状态】退款单的退款处理状态。
     */
    private RefundState status;

    /**
     * 【资金账户】 退款所使用资金对应的资金账户类型
     */
    private FundsAccount fundsAccount;

    /**
     * 【金额信息】订单退款金额信息
     */
    private Amount amount;

    /**
     * 【退款商品】 指定商品退款时传的退款商品信息。
     */
    private List<AppletRefundPromotionDetail> promotionDetail;

}
