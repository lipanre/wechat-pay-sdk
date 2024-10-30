package com.lipanre.wechat.pay.sdk.factory;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import jdk.internal.loader.Resource;
import lombok.SneakyThrows;
import org.apache.http.impl.client.CloseableHttpClient;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

/**
 * http-client工厂
 *
 * @author lipanre
 */
public class HttpClientFactory {

    /**
     * 创建一个http客户端对象
     * <br>
     * 生成http-client对象，该对象会自动会请求进行加签对响应进行验签
     *
     * @param merchantId             商户id
     * @param merchantSerialNum      商户序列号
     * @param merchantPrivateKeyFile 商户私钥文件资源对象
     * @param apiKey                 apikey字符串
     * @return http-client
     */
    @SneakyThrows
    public static CloseableHttpClient createHttpClient(String merchantId,
                                                       String merchantSerialNum,
                                                       Resource merchantPrivateKeyFile,
                                                       String apiKey) {
        PrivateKey privateKey = PemUtil.loadPrivateKey(merchantPrivateKeyFile.getInputStream());
        return createHttpClient(merchantId, merchantSerialNum, privateKey, apiKey.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 创建一个http客户端对象
     * <br>
     * 生成http-client对象，该对象会自动会请求进行加签对响应进行验签
     *
     * @param merchantId         商户id
     * @param merchantSerialNum  商户序列号
     * @param merchantPrivateKey 商户私钥
     * @param apiKey             apikey字节数组
     * @return http-client
     */
    @SneakyThrows
    public static CloseableHttpClient createHttpClient(String merchantId,
                                                       String merchantSerialNum,
                                                       PrivateKey merchantPrivateKey,
                                                       byte[] apiKey) {
        CertificatesManager manager = CertificatesManager.getInstance();
        PrivateKeySigner signer = new PrivateKeySigner(merchantSerialNum, merchantPrivateKey);
        WechatPay2Credentials credentials = new WechatPay2Credentials(merchantId, signer);
        manager.putMerchant(merchantId, credentials, apiKey);
        Verifier verifier = manager.getVerifier(merchantId);
        WechatPay2Validator validator = new WechatPay2Validator(verifier);
        return WechatPayHttpClientBuilder.create().withMerchant(merchantId, merchantSerialNum, merchantPrivateKey)
                .withValidator(validator).build();
    }

}
