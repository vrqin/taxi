package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMsaasMediarecogVoiceMediaaudioUploadResponse extends AlipayResponse {
    private static final long serialVersionUID = 2194366547962382444L;

    @ApiField("extinfo_a")
    private String extinfoA;

    @ApiField("extinfo_b")
    private String extinfoB;

    @ApiField("result_memo")
    private String resultMemo;

    @ApiField("result_status")
    private String resultStatus;

    public String getExtinfoA() {
        /* 45 */
        return this.extinfoA;
    }

    public void setExtinfoA(String extinfoA) {
        /* 42 */
        this.extinfoA = extinfoA;
    }

    public String getExtinfoB() {
        /* 52 */
        return this.extinfoB;
    }

    public void setExtinfoB(String extinfoB) {
        /* 49 */
        this.extinfoB = extinfoB;
    }

    public String getResultMemo() {
        /* 59 */
        return this.resultMemo;
    }

    public void setResultMemo(String resultMemo) {
        /* 56 */
        this.resultMemo = resultMemo;
    }

    public String getResultStatus() {
        /* 66 */
        return this.resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        /* 63 */
        this.resultStatus = resultStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMsaasMediarecogVoiceMediaaudioUploadResponse
 * JD-Core Version:    0.6.0
 */