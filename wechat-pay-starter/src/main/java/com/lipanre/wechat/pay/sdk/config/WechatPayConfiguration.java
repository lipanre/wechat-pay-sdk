package com.lipanre.wechat.pay.sdk.config;

import com.lipanre.wechat.pay.sdk.core.config.PayProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 微信支付配置类
 *
 * @author lipanre
 */
@Configuration
@ComponentScan("com.lipanre.wechat.pay.sdk.core")
public class WechatPayConfiguration {

    /**
     * 微信支付属性配置
     * <br>
     * @return 支付属性
     */
    @Bean
    @ConfigurationProperties(prefix = "wechat-pay")
    public PayProperties payProperties() {
        return new PayProperties();
    }

}
