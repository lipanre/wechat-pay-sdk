package com.lipanre.wechat.pay.spring;

import com.lipanre.wechat.pay.sdk.HttpService;
import com.lipanre.wechat.pay.sdk.WechatPayListener;
import com.lipanre.wechat.pay.sdk.config.MerchantProperties;
import com.lipanre.wechat.pay.sdk.config.PayProperties;
import com.lipanre.wechat.pay.sdk.service.AppletOrderService;
import com.lipanre.wechat.pay.sdk.service.PayScoreConfirmOrderService;
import com.lipanre.wechat.pay.sdk.service.PayScoreNoConfirmOrderService;
import com.lipanre.wechat.pay.sdk.service.PayScoreOrderService;
import com.lipanre.wechat.pay.sdk.service.impl.AppletOrderServiceImpl;
import com.lipanre.wechat.pay.sdk.service.impl.PayScoreConfirmOrderServiceImpl;
import com.lipanre.wechat.pay.sdk.service.impl.PayScoreNoConfirmOrderServiceImpl;
import com.lipanre.wechat.pay.sdk.service.impl.PayScoreOrderServiceImpl;
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
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
        return PemUtil.loadPrivateKey(Files.newInputStream(merchantProperties.getApiPrivateKeyFile().toPath()));
    }

    /**
     * 证书管理器
     *
     * @return 证书管理器
     */
    @Bean
    public CertificatesManager manager(MerchantProperties merchantProperties, PrivateKeySigner signer) throws IOException, GeneralSecurityException, HttpCodeException {
        CertificatesManager manager = CertificatesManager.getInstance();
        WechatPay2Credentials credentials = new WechatPay2Credentials(merchantProperties.getMerchantId(), signer);
        manager.putMerchant(merchantProperties.getMerchantId(), credentials, merchantProperties.getApiKey().getBytes(StandardCharsets.UTF_8));
        return manager;
    }

    /**
     * 签名器
     *
     * @param merchantProperties 商户配置属性
     * @param privateKey 私钥key
     * @return 签名器对象
     */
    @Bean
    public PrivateKeySigner signer(MerchantProperties merchantProperties, PrivateKey privateKey) {
        return new PrivateKeySigner(merchantProperties.getApiSerialNum(), privateKey);
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

    /**
     * 微信支付异常处理器
     *
     * @return 微信支付异常处理器对象
     */
    @Bean
    public WechatPayControllerAdvice wechatPayControllerAdvice() {
        return new WechatPayControllerAdvice();
    }

    /**
     * 微信回调处理器
     *
     * @param wechatPayListener 微信支付监听器
     * @return 微信回调处理器对象
     */
    @Bean
    public WechatPayCallbackHandler wechatPayCallbackHandler(@Autowired(required = false) WechatPayListener wechatPayListener) {
        return new WechatPayCallbackHandler(wechatPayListener);
    }

    /**
     * 微信支付回调controller
     *
     * @param notificationHandler 通知handler
     * @param handler 数据处理handler
     * @param notificationRequestBuilder 通知请求对象构建器
     * @return controller
     */
    @Bean
    public WechatPayCallbackController wechatPayCallbackController(NotificationHandler notificationHandler,
                                                                   WechatPayCallbackHandler handler,
                                                                   NotificationRequest.Builder notificationRequestBuilder) {
        return new WechatPayCallbackController(notificationHandler, handler, notificationRequestBuilder);
    }

    /**
     * http-client对象
     *
     * @param httpClient http-client对象
     * @return http-service
     */
    @Bean
    public HttpService httpService(HttpClient httpClient) {
        return new HttpService(httpClient);
    }

    /**
     * 支付分订单service
     *
     * @param payProperties 支付相关属性
     * @param httpService http-service
     * @return 支付分订单service
     */
    @Bean
    public PayScoreOrderService payScoreOrderService(PayProperties payProperties,
                                                     HttpService httpService) {
        return new PayScoreOrderServiceImpl(payProperties, httpService);
    }

    /**
     * 支付分需确认订单serviceImpl
     *
     * @param payProperties 支付相关属性
     * @param httpService http-service
     * @return 支付分订单-需确认 service
     */
    @Bean
    public PayScoreConfirmOrderService payScoreConfirmOrderService(PayProperties payProperties,
                                                                   HttpService httpService) {
        return new PayScoreConfirmOrderServiceImpl(payProperties, httpService);
    }

    /**
     * 支付分无需确认订单serviceImpl
     *
     * @param payProperties 支付相关属性
     * @param httpService http-service
     * @return 支付分订单-无需确认 service
     */
    @Bean
    public PayScoreNoConfirmOrderService payScoreNoConfirmOrderService(PayProperties payProperties,
                                                                       HttpService httpService) {
        return new PayScoreNoConfirmOrderServiceImpl(payProperties, httpService);
    }

    @Bean
    public AppletOrderService appletOrderService(MerchantProperties merchantProperties,
                                                 PayProperties payProperties,
                                                 HttpService httpService,
                                                 PrivateKeySigner signer) {
        return new AppletOrderServiceImpl(merchantProperties, payProperties, httpService, signer);
    }
}
