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
    private String goodsId;

    /**
     * 商品数量
     */
    private Long quantity;

    /**
     * 商品价格
     */
    private Long unitPrice;

    /**
     * 商品优惠金额
     */
    private Long discountAmount;

    /**
     * 商品备注
     */
    private String goodsRemark;

}
