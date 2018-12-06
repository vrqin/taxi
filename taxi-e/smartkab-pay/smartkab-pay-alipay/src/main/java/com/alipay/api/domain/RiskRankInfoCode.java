package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class RiskRankInfoCode extends AlipayObject {
    private static final long serialVersionUID = 8778751191251592678L;

    @ApiField("code")
    private String code;

    @ApiField("contribution_degree")
    private Long contributionDegree;

    @ApiField("desc")
    private String desc;

    @ApiField("model_name")
    private String modelName;

    public String getCode() {
        /* 41 */
        return this.code;
    }

    public void setCode(String code) {
        /* 44 */
        this.code = code;
    }

    public Long getContributionDegree() {
        /* 48 */
        return this.contributionDegree;
    }

    public void setContributionDegree(Long contributionDegree) {
        /* 51 */
        this.contributionDegree = contributionDegree;
    }

    public String getDesc() {
        /* 55 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 58 */
        this.desc = desc;
    }

    public String getModelName() {
        /* 62 */
        return this.modelName;
    }

    public void setModelName(String modelName) {
        /* 65 */
        this.modelName = modelName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RiskRankInfoCode
 * JD-Core Version:    0.6.0
 */