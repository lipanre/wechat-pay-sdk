package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author lipanre
 */
public class OrderDetailModel extends OrderModel {
    /**
     * 服务信息
     */
    @JsonProperty("service_introduction")
    private String serviceIntroduction;
    /**
     * 后付费项目
     */
    @JsonProperty("post_payments")
    private List<PostPayment> postPayments;
    /**
     * 后付费商户优惠
     */
    @JsonProperty("post_discounts")
    private List<PostDiscount> postDiscounts;
    /**
     * 服务时间段
     */
    @JsonProperty("time_range")
    private TimeRange timeRange;
    /**
     * 服务位置
     */
    @JsonProperty("location")
    private Location location;
    /**
     * 订单风险金
     */
    @JsonProperty("risk_fund")
    private RiskFund riskFund;
    /**
     * 商户数据包
     */
    @JsonProperty("attach")
    private String attach;
    /**
     * 商户回调地址
     */
    @JsonProperty("notify_url")
    private String notifyUrl;
}
