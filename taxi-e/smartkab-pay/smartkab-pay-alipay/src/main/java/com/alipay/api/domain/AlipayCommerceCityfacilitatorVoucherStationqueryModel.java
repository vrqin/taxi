package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorVoucherStationqueryModel extends AlipayObject {
    private static final long serialVersionUID = 3157269794688952775L;

    @ApiField("city_code")
    private String cityCode;

    public String getCityCode() {
        /* 24 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 27 */
        this.cityCode = cityCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorVoucherStationqueryModel
 * JD-Core Version:    0.6.0
 */