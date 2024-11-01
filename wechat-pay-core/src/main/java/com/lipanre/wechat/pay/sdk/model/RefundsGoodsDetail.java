package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {@code description}
 * 退款商品详情
 *
 * <br>
 * {@code date} 2024/11/1 10:50
 */
@Data
public class RefundsGoodsDetail {

    /**
     * 商户侧商品编码
     */
    @JsonProperty("merchant_goods_id")
    private String merchantGoodsId;

    /**
     * 微信支付商品编码
     */
    @JsonProperty("wechatpay_goods_id")
    private String wechatpayGoodsId;

    /**
     * 商品名称
     */
    @JsonProperty("goods_name")
    private String goodsName;

    /**
     * 商品单价
     */
    @JsonProperty("unit_price")
    private Long unitPrice;

    /**
     * 商品退款金额
     */
    @JsonProperty("refund_amount")
    private Long refundAmount;

    /**
     * 商品退货数量
     */
    @JsonProperty("refund_quantity")
    private Integer refundQuantity;

}
