package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 商品详情
 *
 * @author lipanre
 */
@Data
public class GoodsDetail {

    /**
     * 商品编码
     */
    @JsonProperty("goods_id")
    private String goodsId;

    /**
     * 商品数量
     */
    @JsonProperty("quantity")
    private Long quantity;

    /**
     * 商品价格
     */
    @JsonProperty("unit_price")
    private Long unitPrice;

    /**
     * 商品优惠金额
     */
    @JsonProperty("discount_amount")
    private Long discountAmount;

    /**
     * 商品备注
     */
    @JsonProperty("goods_remark")
    private String goodsRemark;

}
