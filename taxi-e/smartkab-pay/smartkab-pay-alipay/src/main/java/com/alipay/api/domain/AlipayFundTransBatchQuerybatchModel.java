package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransBatchQuerybatchModel extends AlipayObject {
    private static final long serialVersionUID = 4544581953914781649L;

    @ApiField("batch_no")
    private String batchNo;

    @ApiField("token")
    private String token;

    public String getBatchNo() {
        /* 29 */
        return this.batchNo;
    }

    public void setBatchNo(String batchNo) {
        /* 32 */
        this.batchNo = batchNo;
    }

    public String getToken() {
        /* 36 */
        return this.token;
    }

    public void setToken(String token) {
        /* 39 */
        this.token = token;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransBatchQuerybatchModel
 * JD-Core Version:    0.6.0
 */