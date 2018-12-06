package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMobilePublicLabelQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3866231973235446496L;

    @ApiField("code")
    private String code;

    @ApiListField("labels")
    @ApiField("string")
    private List<String> labels;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 42 */
        return this.code;
    }

    public void setCode(String code) {
        /* 39 */
        this.code = code;
    }

    public List<String> getLabels() {
        /* 49 */
        return this.labels;
    }

    public void setLabels(List<String> labels) {
        /* 46 */
        this.labels = labels;
    }

    public String getMsg() {
        /* 56 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 53 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicLabelQueryResponse
 * JD-Core Version:    0.6.0
 */