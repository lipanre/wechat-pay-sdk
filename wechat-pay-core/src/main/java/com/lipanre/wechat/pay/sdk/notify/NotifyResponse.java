package com.lipanre.wechat.pay.sdk.notify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通知响应
 *
 * @author lipanre
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotifyResponse {

    /**
     * 返回状态码
     */
    private NotifyResponseStatus code;

    /**
     * 返回信息
     */
    private String message;

    public static NotifyResponse success() {
        NotifyResponse response = new NotifyResponse();
        response.setCode(NotifyResponseStatus.SUCCESS);
        return response;
    }

    public static NotifyResponse fail(String message) {
        NotifyResponse response = new NotifyResponse();
        response.setCode(NotifyResponseStatus.FAIL);
        response.setMessage(message);
        return response;
    }

}
