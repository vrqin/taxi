package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPromorulecenterRuleAnalyzeResponse extends AlipayResponse {
    private static final long serialVersionUID = 5861568639548936372L;

    @ApiField("fail_condition_msg")
    private String failConditionMsg;

    @ApiField("fail_condition_name")
    private String failConditionName;

    @ApiField("result_code")
    private String resultCode;

    @ApiField("success")
    private String success;

    @ApiField("triggered")
    private String triggered;

    public String getFailConditionMsg() {
        /* 51 */
        return this.failConditionMsg;
    }

    public void setFailConditionMsg(String failConditionMsg) {
        /* 48 */
        this.failConditionMsg = failConditionMsg;
    }

    public String getFailConditionName() {
        /* 58 */
        return this.failConditionName;
    }

    public void setFailConditionName(String failConditionName) {
        /* 55 */
        this.failConditionName = failConditionName;
    }

    public String getResultCode() {
        /* 65 */
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        /* 62 */
        this.resultCode = resultCode;
    }

    public String getSuccess() {
        /* 72 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 69 */
        this.success = success;
    }

    public String getTriggered() {
        /* 79 */
        return this.triggered;
    }

    public void setTriggered(String triggered) {
        /* 76 */
        this.triggered = triggered;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPromorulecenterRuleAnalyzeResponse
 * JD-Core Version:    0.6.0
 */