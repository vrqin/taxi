package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarDataExternalSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 7142869336122758557L;

    @ApiField("external_system_name")
    private String externalSystemName;

    @ApiField("process_result")
    private String processResult;

    public String getExternalSystemName() {
        /* 33 */
        return this.externalSystemName;
    }

    public void setExternalSystemName(String externalSystemName) {
        /* 30 */
        this.externalSystemName = externalSystemName;
    }

    public String getProcessResult() {
        /* 40 */
        return this.processResult;
    }

    public void setProcessResult(String processResult) {
        /* 37 */
        this.processResult = processResult;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarDataExternalSendResponse
 * JD-Core Version:    0.6.0
 */