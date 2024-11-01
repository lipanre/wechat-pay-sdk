package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.FundsSource;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.RefundsGoodsDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 退款请求
 *
 * <br>
 * {@code date} 2024/11/1 10:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundRequest extends RefundOrderModel {

    /**
     * 退款原因
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 退款结果回调url
     */
    @JsonProperty("notify_url")
    private String notifyUrl;

    /**
     * 退款资金来源
     */
    @JsonProperty("funds_account")
    private FundsSource fundsAccount;

    /**
     * 退款商品
     */
    @JsonProperty("goods_detail")
    private RefundsGoodsDetail goodsDetail;

}
