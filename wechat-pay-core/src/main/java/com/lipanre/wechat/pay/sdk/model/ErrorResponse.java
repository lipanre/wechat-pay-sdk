package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * 微信错误响应
 *
 * <br>
 * {@code date} 2025/2/11 15:07
 */
@Data
public class ErrorResponse {

    /**
     *  错误码
     */
    private String code;

    /**
     * 错误描述信息
     */
    private String message;

}
