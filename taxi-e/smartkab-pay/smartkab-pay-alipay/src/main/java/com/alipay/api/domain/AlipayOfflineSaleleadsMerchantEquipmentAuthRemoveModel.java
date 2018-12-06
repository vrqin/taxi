package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsMerchantEquipmentAuthRemoveModel extends AlipayObject {
    private static final long serialVersionUID = 4388655532916343854L;

    @ApiField("device_id")
    private String deviceId;

    @ApiField("device_type")
    private String deviceType;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("merchant_pid")
    private String merchantPid;

    @ApiField("operator")
    private String operator;

    @ApiField("operator_id")
    private String operatorId;

    public String getDeviceId() {
        /* 53 */
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        /* 56 */
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        /* 60 */
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        /* 63 */
        this.deviceType = deviceType;
    }

    public String getExtInfo() {
        /* 67 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 70 */
        this.extInfo = extInfo;
    }

    public String getMerchantPid() {
        /* 74 */
        return this.merchantPid;
    }

    public void setMerchantPid(String merchantPid) {
        /* 77 */
        this.merchantPid = merchantPid;
    }

    public String getOperator() {
        /* 81 */
        return this.operator;
    }

    public void setOperator(String operator) {
        /* 84 */
        this.operator = operator;
    }

    public String getOperatorId() {
        /* 88 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 91 */
        this.operatorId = operatorId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineSaleleadsMerchantEquipmentAuthRemoveModel
 * JD-Core Version:    0.6.0
 */