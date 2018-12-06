package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExtBrand;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiItemExtitemBrandQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 5426387585766784613L;

    @ApiListField("brand_list")
    @ApiField("ext_brand")
    private List<ExtBrand> brandList;

    public List<ExtBrand> getBrandList() {
        /* 31 */
        return this.brandList;
    }

    public void setBrandList(List<ExtBrand> brandList) {
        /* 28 */
        this.brandList = brandList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiItemExtitemBrandQueryResponse
 * JD-Core Version:    0.6.0
 */