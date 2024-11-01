package com.lipanre.wechat.pay.sdk.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {@code description}
 * 回调数据
 *
 * <br>
 * {@code date} 2024/11/1 12:04
 */
@Data
public class NotifyResource {

    /**
     * 加密算法类型
     */
    @JsonProperty("algorithm")
    private String algorithm;

    /**
     * 加密前的对象类型
     */
    @JsonProperty("original_type")
    private String originalType;

    /**
     * 数据密文
     */
    @JsonProperty("ciphertext")
    private String ciphertext;

    /**
     * 附加数据
     */
    @JsonProperty("associated_data")
    private String associatedData;

    /**
     * 随机串
     */
    @JsonProperty("nonce")
    private String nonce;

}
