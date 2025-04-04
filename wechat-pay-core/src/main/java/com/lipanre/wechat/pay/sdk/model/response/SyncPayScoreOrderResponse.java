package com.lipanre.wechat.pay.sdk.model.response;

import com.lipanre.wechat.pay.sdk.model.Collection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 同步订单响应
 *
 * <br>
 * {@code date} 2024/11/1 10:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SyncPayScoreOrderResponse extends PayScoreOrderDetailResponse {

    /**
     * 用户标识
     */
    private String openid;

    /**
     * 商户收款总金额
     */
    private Long totalAmount;

    /**
     * 是否需要收款
     */
    private Boolean needCollection;

    /**
     * 收款信息
     */
    private Collection collection;

}
