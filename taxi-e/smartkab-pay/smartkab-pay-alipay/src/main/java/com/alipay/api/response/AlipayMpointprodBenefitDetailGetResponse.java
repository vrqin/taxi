package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.BenefitInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMpointprodBenefitDetailGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 2266361653454452898L;

    @ApiListField("benefit_infos")
    @ApiField("benefit_info")
    private List<BenefitInfo> benefitInfos;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public List<BenefitInfo> getBenefitInfos() {
        /* 43 */
        return this.benefitInfos;
    }

    public void setBenefitInfos(List<BenefitInfo> benefitInfos) {
        /* 40 */
        this.benefitInfos = benefitInfos;
    }

    public String getCode() {
        /* 50 */
        return this.code;
    }

    public void setCode(String code) {
        /* 47 */
        this.code = code;
    }

    public String getMsg() {
        /* 57 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 54 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMpointprodBenefitDetailGetResponse
 * JD-Core Version:    0.6.0
 */