package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.model.RefundOrderModel;
import com.lipanre.wechat.pay.sdk.model.RefundsGoodsDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * {@code description}
 * 退款请求
 *
 * <br>
 * {@code date} 2024/11/1 10:35
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundPayScoreRequest extends RefundOrderModel {

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 退款结果回调url
     */
    private String notifyUrl;

    /**
     * 退款资金来源
     */
    private FundsAccount fundsAccount;

    /**
     * 退款商品
     */
    private List<RefundsGoodsDetail> goodsDetail;

}
