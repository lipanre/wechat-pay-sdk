package com.lipanre.wechat.pay.spring;

import com.lipanre.wechat.pay.sdk.common.Constant;
import com.lipanre.wechat.pay.sdk.notify.NotifyResponse;
import com.wechat.pay.contrib.apache.httpclient.exception.ParseException;
import com.wechat.pay.contrib.apache.httpclient.exception.ValidationException;
import com.wechat.pay.contrib.apache.httpclient.notification.Notification;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationHandler;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 微信支付回调controller
 *
 * @author lipanre
 */
@RestController
@RequiredArgsConstructor
public class WechatPayCallbackController {

    private final NotificationHandler notificationHandler;

    private final WechatPayCallbackHandler handler;

    private final NotificationRequest.Builder notificationRequestBuilder;


    @PostMapping(Constant.PAY_SCORE_CALLBACK_URL)
    public ResponseEntity<NotifyResponse> callback(@RequestHeader("Wechatpay-Nonce") String nonce,
                                   @RequestHeader("Wechatpay-Timestamp") String timestamp,
                                   @RequestHeader("Wechatpay-Signature") String signature,
                                   @RequestHeader("Wechatpay-Serial") String serialNumber,
                                   @RequestBody String body) throws ValidationException, ParseException {
        NotificationRequest notificationRequest = notificationRequestBuilder.withSerialNumber(serialNumber)
                .withNonce(nonce)
                .withTimestamp(timestamp)
                .withSignature(signature)
                .withBody(body)
                .build();
        Notification notification = notificationHandler.parse(notificationRequest);
        // 异步执行业务逻辑，直接返回给微信通知成功, 防止微信等待超时
        return CompletableFuture.runAsync(() -> handler.handle(notification)).handle((result, exception) -> {
            if (Objects.nonNull(exception)) {
                return ResponseEntity.badRequest().body(NotifyResponse.fail("失败"));
            }
            return ResponseEntity.ok().body(NotifyResponse.success());
        }).get();
    }
}
