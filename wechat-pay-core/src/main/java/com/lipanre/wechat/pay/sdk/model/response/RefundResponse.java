package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.enums.RefundChannel;
import com.lipanre.wechat.pay.sdk.enums.RefundState;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.RefundsGoodsDetail;
import com.lipanre.wechat.pay.sdk.model.request.RefundOrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * {@code description}
 * 退款响应
 *
 * <br>
 * {@code date} 2024/11/1 10:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundResponse extends RefundOrderModel {

    /**
     * 微信支付退款单号
     */
    @JsonProperty("refund_id")
    private String refundId;

    /**
     * 商户订单号
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /**
     * 退款渠道
     */
    @JsonProperty("channel")
    private RefundChannel channel;


    /**
     * 退款入账账户
     */
    @JsonProperty("user_received_account")
    private String userReceivedAccount;

    /**
     * 退款成功时间
     */
    @JsonProperty("success_time")
    private LocalDateTime successTime;

    /**
     * 退款创建时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;

    /**
     * 退款状态
     */
    @JsonProperty("status")
    private RefundState status;

    /**
     * 资金账户
     */
    @JsonProperty("funds_account")
    private FundsAccount fundsAccount;

    /**
     * 优惠退款信息
     */
    @JsonProperty("promotion_detail")
    private RefundsGoodsDetail promotionDetail;

    /**
     * 金额信息
     */
    @JsonProperty("amount")
    private Amount amount;
}
