package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * {@code description}
 * 退款商品详情
 *
 * <br>
 * {@code date} 2024/11/1 10:50
 */
@Data
public class OrderGoodsDetail {

    /**
     * 商户侧商品编码
     */
    private String merchantGoodsId;

    /**
     * 微信支付商品编码
     */
    private String wechatpayGoodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品单价
     */
    private Long unitPrice;

    /**
     * 商品退款金额
     */
    private Long refundAmount;

    /**
     * 商品退货数量
     */
    private Integer refundQuantity;

    /**
     * 【商品数量】 用户购买的数量
     */
    private Integer quantity;

}
