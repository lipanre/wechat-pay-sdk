package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.factory.CollectionState;
import lombok.Data;

import java.util.List;

/**
 * 收款信息
 *
 * @author lipanre
 */
@Data
public class Collection {

    /**
     * 收款状态
     */
    private CollectionState state;

    /**
     * 总收款金额
     */
    private Long totalAmount;

    /**
     * 待收金额
     */
    private Long payingAmount;

    /**
     * 已收金额
     */
    private Long paidAmount;

    /**
     * 收款明细列表
     */
    private List<CollectionDetail> details;



}
