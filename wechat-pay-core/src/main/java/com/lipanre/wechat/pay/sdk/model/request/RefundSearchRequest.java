package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {@code description}
 * 退款订单查询请求
 *
 * <br>
 * {@code date} 2024/11/1 11:18
 */
@Data
public class RefundSearchRequest {

    /**
     * 商户退款单号
     */
    private String outRefundNo;

}
