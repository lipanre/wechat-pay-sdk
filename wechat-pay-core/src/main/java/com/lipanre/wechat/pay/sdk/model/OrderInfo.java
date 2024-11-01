package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.common.Constant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderInfo {

    /**
     * 收款成功时间
     */
    @JsonFormat(pattern = Constant.API_DATE_PATTERN)
    @JsonProperty("paid_time")
    private LocalDateTime paidTime;
}