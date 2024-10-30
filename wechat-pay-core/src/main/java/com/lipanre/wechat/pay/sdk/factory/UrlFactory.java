package com.lipanre.wechat.pay.sdk.factory;

/**
 * http url工厂类，用于生产接口url
 *
 * @author lipanre
 */
public class UrlFactory {

    /**
     * 微信http请求host
     */
    private static final String WE_CHAT_PAY_HOST = "https://api.mch.weixin.qq.com/v3/%s";

    /**
     * 创建/查询 支付分订单
     */
    private static final String CREATE_OR_SEARCH_API = "payscore/serviceorder";

    /**
     * 取消订单
     */
    private static final String CANCEL_API = "payscore/serviceorder/%s/cancel";

    /**
     * 修改金额
     */
    private static final String MODIFY_API = "payscore/serviceorder/%s/modify";

    /**
     * 完结订单
     */
    public static final String COMPLETE_API = "payscore/serviceorder/%s/complete";

    /**
     * 同步订单
     */
    public static final String SYNC_API = "payscore/serviceorder/%s/sync";

    /**
     * 申请退款
     */
    public static final String REFUND_API = "refund/domestic/refunds";

    /**
     * 查询单笔退款
     */
    public static final String SINGLE_REFUND_SEARCH_API = "refund/domestic/refunds/%s";

    /**
     * 获取查询单笔退款url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_27.shtml">查询单笔退款</a>
     * @param outOrderNo 商户订单号
     * @return 查询单笔退款url
     */
    public static String getSingleRefundUrl(String outOrderNo) {
        return getUrl(String.format(SINGLE_REFUND_SEARCH_API, outOrderNo));
    }

    /**
     * 获取申请退款url
     * <br>
     * 参考: <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_26.shtml">申请退款</a>
     * @return 申请退款url
     */
    public static String getRefundOrderUrl() {
        return getUrl(REFUND_API);
    }

    /**
     * 获取同步订单url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_20.shtml">同步订单</a>
     * @param outOrderNo 商户订单编号
     * @return 同步订单url
     */
    public static String getSyncOrderUrl(String outOrderNo) {
        return getUrl(String.format(SYNC_API, outOrderNo));
    }

    /**
     * 获取完结订单url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_18.shtml">完结订单</a>
     * @param outOrderNo 商户订单编号
     * @return 完结订单url
     */
    public static String getCompleteOrderUrl(String outOrderNo) {
        return getUrl(String.format(COMPLETE_API, outOrderNo));
    }

    /**
     * 获取修改订单金额url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_17.shtml">修改订单金额</a>
     * @param outOrderNo 商户订单编号
     * @return 修改订单url
     */
    public static String getModifyOrderUrl(String outOrderNo) {
        return getUrl(String.format(MODIFY_API, outOrderNo));
    }

    /**
     * 获取取消订单url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_16.shtml">取消支付分订单</a>
     * @param outOrderNo 商户订单编号
     * @return 取消订单url
     */
    public static String getCancelOrderUrl(String outOrderNo) {
        return getUrl(String.format(CANCEL_API, outOrderNo));
    }

    /**
     * 获取查询订单url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_15.shtml">查询支付分订单</a>
     * @return 查询订单url
     */
    public static String getSearchOrderUrl() {
        return getUrl(CREATE_OR_SEARCH_API);
    }

    /**
     * 获取创建支付分订单url
     * <br>
     * 参考：<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_14.shtml">创建支付分订单</a>
     * @return 支付分订单url
     */
    public static String getCreateOrderUrl() {
        return getUrl(CREATE_OR_SEARCH_API);
    }

    /**
     * 构建http url
     * <br>
     * @param api 接口api
     * @return 请求url完整路径

     */
    private static String getUrl(String api) {
        return String.format(WE_CHAT_PAY_HOST, api);
    }

}
