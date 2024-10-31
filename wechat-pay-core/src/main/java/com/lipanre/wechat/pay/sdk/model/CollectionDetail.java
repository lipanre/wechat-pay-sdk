package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.common.Constant;
import com.lipanre.wechat.pay.sdk.enums.PaidType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 收款明细
 *
 * @author lipanre
 */
@Data
public class CollectionDetail {

    /**
     * 收款序号
     */
    @JsonProperty("seq")
    private Integer seq;

    /**
     * 单笔收款金额
     */
    @JsonProperty("amount")
    private Long amount;

    /**
     * 收款成功渠道
     */
    @JsonProperty("paid_type")
    private PaidType paidType;

    /**
     * 收款成功时间
     */
    @JsonFormat(pattern = Constant.API_DATE_PATTERN)
    @JsonProperty("paid_time")
    private LocalDateTime paidTime;

    /**
     * 微信支付交易单号
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * 优惠功能
     */
    @JsonProperty("promotion_detail")
    private List<Promotion> promotionDetail;

}
