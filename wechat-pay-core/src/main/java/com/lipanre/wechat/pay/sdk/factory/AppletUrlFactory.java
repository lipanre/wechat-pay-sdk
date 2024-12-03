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
     * 创建订单url
     *
     * @return 创建订单url
     */
    public static String getCreateOrderUrl() {
        return String.format(APPLET_PAY_HOST, CREATE_ORDER_API);
    }

}
