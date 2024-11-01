package com.lipanre.wechat.pay.sdk.notify;

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
    private String algorithm;

    /**
     * 加密前的对象类型
     */
    private String originalType;

    /**
     * 数据密文
     */
    private String ciphertext;

    /**
     * 附加数据
     */
    private String associatedData;

    /**
     * 随机串
     */
    private String nonce;

}
