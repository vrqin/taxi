package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayPassCodeAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 5698854521374987842L;

    @ApiListField("biz_result")
    @ApiField("string")
    private List<String> bizResult;

    @ApiField("error_code")
    private String errorCode;

    @ApiField("success")
    private Boolean success;

    public List<String> getBizResult() {
        /* 42 */
        return this.bizResult;
    }

    public void setBizResult(List<String> bizResult) {
        /* 39 */
        this.bizResult = bizResult;
    }

    public String getErrorCode() {
        /* 49 */
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        /* 46 */
        this.errorCode = errorCode;
    }

    public Boolean getSuccess() {
        /* 56 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 53 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPassCodeAddResponse
 * JD-Core Version:    0.6.0
 */