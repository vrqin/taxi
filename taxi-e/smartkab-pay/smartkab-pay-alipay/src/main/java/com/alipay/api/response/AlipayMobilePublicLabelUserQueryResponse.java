package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicLabelUserQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7131739374528187195L;

    @ApiField("code")
    private String code;

    @ApiField("label_ids")
    private String labelIds;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getLabelIds() {
        /* 46 */
        return this.labelIds;
    }

    public void setLabelIds(String labelIds) {
        /* 43 */
        this.labelIds = labelIds;
    }

    public String getMsg() {
        /* 53 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 50 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicLabelUserQueryResponse
 * JD-Core Version:    0.6.0
 */