package com.lipanre.wechat.pay.sdk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * {@code description}
 * 小程序创建订单响应dto
 *
 * <br>
 * {@code date} 2024/12/4 13:37
 */
@Data
public class AppletCreateOrderResponseDTO {

    /**
     * 小程序appId
     */
    private String appId;

    /**
     * 时间戳，单位：s
     */
    private Integer timestamp;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 小程序下单接口返回的prepayId
     */
    @JsonProperty("package")
    private String prepayId;

    /**
     * 签名类型：默认为RSA，仅支持RSA。
     */
    private String signType;

    /**
     * 签名
     */
    private String paySign;


    public byte[] buildToken() {
        String token = this.appId + "\n"
                + this.timestamp + "\n"
                + this.nonceStr + "\n"
                + this.prepayId + "\n";
        return token.getBytes(StandardCharsets.UTF_8);
    }
}
