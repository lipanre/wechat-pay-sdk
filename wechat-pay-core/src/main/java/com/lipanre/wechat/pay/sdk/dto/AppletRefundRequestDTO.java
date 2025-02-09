package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.enums.AppletFundsAccount;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.OrderGoodsDetail;
import lombok.Data;

/**
 * 小程序退款请求dto
 *
 * @author lipanre
 */
@Data
public class AppletRefundRequestDTO {

    /**
     * 微信支付订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 【退款资金来源】 若传递此参数则使用对应的资金账户退款。
     */
    private AppletFundsAccount fundsAccount;

    /**
     * 【金额信息】订单退款金额信息
     */
    private Amount amount;

    /**
     * 【退款商品】 请填写需要指定退款的商品信息
     */
    private OrderGoodsDetail goodsDetail;

}
