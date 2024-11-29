package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.lipanre.wechat.pay.sdk.common.Constant;
import com.lipanre.wechat.pay.sdk.enums.Currency;
import com.lipanre.wechat.pay.sdk.model.AppletOrderAmount;
import com.lipanre.wechat.pay.sdk.model.OrderGoodsDetail;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * {@code description}
 * 小程序创建订单请求类
 *
 * <br>
 * {@code date} 2024/11/29 9:00
 */
@Data
@RequiredArgsConstructor(onConstructor_ = {@JsonCreator})
public class AppletCreateOrderRequest {

    /**
     * 【公众号ID】 公众号ID
     */
    @JsonProperty("appid")
    private final String appId;

    /**
     * 【直连商户号】 直连商户号
     */
    @JsonProperty("mchid")
    private final String mchId;

    /**
     * 【商品描述】 商品描述
     */
    private final String description;

    /**
     * 【商户订单号】 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
     */
    private final String outTradeNo;

    /**
     * 【交易结束时间】 订单失效时间，遵循rfc3339标准格式，
     * 格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     */
    @JsonFormat(pattern = Constant.API_DATE_TIMEZONE_PATTERN, timezone = "GMT+8")
    private OffsetDateTime timeExpire;

    /**
     * 【附加数据】 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段。
     */
    private String attach;

    /**
     * 【通知地址】 异步接收微信支付结果通知的回调地址，通知URL必须为外网可访问的URL，不能携带参数。 公网域名必须为HTTPS，如果是走专线接入，使用专线NAT IP或者私有回调域名可使用HTTP
     */
    private final String notifyUrl;

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
     * 【订单金额】 订单金额信息
     */
    private final AppletOrderAmount amount;

    /**
     * 【支付者】 支付者信息
     */
    private final Payer payer;

    /**
     * 【优惠功能】 优惠功能
     */
    private Detail detail;

    /**
     * 【优惠功能】 优惠功能
     */
    private SceneInfo sceneInfo;

    /**
     * 【结算信息】 结算信息
     */
    private SettleInfo settleInfo;


    @Data
    public static class SceneInfo {

        /**
         * 【用户终端IP】 用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。
         */
        private String payerClientIp;

        /**
         * 【商户端设备号】 商户端设备号（门店号或收银设备ID）。
         */
        private String deviceId;

        /**
         * 【商户门店信息】 商户门店信息
         */
        private StoreInfo storeInfo;

        @Data
        public static class StoreInfo {

            /**
             * 【门店编号】 商户侧门店编号
             */
            private String id;

            /**
             * 【门店名称】 商户侧门店名称
             */
            private String name;

            /**
             * 【地区编码】 地区编码，详细请见省市区编号对照表。
             */
            private String areaCode;

            /**
             * 【详细地址】 详细的商户门店地址
             */
            private String address;

        }
    }



    /**
     * 支付者
     */
    @Data
    public static class Payer {

        /**
         * 【用户标识】 用户在普通商户AppID下的唯一标识。 下单前需获取到用户的OpenID
         */
        private String openid;
    }

    /**
     * 【优惠功能】 优惠功能
     */
    @Data
    public static class Detail {
        /**
         * 【订单原价】 1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
         */
        private Long costPrice;

        /**
         * 【商品小票ID】 商家小票ID
         */
        private String invoiceId;

        /**
         * 【单品列表】 单品列表信息
         * 条目个数限制：【1，6000】
         */
        private List<OrderGoodsDetail> goodsDetail;

    }

    /**
     * 【结算信息】 结算信息
     */
    @Data
    public static class SettleInfo {

        /**
         * 【是否指定分账】 是否指定分账，
         */
        private Boolean profitSharing;
    }

}
