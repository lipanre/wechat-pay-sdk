package com.lipanre.wechat.pay.sdk.notify;

import com.lipanre.wechat.pay.sdk.enums.RefundState;
import com.lipanre.wechat.pay.sdk.model.RefundOrderDetailModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code description}
 * 退款回调dto
 *
 * <br>
 * {@code date} 2024/11/1 13:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RefundInfo extends RefundOrderDetailModel {

    /**
     * 直连商户号
     */
    private String mchid;

    /**
     * 退款状态
     */
    private RefundState refundStatus;
}
