package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class BusinessBankAccountInfo extends AlipayObject {
    private static final long serialVersionUID = 2499863293152916894L;

    @ApiField("business_bank_account_name")
    private String businessBankAccountName;

    @ApiField("business_bank_card_no")
    private String businessBankCardNo;

    @ApiField("business_bank_name")
    private String businessBankName;

    @ApiField("business_bank_sub")
    private String businessBankSub;

    public String getBusinessBankAccountName() {
        /* 41 */
        return this.businessBankAccountName;
    }

    public void setBusinessBankAccountName(String businessBankAccountName) {
        /* 44 */
        this.businessBankAccountName = businessBankAccountName;
    }

    public String getBusinessBankCardNo() {
        /* 48 */
        return this.businessBankCardNo;
    }

    public void setBusinessBankCardNo(String businessBankCardNo) {
        /* 51 */
        this.businessBankCardNo = businessBankCardNo;
    }

    public String getBusinessBankName() {
        /* 55 */
        return this.businessBankName;
    }

    public void setBusinessBankName(String businessBankName) {
        /* 58 */
        this.businessBankName = businessBankName;
    }

    public String getBusinessBankSub() {
        /* 62 */
        return this.businessBankSub;
    }

    public void setBusinessBankSub(String businessBankSub) {
        /* 65 */
        this.businessBankSub = businessBankSub;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BusinessBankAccountInfo
 * JD-Core Version:    0.6.0
 */