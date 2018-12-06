package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataServiceResult extends AlipayObject {
    private static final long serialVersionUID = 5169249258646615446L;

    @ApiField("code")
    private String code;

    @ApiField("message")
    private String message;

    @ApiField("result")
    private String result;

    @ApiField("success")
    private Boolean success;

    public String getCode() {
        /* 41 */
        return this.code;
    }

    public void setCode(String code) {
        /* 44 */
        this.code = code;
    }

    public String getMessage() {
        /* 48 */
        return this.message;
    }

    public void setMessage(String message) {
        /* 51 */
        this.message = message;
    }

    public String getResult() {
        /* 55 */
        return this.result;
    }

    public void setResult(String result) {
        /* 58 */
        this.result = result;
    }

    public Boolean getSuccess() {
        /* 62 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 65 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataServiceResult
 * JD-Core Version:    0.6.0
 */