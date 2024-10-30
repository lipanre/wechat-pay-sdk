package com.lipanre.wechat.pay.sdk.config;

import jdk.internal.loader.Resource;
import lombok.Data;

/**
 * 商户相关属性
 *
 * @author lipanre
 */
@Data
public class MerchantProperties {

    /**
     * 商户id
     * <br>
     * 获取方式: 联系微信官方运营人员
     */
    private String merchantId;

    /**
     * 商户api证书序列号
     * <br>
     * 获取方式：
     * <a href="https://wechatpay-api.gitbook.io/wechatpay-api-v3/chang-jian-wen-ti/zheng-shu-xiang-guan#ru-he-cha-kan-zheng-shu-xu-lie-hao">获取商户序列号</a>
     */
    private String apiSerialNum;

    /**
     * 商户API私钥文件路径
     * <br>
     * 文件获取地址：<a href="https://wechatpay-api.gitbook.io/wechatpay-api-v3/ren-zheng/zheng-shu#shang-hu-api-zheng-shu">获取商户API私钥文件</a>
     */
    private Resource apiPrivateKeyFile;

    /**
     * 商户apikey
     * <br>
     * 获取方式：<a href="https://kf.qq.com/faq/180830E36vyQ180830AZFZvu.html">API Key获取方式</a>
     */
    private String apiKey;

}
