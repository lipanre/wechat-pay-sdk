import com.lipanre.wechat.pay.sdk.model.request.AppletCreateOrderRequest;
import com.lipanre.wechat.pay.sdk.notify.AppletPayment;
import com.lipanre.wechat.pay.sdk.notify.PayScoreRefundInfo;
import com.lipanre.wechat.pay.sdk.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * jackson时间反序列化测试
 *
 * @author lipanre
 */
public class JacksonDeserializerTest {

    @DisplayName("测试退款回调信息反序列化")
    @Test
    public void test_deserializer_time_include_timezone() {
        String json = """
                {
                    "mchid": "1900000100",
                    "transaction_id": "1008450740201411110005820873",
                    "out_trade_no": "20150806125346",
                    "refund_id": "50200207182018070300011301001",
                    "out_refund_no": "7752501201407033233368018",
                    "refund_status": "SUCCESS",
                    "success_time": "2018-06-08T10:34:56+08:00",
                    "user_received_account": "招商银行信用卡0403",
                    "amount" : {
                        "total": 999,
                        "refund": 999,
                        "payer_total": 999,
                        "payer_refund": 999
                    }
                }
                """;
        assertDoesNotThrow(() -> JsonUtil.fromJson(json, PayScoreRefundInfo.class), "退款回调信息反序列化失败");
    }

    @Test
    public void test_deserializer_applet_create_order() {
        String json = """
                {
                    "appid" : "wxd678efh567hg6787",
                    "mchid" : "1230000109",
                    "description" : "Image形象店-深圳腾大-QQ公仔",
                    "out_trade_no" : "1217752501201407033233368018",
                    "time_expire" : "2018-06-08T10:34:56+08:00",
                    "attach" : "自定义数据说明",
                    "notify_url" : " https://www.weixin.qq.com/wxpay/pay.php",
                    "goods_tag" : "WXG",
                    "support_fapiao" : true,
                    "amount" : {
                      "total" : 100,
                      "currency" : "CNY"
                    },
                    "payer" : {
                      "openid" : "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o\\t"
                    },
                    "detail" : {
                      "cost_price" : 608800,
                      "invoice_id" : "微信123",
                      "goods_detail" : [
                        {
                          "merchant_goods_id" : "1246464644",
                          "wechatpay_goods_id" : "1001",
                          "goods_name" : "iPhoneX 256G",
                          "quantity" : 1,
                          "unit_price" : 528800
                        }
                      ]
                    },
                    "scene_info" : {
                      "payer_client_ip" : "14.23.150.211",
                      "device_id" : "013467007045764",
                      "store_info" : {
                        "id" : "0001",
                        "name" : "腾讯大厦分店",
                        "area_code" : "440305",
                        "address" : "广东省深圳市南山区科技中一道10000号"
                      }
                    },
                    "settle_info" : {
                      "profit_sharing" : false
                    }
                  }
                """;
        AppletCreateOrderRequest appletCreateOrderRequest = Assertions.assertDoesNotThrow(() -> JsonUtil.fromJson(json, AppletCreateOrderRequest.class));
        System.out.println(appletCreateOrderRequest);
        System.out.println(JsonUtil.toJson(appletCreateOrderRequest));
    }

    @DisplayName("测试小程序支付成功反序列化")
    @Test
    void test_deserialize_applet_call_back() {
        String json = """
                {
                    "transaction_id":"1217752501201407033233368018",
                    "amount":{
                        "payer_total":100,
                        "total":100,
                        "currency":"CNY",
                        "payer_currency":"CNY"
                    },
                    "mchid":"1230000109",
                    "trade_state":"SUCCESS",
                    "bank_type":"CMC",
                    "promotion_detail":[
                        {
                            "amount":100,
                            "wechatpay_contribute":0,
                            "coupon_id":"109519",
                            "scope":"GLOBAL",
                            "merchant_contribute":0,
                            "name":"单品惠-6",
                            "other_contribute":0,
                            "currency":"CNY",
                            "stock_id":"931386",
                            "goods_detail":[
                                {
                                    "goods_remark":"商品备注信息",
                                    "quantity":1,
                                    "discount_amount":1,
                                    "goods_id":"M1006",
                                    "unit_price":100
                                },
                                {
                                    "goods_remark":"商品备注信息",
                                    "quantity":1,
                                    "discount_amount":1,
                                    "goods_id":"M1006",
                                    "unit_price":100
                                }
                            ]
                        },
                        {
                            "amount":100,
                            "wechatpay_contribute":0,
                            "coupon_id":"109519",
                            "scope":"GLOBAL",
                            "merchant_contribute":0,
                            "name":"单品惠-6",
                            "other_contribute":0,
                            "currency":"CNY",
                            "stock_id":"931386",
                            "goods_detail":[
                                {
                                    "goods_remark":"商品备注信息",
                                    "quantity":1,
                                    "discount_amount":1,
                                    "goods_id":"M1006",
                                    "unit_price":100
                                },
                                {
                                    "goods_remark":"商品备注信息",
                                    "quantity":1,
                                    "discount_amount":1,
                                    "goods_id":"M1006",
                                    "unit_price":100
                                }
                            ]
                        }
                    ],
                    "success_time":"2018-06-08T10:34:56+08:00",
                    "payer":{
                        "openid":"oUpF8uMuAJO_M2pxb1Q9zNjWeS6o"
                    },
                    "out_trade_no":"1217752501201407033233368018",
                    "AppID":"wxd678efh567hg6787",
                    "trade_state_desc":"支付成功",
                    "trade_type":"MICROPAY",
                    "attach":"自定义数据",
                    "scene_info":{
                        "device_id":"013467007045764"
                    }
                }
              """;
        AppletPayment appletPayment = assertDoesNotThrow(() -> JsonUtil.fromJson(json, AppletPayment.class));
        System.out.println(appletPayment);
    }
}
