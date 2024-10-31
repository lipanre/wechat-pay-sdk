package com.lipanre.wechat.pay.sdk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lipanre.wechat.pay.sdk.common.Constant;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 时间段
 *
 * @author lipanre
 */
@Data
public class TimeRange {

    /**
     * 服务开始时间
     */
    @JsonFormat(pattern = Constant.API_DATE_PATTERN)
    @JsonProperty("start_time")
    private LocalDateTime startTime;

    /**
     * 服务开始时间备注
     */
    @JsonProperty("start_time_remark")
    private String startTimeRemark;

    /**
     * 预计服务结束时间
     */
    @JsonFormat(pattern = Constant.API_DATE_PATTERN)
    @JsonProperty("end_time")
    private LocalDateTime endTime;

    /**
     * 预计服务结束时间备注
     */
    @JsonProperty("end_time_remark")
    private String endTimeRemark;


}
