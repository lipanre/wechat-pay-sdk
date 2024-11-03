package com.lipanre.wechat.pay.sdk.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 取消支付分订单dto
 *
 * @author lipanre
 */
@Data
@RequiredArgsConstructor
public class CancelPayScoreOrderDTO {

    /**
     * 取消原因
     */
    private final String reason;

}
