package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantSaleLeadsQueryDTO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineSaleleadsQuerybyidsResponse extends AlipayResponse {
    private static final long serialVersionUID = 4424835334523212311L;

    @ApiListField("merchantsaleleadsquerylist")
    @ApiField("merchant_sale_leads_query_d_t_o")
    private List<MerchantSaleLeadsQueryDTO> merchantsaleleadsquerylist;

    public List<MerchantSaleLeadsQueryDTO> getMerchantsaleleadsquerylist() {
        /* 31 */
        return this.merchantsaleleadsquerylist;
    }

    public void setMerchantsaleleadsquerylist(List<MerchantSaleLeadsQueryDTO> merchantsaleleadsquerylist) {
        /* 28 */
        this.merchantsaleleadsquerylist = merchantsaleleadsquerylist;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsQuerybyidsResponse
 * JD-Core Version:    0.6.0
 */