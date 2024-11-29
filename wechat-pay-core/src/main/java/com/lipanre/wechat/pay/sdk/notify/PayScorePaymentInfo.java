package com.lipanre.wechat.pay.sdk.notify;

import com.lipanre.wechat.pay.sdk.model.response.SearchPayScoreOrderResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 支付回调dto
 *
 * <br>
 * {@code date} 2024/11/1 13:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class PayScorePaymentInfo extends SearchPayScoreOrderResponse implements CallbackInfo {



}
