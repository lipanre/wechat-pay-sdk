package com.lipanre.wechat.pay.spring;

import com.lipanre.wechat.pay.sdk.exception.NotSupportEventTypeException;
import com.lipanre.wechat.pay.sdk.notify.NotifyResponse;
import com.wechat.pay.contrib.apache.httpclient.exception.ParseException;
import com.wechat.pay.contrib.apache.httpclient.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 微信支付异常处理器
 *
 * @author lipanre
 */
@RestControllerAdvice
public class WechatPayControllerAdvice {

    @ExceptionHandler({NotSupportEventTypeException.class, ValidationException.class, ParseException.class})
    public NotifyResponse eventNotSupportExceptionHandler(Exception e) {
        return NotifyResponse.fail(e.getMessage());
    }

}
