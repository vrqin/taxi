package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PersonnalBankAccountInfo extends AlipayObject {
    private static final long serialVersionUID = 6138961621937968867L;

    @ApiField("personal_bank_account_mobile")
    private String personalBankAccountMobile;

    @ApiField("personal_bank_card_no")
    private String personalBankCardNo;

    @ApiField("personal_bank_holder_certno")
    private String personalBankHolderCertno;

    @ApiField("personal_bank_holder_name")
    private String personalBankHolderName;

    public String getPersonalBankAccountMobile() {
        /* 41 */
        return this.personalBankAccountMobile;
    }

    public void setPersonalBankAccountMobile(String personalBankAccountMobile) {
        /* 44 */
        this.personalBankAccountMobile = personalBankAccountMobile;
    }

    public String getPersonalBankCardNo() {
        /* 48 */
        return this.personalBankCardNo;
    }

    public void setPersonalBankCardNo(String personalBankCardNo) {
        /* 51 */
        this.personalBankCardNo = personalBankCardNo;
    }

    public String getPersonalBankHolderCertno() {
        /* 55 */
        return this.personalBankHolderCertno;
    }

    public void setPersonalBankHolderCertno(String personalBankHolderCertno) {
        /* 58 */
        this.personalBankHolderCertno = personalBankHolderCertno;
    }

    public String getPersonalBankHolderName() {
        /* 62 */
        return this.personalBankHolderName;
    }

    public void setPersonalBankHolderName(String personalBankHolderName) {
        /* 65 */
        this.personalBankHolderName = personalBankHolderName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PersonnalBankAccountInfo
 * JD-Core Version:    0.6.0
 */