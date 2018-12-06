package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayInsSceneApplicationApplyResponse extends AlipayResponse {
    private static final long serialVersionUID = 4134921942168971829L;

    @ApiField("operation_id")
    private String operationId;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOperationId() {
        /* 39 */
        return this.operationId;
    }

    public void setOperationId(String operationId) {
        /* 36 */
        this.operationId = operationId;
    }

    public String getOutBizNo() {
        /* 46 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 43 */
        this.outBizNo = outBizNo;
    }

    public String getTradeNo() {
        /* 53 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 50 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayInsSceneApplicationApplyResponse
 * JD-Core Version:    0.6.0
 */