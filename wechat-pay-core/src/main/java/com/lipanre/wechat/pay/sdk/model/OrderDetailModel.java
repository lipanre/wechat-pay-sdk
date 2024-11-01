package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetailModel extends OrderModel {
    /**
     * 服务信息
     */
    private String serviceIntroduction;
    /**
     * 后付费项目
     */
    private List<PostPayment> postPayments;
    /**
     * 后付费商户优惠
     */
    private List<PostDiscount> postDiscounts;
    /**
     * 服务时间段
     */
    private TimeRange timeRange;
    /**
     * 服务位置
     */
    private Location location;
    /**
     * 订单风险金
     */
    private RiskFund riskFund;
    /**
     * 商户数据包
     */
    private String attach;
    /**
     * 商户回调地址
     */
    private String notifyUrl;
}
