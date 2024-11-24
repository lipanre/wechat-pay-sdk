import com.lipanre.wechat.pay.sdk.notify.RefundInfo;
import com.lipanre.wechat.pay.sdk.util.JsonUtil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * jackson时间反序列化测试
 *
 * @author lipanre
 */
public class JacksonDeserializerTest {

    @Tag("测试退款回调信息反序列化")
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
        assertDoesNotThrow(() -> JsonUtil.fromJson(json, RefundInfo.class), "退款回调信息反序列化失败");
    }
}
