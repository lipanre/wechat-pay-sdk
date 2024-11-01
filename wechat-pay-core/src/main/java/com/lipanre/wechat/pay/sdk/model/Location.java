package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 位置
 *
 * @author lipanre
 */
@Data
public class Location {

    /**
     * 服务开始地点
     */
    private String startLocation;

    /**
     * 预计服务结束位置
     */
    private String endLocation;

}
