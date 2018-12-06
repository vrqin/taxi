package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskDirectionalIpprofileQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2642491897195687163L;

    @ApiField("cert_no")
    private String certNo;

    @ApiField("ip_address")
    private String ipAddress;

    @ApiField("phone")
    private String phone;

    public String getCertNo() {
        /* 35 */
        return this.certNo;
    }

    public void setCertNo(String certNo) {
        /* 38 */
        this.certNo = certNo;
    }

    public String getIpAddress() {
        /* 42 */
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        /* 45 */
        this.ipAddress = ipAddress;
    }

    public String getPhone() {
        /* 49 */
        return this.phone;
    }

    public void setPhone(String phone) {
        /* 52 */
        this.phone = phone;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityRiskDirectionalIpprofileQueryModel
 * JD-Core Version:    0.6.0
 */