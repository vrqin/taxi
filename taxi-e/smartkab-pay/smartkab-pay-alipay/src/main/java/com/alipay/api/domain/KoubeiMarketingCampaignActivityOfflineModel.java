package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignActivityOfflineModel extends AlipayObject {
    private static final long serialVersionUID = 1198716285879972383L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_type")
    private String operatorType;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("reason")
    private String reason;

    public String getCampId() {
        /* 53 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 56 */
        this.campId = campId;
    }

    public String getExtInfo() {
        /* 60 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 63 */
        this.extInfo = extInfo;
    }

    public String getOperatorId() {
        /* 67 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 70 */
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        /* 74 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 77 */
        this.operatorType = operatorType;
    }

    public String getOutBizNo() {
        /* 81 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 84 */
        this.outBizNo = outBizNo;
    }

    public String getReason() {
        /* 88 */
        return this.reason;
    }

    public void setReason(String reason) {
        /* 91 */
        this.reason = reason;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignActivityOfflineModel
 * JD-Core Version:    0.6.0
 */