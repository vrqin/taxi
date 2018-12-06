package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOperatorMobileBindResponse extends AlipayResponse {
    private static final long serialVersionUID = 8735243863374938919L;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("certificate")
    private String certificate;

    @ApiField("mobile_no")
    private String mobileNo;

    @ApiField("status")
    private String status;

    @ApiField("user_name")
    private String userName;

    public String getAlipayUserId() {
        /* 54 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 51 */
        this.alipayUserId = alipayUserId;
    }

    public String getCertificate() {
        /* 61 */
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        /* 58 */
        this.certificate = certificate;
    }

    public String getMobileNo() {
        /* 68 */
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        /* 65 */
        this.mobileNo = mobileNo;
    }

    public String getStatus() {
        /* 75 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 72 */
        this.status = status;
    }

    public String getUserName() {
        /* 82 */
        return this.userName;
    }

    public void setUserName(String userName) {
        /* 79 */
        this.userName = userName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOperatorMobileBindResponse
 * JD-Core Version:    0.6.0
 */