package com.lipanre.wechat.pay.sdk.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private String id;

    /**
     * 通知创建时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;

    /**
     * 通知类型
     */
    @JsonProperty("event_type")
    private NotifyEventType eventType;

    /**
     * 通知简要说明
     */
    @JsonProperty("summary")
    private String summary;

    /**
     * 通知数据类型
     */
    @JsonProperty("resource_type")
    private String resourceType;

    /**
     * 通知数据
     */
    @JsonProperty("resource")
    private NotifyResource resource;


}
