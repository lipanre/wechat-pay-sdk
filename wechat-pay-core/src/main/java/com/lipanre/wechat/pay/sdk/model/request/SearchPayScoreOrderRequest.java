package com.lipanre.wechat.pay.sdk.model.request;

import com.lipanre.wechat.pay.sdk.model.OrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询订单请求对象
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SearchPayScoreOrderRequest extends OrderModel {

    /**
     * 回跳查询ID
     */
    private String queryId;

}
