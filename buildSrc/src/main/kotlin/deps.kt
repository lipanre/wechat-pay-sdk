/**
 * 依赖相关
 *
 * @author lipanre
 */
class Versions {

    companion object {
        /**
         * 微信http-client sdk v3版本
         */
        const val WE_CHART_HTTP_CLIENT_V3_SDK_VERSION: String = "0.4.9"
    }

}

class Deps {
    companion object {
        /**
         * 微信http-client sdk v3
         */
        const val WE_CHAT_HTTP_CLIENT_V3_SDK = "com.github.wechatpay-apiv3:wechatpay-apache-httpclient:${Versions.WE_CHART_HTTP_CLIENT_V3_SDK_VERSION}"

    }
}

