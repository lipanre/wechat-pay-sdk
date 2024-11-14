package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.model.OrderInfo;
import com.lipanre.wechat.pay.sdk.model.OrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * {@code description}
 * 同步订单信息
 *
 * <br>
 * {@code date} 2024/11/1 10:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SyncPayScoreOrderRequest extends OrderModel {



    /**
     * 场景类型
     */
    private String type;

    /**
     * 内容信息详情
     */
    private OrderInfo detail;

}
