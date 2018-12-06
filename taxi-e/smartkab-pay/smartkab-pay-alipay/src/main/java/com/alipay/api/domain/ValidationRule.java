package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ValidationRule extends AlipayObject {
    private static final long serialVersionUID = 1244647285374233443L;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("rule_text")
    private String ruleText;

    public String getErrorMsg() {
        /* 29 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 32 */
        this.errorMsg = errorMsg;
    }

    public String getRuleText() {
        /* 36 */
        return this.ruleText;
    }

    public void setRuleText(String ruleText) {
        /* 39 */
        this.ruleText = ruleText;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ValidationRule
 * JD-Core Version:    0.6.0
 */