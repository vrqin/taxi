package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketLeadsOpenshopCodeQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8347142148619611366L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("op_id")
    private String opId;

    public String getLeadsId() {
        /* 29 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 32 */
        this.leadsId = leadsId;
    }

    public String getOpId() {
        /* 36 */
        return this.opId;
    }

    public void setOpId(String opId) {
        /* 39 */
        this.opId = opId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsOpenshopCodeQueryModel
 * JD-Core Version:    0.6.0
 */