package com.lipanre.wechat.pay.spring;

import com.lipanre.wechat.pay.sdk.WechatPayListener;
import com.lipanre.wechat.pay.sdk.notify.CallbackInfo;
import com.lipanre.wechat.pay.sdk.notify.NotifyEventType;
import com.lipanre.wechat.pay.sdk.util.JsonUtil;
import com.wechat.pay.contrib.apache.httpclient.notification.Notification;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * 微信支付回调handler
 *
 * @author lipanre
 */
@RequiredArgsConstructor
public class WechatPayCallbackHandler {

    private final WechatPayListener wechatPayListener;


    /**
     * 处理回调请求
     *
     * @param request 回调请求对象
     */
    @SuppressWarnings("unchecked")
    public <T extends CallbackInfo> void handle(Notification request) {
        if (Objects.isNull(wechatPayListener)) return;
        NotifyEventType eventType = NotifyEventType.getEventType(request.getEventType());
        String json = request.getDecryptData();
        T callbackInfo = (T) JsonUtil.fromJson(json, eventType.getClazz());
        // 调用监听器
        eventType.getConsumer().accept(wechatPayListener, callbackInfo);
    }
}
