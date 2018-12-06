package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExClientRateVO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayAccountExrateAllclientrateQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2214994748399752631L;

    @ApiListField("client_rate_list")
    @ApiField("ex_client_rate_v_o")
    private List<ExClientRateVO> clientRateList;

    public List<ExClientRateVO> getClientRateList() {
        /* 31 */
        return this.clientRateList;
    }

    public void setClientRateList(List<ExClientRateVO> clientRateList) {
        /* 28 */
        this.clientRateList = clientRateList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAccountExrateAllclientrateQueryResponse
 * JD-Core Version:    0.6.0
 */