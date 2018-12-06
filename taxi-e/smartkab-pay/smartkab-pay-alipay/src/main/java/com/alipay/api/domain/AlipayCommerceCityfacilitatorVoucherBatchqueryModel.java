package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorVoucherBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 3284221867431532166L;

    @ApiField("city_code")
    private String cityCode;

    @ApiListField("trade_nos")
    @ApiField("string")
    private List<String> tradeNos;

    public String getCityCode() {
        /* 34 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 37 */
        this.cityCode = cityCode;
    }

    public List<String> getTradeNos() {
        /* 41 */
        return this.tradeNos;
    }

    public void setTradeNos(List<String> tradeNos) {
        /* 44 */
        this.tradeNos = tradeNos;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorVoucherBatchqueryModel
 * JD-Core Version:    0.6.0
 */