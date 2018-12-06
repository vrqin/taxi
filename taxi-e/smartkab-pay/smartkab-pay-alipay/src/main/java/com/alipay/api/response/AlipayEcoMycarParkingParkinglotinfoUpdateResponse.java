package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingParkinglotinfoUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 3858298795412562529L;

    @ApiField("stauts")
    private String stauts;

    public String getStauts() {
        /* 27 */
        return this.stauts;
    }

    public void setStauts(String stauts) {
        /* 24 */
        this.stauts = stauts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoUpdateResponse
 * JD-Core Version:    0.6.0
 */