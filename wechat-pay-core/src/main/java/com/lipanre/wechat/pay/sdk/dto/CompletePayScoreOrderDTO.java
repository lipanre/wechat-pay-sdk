package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.Default;
import com.lipanre.wechat.pay.sdk.model.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 完结支付分订单dto
 *
 * @author lipanre
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor(onConstructor_ = @Default)
public class CompletePayScoreOrderDTO {

    /**
     * 后付费项目
     */
    private final List<PostPayment> postPayments;

    /**
     * 总金额
     */
    private final Long totalAmount;

    /**
     * 服务时间范围
     */
    private TimeRange timeRange;

    /**
     * 后付费商户优惠
     */
    private List<PostDiscount> postDiscounts;

    /**
     * 服务位置
     */
    private Location location;

    /**
     * 微信支付服务分账标记
     * false：不分账，默认：false
     * true：分账。
     */
    private Boolean profitSharing;

    /**
     * 订单优惠标记
     */
    private String goodsTag;

    /**
     * 设备信息
     */
    private Device device;

    public CompletePayScoreOrderDTO(List<PostPayment> postPayments, Long totalAmount, TimeRange timeRange) {
        this.postPayments = postPayments;
        this.totalAmount = totalAmount;
        this.timeRange = timeRange;
    }
}
