package com.lipanre.wechat.pay.sdk.dto;

import com.lipanre.wechat.pay.sdk.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

/**
 * {@code description}
 * 小程序下单dto
 *
 * <br>
 * {@code date} 2024/11/29 10:11
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class AppletCreateOrderRequestDTO {

    /**
     * 【商户订单号】 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
     */
    private final String outTradeNo;

    /**
     * 【商品描述】 商品描述
     */
    private final String description;

    /**
     * 【订单金额】 订单金额信息
     */
    private final AppletOrderAmount amount;

    /**
     * 微信用户唯一标识
     */
    private final String openId;


    /**
     * 【订单优惠标记】 订单优惠标记
     */
    private String goodsTag;

    /**
     * 【电子发票入口开放标识】 传入true时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     * true：是
     * false：否
     */
    private Boolean supportFapiao;

    /**
     * 【优惠功能】 优惠功能
     */
    private AppletOrderDetail detail;

    /**
     * 【优惠功能】 优惠功能
     */
    private SceneInfo sceneInfo;

    /**
     * 【结算信息】 结算信息
     */
    private AppletSettleInfo settleInfo;

    /**
     * 【交易结束时间】 订单失效时间，遵循rfc3339标准格式，
     * 格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     */
    private OffsetDateTime timeExpire;

    /**
     * 【附加数据】 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段。
     */
    private String attach;






}
