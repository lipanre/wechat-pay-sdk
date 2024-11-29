package com.lipanre.wechat.pay.sdk.config;

import com.lipanre.wechat.pay.sdk.common.Constant;
import lombok.Data;

/**
 * 微信支付配置属性
 *
 * @author lipanre
 */
@Data
public class PayProperties {

    /**
     * 接口前缀
     * <br>
     * 比如：项目的接口为：
     * <br>
     * - http://example.com/api/{api1-path}
     * <br>
     * 那么apiPrefix就是：http://exmple.com/api
     */
    private String apiPrefix;

    /**
     * 微信服务id
     * <br>
     * 获取方式：联系微信官方运营人员
     */
    private String serviceId;

    /**
     * 与商户绑定的appId
     * <br>
     * 获取方式：<a href="https://developers.weixin.qq.com/community/develop/article/doc/0002ea97958958f87389d9a2b5fc13">获取APPID</a>
     */
    private String appId;

    /**
     * 获取回调url
     * <br>
     * @return 回调url
     */
    public String getCallbackUrl() {
        return this.apiPrefix + Constant.PAY_SCORE_CALLBACK_URL;
    }
}
