package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySocialBaseGroupCreateModel extends AlipayObject {
    private static final long serialVersionUID = 3893681376216993117L;

    @ApiField("biz_no")
    private String bizNo;

    @ApiField("biz_type")
    private String bizType;

    @ApiField("group_settings")
    private GroupSetting groupSettings;

    @ApiField("master_id")
    private String masterId;

    public String getBizNo() {
        /* 41 */
        return this.bizNo;
    }

    public void setBizNo(String bizNo) {
        /* 44 */
        this.bizNo = bizNo;
    }

    public String getBizType() {
        /* 48 */
        return this.bizType;
    }

    public void setBizType(String bizType) {
        /* 51 */
        this.bizType = bizType;
    }

    public GroupSetting getGroupSettings() {
        /* 55 */
        return this.groupSettings;
    }

    public void setGroupSettings(GroupSetting groupSettings) {
        /* 58 */
        this.groupSettings = groupSettings;
    }

    public String getMasterId() {
        /* 62 */
        return this.masterId;
    }

    public void setMasterId(String masterId) {
        /* 65 */
        this.masterId = masterId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseGroupCreateModel
 * JD-Core Version:    0.6.0
 */