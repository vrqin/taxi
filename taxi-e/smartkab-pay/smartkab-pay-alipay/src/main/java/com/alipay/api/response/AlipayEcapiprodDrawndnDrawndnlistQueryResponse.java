package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.DrawndnVo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcapiprodDrawndnDrawndnlistQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6291734128912482245L;

    @ApiListField("drawndn_list")
    @ApiField("drawndn_vo")
    private List<DrawndnVo> drawndnList;

    @ApiField("request_id")
    private String requestId;

    public List<DrawndnVo> getDrawndnList() {
        /* 37 */
        return this.drawndnList;
    }

    public void setDrawndnList(List<DrawndnVo> drawndnList) {
        /* 34 */
        this.drawndnList = drawndnList;
    }

    public String getRequestId() {
        /* 44 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 41 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnDrawndnlistQueryResponse
 * JD-Core Version:    0.6.0
 */