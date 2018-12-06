package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoCplifeUseridentityStatusUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 1826381853684395625L;

    @ApiField("biz_details")
    private String bizDetails;

    @ApiField("biz_state")
    private String bizState;

    @ApiField("req_id")
    private String reqId;

    public String getBizDetails() {
        /* 35 */
        return this.bizDetails;
    }

    public void setBizDetails(String bizDetails) {
        /* 38 */
        this.bizDetails = bizDetails;
    }

    public String getBizState() {
        /* 42 */
        return this.bizState;
    }

    public void setBizState(String bizState) {
        /* 45 */
        this.bizState = bizState;
    }

    public String getReqId() {
        /* 49 */
        return this.reqId;
    }

    public void setReqId(String reqId) {
        /* 52 */
        this.reqId = reqId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoCplifeUseridentityStatusUpdateModel
 * JD-Core Version:    0.6.0
 */