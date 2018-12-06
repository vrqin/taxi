package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CityFunction;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorCityQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1891533782136721344L;

    @ApiListField("citys")
    @ApiField("city_function")
    private List<CityFunction> citys;

    public List<CityFunction> getCitys() {
        /* 31 */
        return this.citys;
    }

    public void setCitys(List<CityFunction> citys) {
        /* 28 */
        this.citys = citys;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorCityQueryResponse
 * JD-Core Version:    0.6.0
 */