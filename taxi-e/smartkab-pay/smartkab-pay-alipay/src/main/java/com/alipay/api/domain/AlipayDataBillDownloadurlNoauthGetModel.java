package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataBillDownloadurlNoauthGetModel extends AlipayObject {
    private static final long serialVersionUID = 6276121493396425997L;

    @ApiField("bill_date")
    private String billDate;

    @ApiField("bill_type")
    private String billType;

    public String getBillDate() {
        /* 29 */
        return this.billDate;
    }

    public void setBillDate(String billDate) {
        /* 32 */
        this.billDate = billDate;
    }

    public String getBillType() {
        /* 36 */
        return this.billType;
    }

    public void setBillType(String billType) {
        /* 39 */
        this.billType = billType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataBillDownloadurlNoauthGetModel
 * JD-Core Version:    0.6.0
 */