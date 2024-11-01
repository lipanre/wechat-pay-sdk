package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.Default;
import com.lipanre.wechat.pay.sdk.model.*;
import com.lipanre.wechat.pay.sdk.model.request.CreatePayScoreOrderRequest;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 创建支付分订单DTO
 *
 * @author lipanre
 */
@Data
@RequiredArgsConstructor(onConstructor_ = @Default)
@AutoMapper(target = CreatePayScoreOrderRequest.class)
public class CreatePayScoreOrderDTO {

    /**
     * 商户服务单号
     */
    private final String outOrderNo;

    /**
     * 服务信息
     */
    private final String serviceIntroduction;

    /**
     * 服务时间段
     */
    private final TimeRange timeRange;

    /**
     * 订单风险金
     */
    private final RiskFund riskFund;

    /**
     * 微信用户唯一标识
     */
    private String openId;

    /**
     * 是否需要用户确认
     */
    private Boolean needUserConfirm;

    /**
     * 后付费项目
     */
    private List<PostPayment> postPayments;

    /**
     * 后付费商户优惠
     */
    private List<PostDiscount> postDiscounts;

    /**
     * 服务位置
     */
    private Location location;

    /**
     * 商户数据包
     */
    private String attach;

    /**
     * 回调通知url，如果设置了这个地址，则以这个地址为准，如果没有设置，则根据配置自动生成 {@link com.lipanre.wechat.pay.sdk.config.PayProperties}
     */
    private String notifyUrl;

    public CreatePayScoreOrderDTO(String outOrderNo, String serviceIntroduction, TimeRange timeRange, RiskFund riskFund, String openId) {
        this.outOrderNo = outOrderNo;
        this.serviceIntroduction = serviceIntroduction;
        this.timeRange = timeRange;
        this.riskFund = riskFund;
        this.openId = openId;
        this.needUserConfirm = false;
    }

    public CreatePayScoreOrderDTO(String outOrderNo, String serviceIntroduction, TimeRange timeRange, RiskFund riskFund, List<PostPayment> postPayments, List<PostDiscount> postDiscounts, Location location, String attach, String notifyUrl) {
        this.outOrderNo = outOrderNo;
        this.serviceIntroduction = serviceIntroduction;
        this.timeRange = timeRange;
        this.riskFund = riskFund;
        this.postPayments = postPayments;
        this.postDiscounts = postDiscounts;
        this.location = location;
        this.attach = attach;
        this.notifyUrl = notifyUrl;
    }

    public CreatePayScoreOrderDTO(String outOrderNo, String serviceIntroduction, TimeRange timeRange, RiskFund riskFund, List<PostPayment> postPayments, List<PostDiscount> postDiscounts, Location location, String attach, String notifyUrl, String openId) {
        this.outOrderNo = outOrderNo;
        this.serviceIntroduction = serviceIntroduction;
        this.timeRange = timeRange;
        this.riskFund = riskFund;
        this.postPayments = postPayments;
        this.postDiscounts = postDiscounts;
        this.location = location;
        this.attach = attach;
        this.notifyUrl = notifyUrl;
        this.openId = openId;
        this.needUserConfirm = false;
    }
}
