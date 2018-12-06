package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.InsPolicy;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayInsSceneApplicationQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2716398635633213734L;

    @ApiField("application_status")
    private String applicationStatus;

    @ApiField("operation_id")
    private String operationId;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiListField("policys")
    @ApiField("ins_policy")
    private List<InsPolicy> policys;

    @ApiField("trade_no")
    private String tradeNo;

    public String getApplicationStatus() {
        /* 55 */
        return this.applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        /* 52 */
        this.applicationStatus = applicationStatus;
    }

    public String getOperationId() {
        /* 62 */
        return this.operationId;
    }

    public void setOperationId(String operationId) {
        /* 59 */
        this.operationId = operationId;
    }

    public String getOutBizNo() {
        /* 69 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 66 */
        this.outBizNo = outBizNo;
    }

    public List<InsPolicy> getPolicys() {
        /* 76 */
        return this.policys;
    }

    public void setPolicys(List<InsPolicy> policys) {
        /* 73 */
        this.policys = policys;
    }

    public String getTradeNo() {
        /* 83 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 80 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayInsSceneApplicationQueryResponse
 * JD-Core Version:    0.6.0
 */