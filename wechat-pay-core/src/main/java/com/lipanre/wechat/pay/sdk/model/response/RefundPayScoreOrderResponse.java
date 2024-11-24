package com.lipanre.wechat.pay.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lipanre.wechat.pay.sdk.common.Constant;
import com.lipanre.wechat.pay.sdk.enums.FundsAccount;
import com.lipanre.wechat.pay.sdk.enums.RefundChannel;
import com.lipanre.wechat.pay.sdk.enums.RefundState;
import com.lipanre.wechat.pay.sdk.model.RefundOrderDetailModel;
import com.lipanre.wechat.pay.sdk.model.RefundPromotionInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
@ToString(callSuper = true)
public class RefundPayScoreOrderResponse extends RefundOrderDetailModel {

    /**
     * 退款渠道
     */
    private RefundChannel channel;


    /**
     * 退款创建时间
     */
    @JsonFormat(pattern = Constant.API_DATE_TIMEZONE_PATTERN)
    private LocalDateTime createTime;

    /**
     * 退款状态
     */
    private RefundState status;

    /**
     * 资金账户
     */
    private FundsAccount fundsAccount;

    /**
     * 优惠退款信息
     */
    private List<RefundPromotionInfo> promotionDetail;

}
