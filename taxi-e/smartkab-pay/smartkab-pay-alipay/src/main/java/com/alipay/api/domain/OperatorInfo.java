package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OperatorInfo extends AlipayObject {
    private static final long serialVersionUID = 2848723445221247656L;

    @ApiField("operator_cert_indate")
    private String operatorCertIndate;

    @ApiField("operator_cert_no")
    private String operatorCertNo;

    @ApiField("operator_cert_pic_back")
    private String operatorCertPicBack;

    @ApiField("operator_cert_pic_front")
    private String operatorCertPicFront;

    @ApiField("operator_cert_type")
    private String operatorCertType;

    @ApiField("operator_name")
    private String operatorName;

    public String getOperatorCertIndate() {
        /* 53 */
        return this.operatorCertIndate;
    }

    public void setOperatorCertIndate(String operatorCertIndate) {
        /* 56 */
        this.operatorCertIndate = operatorCertIndate;
    }

    public String getOperatorCertNo() {
        /* 60 */
        return this.operatorCertNo;
    }

    public void setOperatorCertNo(String operatorCertNo) {
        /* 63 */
        this.operatorCertNo = operatorCertNo;
    }

    public String getOperatorCertPicBack() {
        /* 67 */
        return this.operatorCertPicBack;
    }

    public void setOperatorCertPicBack(String operatorCertPicBack) {
        /* 70 */
        this.operatorCertPicBack = operatorCertPicBack;
    }

    public String getOperatorCertPicFront() {
        /* 74 */
        return this.operatorCertPicFront;
    }

    public void setOperatorCertPicFront(String operatorCertPicFront) {
        /* 77 */
        this.operatorCertPicFront = operatorCertPicFront;
    }

    public String getOperatorCertType() {
        /* 81 */
        return this.operatorCertType;
    }

    public void setOperatorCertType(String operatorCertType) {
        /* 84 */
        this.operatorCertType = operatorCertType;
    }

    public String getOperatorName() {
        /* 88 */
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        /* 91 */
        this.operatorName = operatorName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OperatorInfo
 * JD-Core Version:    0.6.0
 */