package com.lipanre.wechat.pay.sdk.notify;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * {@code description}
 * 微信回调请求对象
 *
 * <br>
 * {@code date} 2024/11/1 11:38
 */
@Data
public class NotifyRequest {

    /**
     * 通知ID
     */
    private String id;

    /**
     * 通知创建时间
     */
    private LocalDateTime createTime;

    /**
     * 通知类型
     */
    private NotifyEventType eventType;

    /**
     * 通知简要说明
     */
    private String summary;

    /**
     * 通知数据类型
     */
    private String resourceType;

    /**
     * 通知数据
     */
    private NotifyResource resource;


}
