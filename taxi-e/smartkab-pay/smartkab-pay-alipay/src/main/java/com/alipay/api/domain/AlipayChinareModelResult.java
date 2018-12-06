package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayChinareModelResult extends AlipayObject {
    private static final long serialVersionUID = 1727198396469417477L;

    @ApiField("id")
    private String id;

    @ApiField("rule_id")
    private String ruleId;

    @ApiField("rule_result")
    private String ruleResult;

    @ApiField("trans_id")
    private String transId;

    public String getId() {
        /* 41 */
        return this.id;
    }

    public void setId(String id) {
        /* 44 */
        this.id = id;
    }

    public String getRuleId() {
        /* 48 */
        return this.ruleId;
    }

    public void setRuleId(String ruleId) {
        /* 51 */
        this.ruleId = ruleId;
    }

    public String getRuleResult() {
        /* 55 */
        return this.ruleResult;
    }

    public void setRuleResult(String ruleResult) {
        /* 58 */
        this.ruleResult = ruleResult;
    }

    public String getTransId() {
        /* 62 */
        return this.transId;
    }

    public void setTransId(String transId) {
        /* 65 */
        this.transId = transId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayChinareModelResult
 * JD-Core Version:    0.6.0
 */