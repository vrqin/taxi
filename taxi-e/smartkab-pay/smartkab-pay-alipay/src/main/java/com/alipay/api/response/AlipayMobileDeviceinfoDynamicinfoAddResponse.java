package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileDeviceinfoDynamicinfoAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 4462192671737185852L;

    @ApiField("operateresult")
    private Boolean operateresult;

    public Boolean getOperateresult() {
        /* 27 */
        return this.operateresult;
    }

    public void setOperateresult(Boolean operateresult) {
        /* 24 */
        this.operateresult = operateresult;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileDeviceinfoDynamicinfoAddResponse
 * JD-Core Version:    0.6.0
 */