package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后付费商户优惠
 *
 * @author lipanre
 */
@Data
@NoArgsConstructor
public class PostDiscount {

    /**
     * 优惠名称
     */
    private String name;

    /**
     * 优惠说明
     */
    @JsonProperty("description")
    private String description;

    /**
     * 优惠数量
     */
    @JsonProperty("count")
    private Integer count;


}
