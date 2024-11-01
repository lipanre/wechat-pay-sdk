package com.lipanre.wechat.pay.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.model.OrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询订单请求对象
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchOrderRequest extends OrderModel {

    /**
     * 回跳查询ID
     */
    private String queryId;

}
