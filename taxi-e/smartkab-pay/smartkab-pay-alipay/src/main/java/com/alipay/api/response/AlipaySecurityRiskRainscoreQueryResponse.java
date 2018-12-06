package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.InfoCode;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipaySecurityRiskRainscoreQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6895271431785783453L;

    @ApiListField("infocode")
    @ApiField("info_code")
    private List<InfoCode> infocode;

    @ApiListField("label")
    @ApiField("string")
    private List<String> label;

    @ApiField("score")
    private String score;

    public List<InfoCode> getInfocode() {
        /* 44 */
        return this.infocode;
    }

    public void setInfocode(List<InfoCode> infocode) {
        /* 41 */
        this.infocode = infocode;
    }

    public List<String> getLabel() {
        /* 51 */
        return this.label;
    }

    public void setLabel(List<String> label) {
        /* 48 */
        this.label = label;
    }

    public String getScore() {
        /* 58 */
        return this.score;
    }

    public void setScore(String score) {
        /* 55 */
        this.score = score;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityRiskRainscoreQueryResponse
 * JD-Core Version:    0.6.0
 */