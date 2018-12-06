package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayInsAutoCarSaveResponse extends AlipayResponse {
    private static final long serialVersionUID = 1799888752849524876L;

    @ApiField("car_no")
    private String carNo;

    public String getCarNo() {
        /* 27 */
        return this.carNo;
    }

    public void setCarNo(String carNo) {
        /* 24 */
        this.carNo = carNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayInsAutoCarSaveResponse
 * JD-Core Version:    0.6.0
 */