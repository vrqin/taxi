package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppPdeductPayResponse extends AlipayResponse {
    private static final long serialVersionUID = 8645372879174698911L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("bill_no")
    private String billNo;

    @ApiField("extend_field")
    private String extendField;

    @ApiField("out_order_no")
    private String outOrderNo;

    @ApiField("result_status")
    private String resultStatus;

    public String getAgreementId() {
        /* 54 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 51 */
        this.agreementId = agreementId;
    }

    public String getBillNo() {
        /* 61 */
        return this.billNo;
    }

    public void setBillNo(String billNo) {
        /* 58 */
        this.billNo = billNo;
    }

    public String getExtendField() {
        /* 68 */
        return this.extendField;
    }

    public void setExtendField(String extendField) {
        /* 65 */
        this.extendField = extendField;
    }

    public String getOutOrderNo() {
        /* 75 */
        return this.outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        /* 72 */
        this.outOrderNo = outOrderNo;
    }

    public String getResultStatus() {
        /* 82 */
        return this.resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        /* 79 */
        this.resultStatus = resultStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppPdeductPayResponse
 * JD-Core Version:    0.6.0
 */