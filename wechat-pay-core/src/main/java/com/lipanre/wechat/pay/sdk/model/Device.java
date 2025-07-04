package com.lipanre.wechat.pay.sdk.model;

import lombok.Data;

/**
 * 设备信息
 *
 * @author lipanre
 */
@Data
public class Device {

    /**
     * 【服务开始的设备ID】 某一设备在商户对应服务ID下的唯一标识，由商户自行填写，建议采用设备SN值。售货机、充电宝、充电桩等无人自助设备行业必传。
     */
    private String startDeviceId;

    /**
     * 【服务结束的设备ID】 某一设备在商户对应服务ID下的唯一标识，由商户自行填写，建议采用设备SN值。售货机、充电宝、充电桩等无人自助设备行业必传。
     */
    private String endDeviceId;

    /**
     * 【物料编码】 若商家参与政策，则商家填写行业侧给到商家的物料码（字母+数字的形式）；若商家未参与政策，则商家填写URL链接。
     */
    private String materialNo;

}
