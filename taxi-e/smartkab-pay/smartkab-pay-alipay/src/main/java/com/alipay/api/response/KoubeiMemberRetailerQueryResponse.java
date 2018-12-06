package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Retailer;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMemberRetailerQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7754145552116358792L;

    @ApiListField("retailer_list")
    @ApiField("retailer")
    private List<Retailer> retailerList;

    public List<Retailer> getRetailerList() {
        /* 31 */
        return this.retailerList;
    }

    public void setRetailerList(List<Retailer> retailerList) {
        /* 28 */
        this.retailerList = retailerList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMemberRetailerQueryResponse
 * JD-Core Version:    0.6.0
 */