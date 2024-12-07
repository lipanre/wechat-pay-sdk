package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

import java.util.List;

/**
 * 【优惠功能】 优惠功能
 */
@Data
public class AppletOrderDetail {
    /**
     * 【订单原价】 1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
     */
    private Long costPrice;

    /**
     * 【商品小票ID】 商家小票ID
     */
    private String invoiceId;

    /**
     * 【单品列表】 单品列表信息
     * 条目个数限制：【1，6000】
     */
    private List<OrderGoodsDetail> goodsDetail;

}
