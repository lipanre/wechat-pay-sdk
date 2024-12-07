package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * 【结算信息】 结算信息
 */
@Data
public class AppletSettleInfo {

    /**
     * 【是否指定分账】 是否指定分账，
     */
    private Boolean profitSharing;
}