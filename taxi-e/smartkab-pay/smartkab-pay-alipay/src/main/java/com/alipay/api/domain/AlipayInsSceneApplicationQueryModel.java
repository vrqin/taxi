package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayInsSceneApplicationQueryModel extends AlipayObject {
    private static final long serialVersionUID = 5216781425333758585L;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("prod_code")
    private String prodCode;

    public String getOutBizNo() {
        /* 29 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 32 */
        this.outBizNo = outBizNo;
    }

    public String getProdCode() {
        /* 36 */
        return this.prodCode;
    }

    public void setProdCode(String prodCode) {
        /* 39 */
        this.prodCode = prodCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayInsSceneApplicationQueryModel
 * JD-Core Version:    0.6.0
 */