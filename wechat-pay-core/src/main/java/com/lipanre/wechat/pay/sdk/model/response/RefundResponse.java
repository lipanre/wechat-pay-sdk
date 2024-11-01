package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.enums.RefundChannel;
import com.lipanre.wechat.pay.sdk.enums.RefundState;
import com.lipanre.wechat.pay.sdk.model.RefundOrderDetailModel;
import com.lipanre.wechat.pay.sdk.model.RefundPromotionInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * {@code description}
 * 退款响应
 *
 * <br>
 * {@code date} 2024/11/1 10:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundResponse extends RefundOrderDetailModel {

    /**
     * 退款渠道
     */
    @JsonProperty("channel")
    private RefundChannel channel;


    /**
     * 退款创建时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;

    /**
     * 退款状态
     */
    @JsonProperty("status")
    private RefundState status;

    /**
     * 资金账户
     */
    @JsonProperty("funds_account")
    private FundsAccount fundsAccount;

    /**
     * 优惠退款信息
     */
    @JsonProperty("promotion_detail")
    private List<RefundPromotionInfo> promotionDetail;

}
