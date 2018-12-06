package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardDeleteModel extends AlipayObject {
    private static final long serialVersionUID = 5398715858888148318L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("out_serial_no")
    private String outSerialNo;

    @ApiField("reason_code")
    private String reasonCode;

    @ApiField("target_card_no")
    private String targetCardNo;

    @ApiField("target_card_no_type")
    private String targetCardNoType;

    public String getExtInfo() {
        /* 56 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 59 */
        this.extInfo = extInfo;
    }

    public String getOutSerialNo() {
        /* 63 */
        return this.outSerialNo;
    }

    public void setOutSerialNo(String outSerialNo) {
        /* 66 */
        this.outSerialNo = outSerialNo;
    }

    public String getReasonCode() {
        /* 70 */
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        /* 73 */
        this.reasonCode = reasonCode;
    }

    public String getTargetCardNo() {
        /* 77 */
        return this.targetCardNo;
    }

    public void setTargetCardNo(String targetCardNo) {
        /* 80 */
        this.targetCardNo = targetCardNo;
    }

    public String getTargetCardNoType() {
        /* 84 */
        return this.targetCardNoType;
    }

    public void setTargetCardNoType(String targetCardNoType) {
        /* 87 */
        this.targetCardNoType = targetCardNoType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCardDeleteModel
 * JD-Core Version:    0.6.0
 */