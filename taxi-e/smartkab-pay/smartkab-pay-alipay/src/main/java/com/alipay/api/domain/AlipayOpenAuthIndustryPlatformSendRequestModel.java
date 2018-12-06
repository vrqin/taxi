package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthIndustryPlatformSendRequestModel extends AlipayObject {
    private static final long serialVersionUID = 1283413942295845396L;

    @ApiField("external_system_name")
    private String externalSystemName;

    @ApiField("is_transfer_uid")
    private String isTransferUid;

    @ApiField("operate_type")
    private String operateType;

    @ApiField("send_data")
    private String sendData;

    public String getExternalSystemName() {
        /* 41 */
        return this.externalSystemName;
    }

    public void setExternalSystemName(String externalSystemName) {
        /* 44 */
        this.externalSystemName = externalSystemName;
    }

    public String getIsTransferUid() {
        /* 48 */
        return this.isTransferUid;
    }

    public void setIsTransferUid(String isTransferUid) {
        /* 51 */
        this.isTransferUid = isTransferUid;
    }

    public String getOperateType() {
        /* 55 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 58 */
        this.operateType = operateType;
    }

    public String getSendData() {
        /* 62 */
        return this.sendData;
    }

    public void setSendData(String sendData) {
        /* 65 */
        this.sendData = sendData;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAuthIndustryPlatformSendRequestModel
 * JD-Core Version:    0.6.0
 */