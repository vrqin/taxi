package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPointOrderAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 5498355464441932564L;

    @ApiField("alipay_order_no")
    private String alipayOrderNo;

    @ApiField("result_code")
    private Boolean resultCode;

    public String getAlipayOrderNo() {
        /* 33 */
        return this.alipayOrderNo;
    }

    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 30 */
        this.alipayOrderNo = alipayOrderNo;
    }

    public Boolean getResultCode() {
        /* 40 */
        return this.resultCode;
    }

    public void setResultCode(Boolean resultCode) {
        /* 37 */
        this.resultCode = resultCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPointOrderAddResponse
 * JD-Core Version:    0.6.0
 */