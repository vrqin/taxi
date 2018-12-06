package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class MerchantApplyResultRecord extends AlipayObject {
    private static final long serialVersionUID = 4495698636733811416L;

    @ApiField("prod_name")
    private String prodName;

    @ApiField("prop_input_key")
    private String propInputKey;

    @ApiField("result_msg")
    private String resultMsg;

    @ApiField("result_status")
    private String resultStatus;

    @ApiField("result_type")
    private String resultType;

    public String getProdName() {
        /* 47 */
        return this.prodName;
    }

    public void setProdName(String prodName) {
        /* 50 */
        this.prodName = prodName;
    }

    public String getPropInputKey() {
        /* 54 */
        return this.propInputKey;
    }

    public void setPropInputKey(String propInputKey) {
        /* 57 */
        this.propInputKey = propInputKey;
    }

    public String getResultMsg() {
        /* 61 */
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        /* 64 */
        this.resultMsg = resultMsg;
    }

    public String getResultStatus() {
        /* 68 */
        return this.resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        /* 71 */
        this.resultStatus = resultStatus;
    }

    public String getResultType() {
        /* 75 */
        return this.resultType;
    }

    public void setResultType(String resultType) {
        /* 78 */
        this.resultType = resultType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MerchantApplyResultRecord
 * JD-Core Version:    0.6.0
 */