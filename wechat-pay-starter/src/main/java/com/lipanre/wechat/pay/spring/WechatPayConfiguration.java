package com.lipanre.wechat.pay.spring;

import com.lipanre.wechat.pay.sdk.config.MerchantProperties;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.exception.HttpCodeException;
import com.wechat.pay.contrib.apache.httpclient.exception.NotFoundException;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationHandler;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationRequest;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

/**
 * 微信支付配置类
 *
 * @author lipanre
 */
@Configuration
public class WechatPayConfiguration {

    /**
     * 支付相关配置属性
     *
     * @return 支付属性配置
     */
    @Bean
    @ConfigurationProperties(prefix = "wechat.pay")
    public PayProperties payProperties() {
        return new PayProperties();
    }

    /**
     * 商户相关属性配置
     *
     * @return 商户属性配置
     */
    @Bean
    @ConfigurationProperties(prefix = "wechat.merchant")
    public MerchantProperties merchantProperties() {
        return new MerchantProperties();
    }

    /**
     * 商户私钥
     *
     * @param merchantProperties 商户相关配置
     * @return 商户私钥对象
     * @throws IOException 读取文件异常
     */
    @Bean
    public PrivateKey privateKey(MerchantProperties merchantProperties) throws IOException {
        return PemUtil.loadPrivateKey(merchantProperties.getApiPrivateKeyFile().getInputStream());
    }

    /**
     * 证书管理器
     *
     * @return 证书管理器
     */
    @Bean
    public CertificatesManager manager(MerchantProperties merchantProperties, PrivateKey privateKey) throws IOException, GeneralSecurityException, HttpCodeException {
        CertificatesManager manager = CertificatesManager.getInstance();
        PrivateKeySigner signer = new PrivateKeySigner(merchantProperties.getApiSerialNum(), privateKey);
        WechatPay2Credentials credentials = new WechatPay2Credentials(merchantProperties.getMerchantId(), signer);
        manager.putMerchant(merchantProperties.getMerchantId(), credentials, merchantProperties.getApiKey().getBytes(StandardCharsets.UTF_8));
        return manager;
    }

    /**
     * 获取签名校验器
     *
     * @param manager            证书管理器
     * @param merchantProperties 商户相关配置
     * @return 签名校验器
     * @throws NotFoundException 证书未找到
     */
    @Bean
    public Verifier verifier(CertificatesManager manager, MerchantProperties merchantProperties) throws NotFoundException {
        return manager.getVerifier(merchantProperties.getMerchantId());
    }

    /**
     * 创建http-client对象
     *
     * @param merchantProperties 商户相关配置
     * @param privateKey 商户私钥对象
     * @param verifier 签名校验器
     * @return http-client对象
     */
    @Bean
    public CloseableHttpClient httpClient(MerchantProperties merchantProperties, PrivateKey privateKey, Verifier verifier) {
        WechatPay2Validator validator = new WechatPay2Validator(verifier);
        return WechatPayHttpClientBuilder.create()
                .withMerchant(merchantProperties.getMerchantId(), merchantProperties.getApiSerialNum(), privateKey)
                .withValidator(validator).build();
    }

    /**
     * 通知处理器
     *
     * @param verifier 校验器
     * @param merchantProperties 商户相关配置
     * @return 通知处理器
     */
    @Bean
    public NotificationHandler notificationHandler(Verifier verifier, MerchantProperties merchantProperties) {
        return new NotificationHandler(verifier, merchantProperties.getApiKey().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 通知请求构建器
     *
     * @param merchantProperties 商户相关配置
     * @return 通知请求构建器
     */
    @Bean
    public NotificationRequest.Builder notificationRequestBuilder(MerchantProperties merchantProperties) {
        return new NotificationRequest.Builder().withSerialNumber(merchantProperties.getApiSerialNum());
    }
}
