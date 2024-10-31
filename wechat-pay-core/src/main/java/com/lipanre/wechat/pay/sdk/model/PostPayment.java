package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后付费项目
 *
 * @author lipanre
 */
@Data
@NoArgsConstructor
public class PostPayment {

    /**
     * 付费项目名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 金额
     */
    @JsonProperty("amount")
    private Long amount;

    /**
     * 计费说明
     */
    @JsonProperty("description")
    private String description;

    /**
     * 付费数量
     */
    @JsonProperty("count")
    private Integer count;

    public static PostPayment of(String name) {
        PostPayment postPayment = new PostPayment();
        postPayment.setName(name);
        return postPayment;
    }


}
