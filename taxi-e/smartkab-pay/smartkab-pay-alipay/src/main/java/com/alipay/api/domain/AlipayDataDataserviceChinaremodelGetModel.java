package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceChinaremodelGetModel extends AlipayObject {
    private static final long serialVersionUID = 1715381278331456432L;

    @ApiField("id")
    private String id;

    @ApiField("rule_id")
    private String ruleId;

    @ApiField("trans_id")
    private String transId;

    public String getId() {
        /* 35 */
        return this.id;
    }

    public void setId(String id) {
        /* 38 */
        this.id = id;
    }

    public String getRuleId() {
        /* 42 */
        return this.ruleId;
    }

    public void setRuleId(String ruleId) {
        /* 45 */
        this.ruleId = ruleId;
    }

    public String getTransId() {
        /* 49 */
        return this.transId;
    }

    public void setTransId(String transId) {
        /* 52 */
        this.transId = transId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataDataserviceChinaremodelGetModel
 * JD-Core Version:    0.6.0
 */