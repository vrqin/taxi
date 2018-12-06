package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantSaleLeadsQueryBypageDTO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineSaleleadsInfoQuerybypageResponse extends AlipayResponse {
    private static final long serialVersionUID = 1343196934337215717L;

    @ApiListField("merchantsaleleadsquerybypagelist")
    @ApiField("merchant_sale_leads_query_bypage_d_t_o")
    private List<MerchantSaleLeadsQueryBypageDTO> merchantsaleleadsquerybypagelist;

    public List<MerchantSaleLeadsQueryBypageDTO> getMerchantsaleleadsquerybypagelist() {
        /* 31 */
        return this.merchantsaleleadsquerybypagelist;
    }

    public void setMerchantsaleleadsquerybypagelist(List<MerchantSaleLeadsQueryBypageDTO> merchantsaleleadsquerybypagelist) {
        /* 28 */
        this.merchantsaleleadsquerybypagelist = merchantsaleleadsquerybypagelist;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsInfoQuerybypageResponse
 * JD-Core Version:    0.6.0
 */