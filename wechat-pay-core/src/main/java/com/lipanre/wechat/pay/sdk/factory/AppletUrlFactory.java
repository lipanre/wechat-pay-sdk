package com.lipanre.wechat.pay.sdk.factory;

/**
 * {@code description}
 * 小程序url工厂类
 *
 * <br>
 * {@code date} 2024/11/29 10:24
 */
public class AppletUrlFactory {

    /**
     * 小程序支付host
     */
    private static final String APPLET_PAY_HOST = "https://api.mch.weixin.qq.com/%s";

    /**
     * 创建订单
     */
    private static final String CREATE_ORDER_API = "v3/pay/transactions/jsapi";

    /**
     * 退款url
     */
    private static final String REFUND_API = "v3/refund/domestic/refunds";


    /**
     * 创建订单url
     *
     * @return 创建订单url
     */
    public static String getCreateOrderUrl() {
        return getUrl(CREATE_ORDER_API);
    }

    /**
     * 退款请求url
     *
     * @return 退款请求url
     */
    public static String getRefundUrl() {
        return getUrl(REFUND_API);
    }

    private static String getUrl(String api) {
        return String.format(APPLET_PAY_HOST, api);
    }
}
