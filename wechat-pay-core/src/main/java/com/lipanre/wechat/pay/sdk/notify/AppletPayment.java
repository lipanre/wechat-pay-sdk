package com.lipanre.wechat.pay.sdk.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.enums.TradeState;
import com.lipanre.wechat.pay.sdk.enums.TradeType;
import com.lipanre.wechat.pay.sdk.model.Amount;
import com.lipanre.wechat.pay.sdk.model.AppletPromotionDetail;
import com.lipanre.wechat.pay.sdk.model.Payer;
import com.lipanre.wechat.pay.sdk.model.SceneInfo;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 小程序支付通知信息
 *
 * @author lipanre
 */
@Data
public class AppletPayment implements CallbackInfo{

    /**
     * 直连商户申请的公众号或移动应用AppID。
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 商户的商户号，由微信支付生成并下发。
     */
    @JsonProperty("mchid")
    private String mchId;

    /**
     * 商户系统内部订单号，可以是数字、大小写字母_-*的任意组合且在同一个商户号下唯一。
     */
    private String outTradeNo;

    /**
     * 微信支付系统生成的订单号
     */
    private String transactionId;

    /**
     * 交易类型
     */
    private TradeType tradeType;

    /**
     * 交易状态
     */
    private TradeState tradeState;

    /**
     * 交易状态描述
     */
    private String tradeStateDesc;

    /**
     * 银行类型，采用字符串类型的银行标识
     */
    private String bankType;

    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段
     */
    private String attach;

    /**
     * 支付完成时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，
     * T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     */
    private OffsetDateTime successTime;

    /**
     * 支付者信息
     */
    private Payer payer;

    /**
     * 订单金额信息
     */
    private Amount amount;

    /**
     * 支付场景信息描述
     */
    private SceneInfo sceneInfo;

    /**
     * 优惠功能，享受优惠时返回该字段
     */
    private List<AppletPromotionDetail> promotionDetail;

}
