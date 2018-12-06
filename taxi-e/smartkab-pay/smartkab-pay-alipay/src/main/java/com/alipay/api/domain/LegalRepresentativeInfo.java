package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class LegalRepresentativeInfo extends AlipayObject {
    private static final long serialVersionUID = 6424671846364163891L;

    @ApiField("legal_representative_cert_indate")
    private String legalRepresentativeCertIndate;

    @ApiField("legal_representative_cert_no")
    private String legalRepresentativeCertNo;

    @ApiField("legal_representative_cert_pic_back")
    private String legalRepresentativeCertPicBack;

    @ApiField("legal_representative_cert_pic_front")
    private String legalRepresentativeCertPicFront;

    @ApiField("legal_representative_cert_type")
    private String legalRepresentativeCertType;

    @ApiField("legal_representative_name")
    private String legalRepresentativeName;

    public String getLegalRepresentativeCertIndate() {
        /* 53 */
        return this.legalRepresentativeCertIndate;
    }

    public void setLegalRepresentativeCertIndate(String legalRepresentativeCertIndate) {
        /* 56 */
        this.legalRepresentativeCertIndate = legalRepresentativeCertIndate;
    }

    public String getLegalRepresentativeCertNo() {
        /* 60 */
        return this.legalRepresentativeCertNo;
    }

    public void setLegalRepresentativeCertNo(String legalRepresentativeCertNo) {
        /* 63 */
        this.legalRepresentativeCertNo = legalRepresentativeCertNo;
    }

    public String getLegalRepresentativeCertPicBack() {
        /* 67 */
        return this.legalRepresentativeCertPicBack;
    }

    public void setLegalRepresentativeCertPicBack(String legalRepresentativeCertPicBack) {
        /* 70 */
        this.legalRepresentativeCertPicBack = legalRepresentativeCertPicBack;
    }

    public String getLegalRepresentativeCertPicFront() {
        /* 74 */
        return this.legalRepresentativeCertPicFront;
    }

    public void setLegalRepresentativeCertPicFront(String legalRepresentativeCertPicFront) {
        /* 77 */
        this.legalRepresentativeCertPicFront = legalRepresentativeCertPicFront;
    }

    public String getLegalRepresentativeCertType() {
        /* 81 */
        return this.legalRepresentativeCertType;
    }

    public void setLegalRepresentativeCertType(String legalRepresentativeCertType) {
        /* 84 */
        this.legalRepresentativeCertType = legalRepresentativeCertType;
    }

    public String getLegalRepresentativeName() {
        /* 88 */
        return this.legalRepresentativeName;
    }

    public void setLegalRepresentativeName(String legalRepresentativeName) {
        /* 91 */
        this.legalRepresentativeName = legalRepresentativeName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.LegalRepresentativeInfo
 * JD-Core Version:    0.6.0
 */