package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class GfResult extends AlipayObject {
    private static final long serialVersionUID = 5596834928873464584L;

    @ApiField("cert_no")
    private String certNo;

    @ApiField("count")
    private Long count;

    @ApiField("exist")
    private String exist;

    @ApiField("max_score")
    private Long maxScore;

    @ApiField("min_score")
    private Long minScore;

    public String getCertNo() {
        /* 47 */
        return this.certNo;
    }

    public void setCertNo(String certNo) {
        /* 50 */
        this.certNo = certNo;
    }

    public Long getCount() {
        /* 54 */
        return this.count;
    }

    public void setCount(Long count) {
        /* 57 */
        this.count = count;
    }

    public String getExist() {
        /* 61 */
        return this.exist;
    }

    public void setExist(String exist) {
        /* 64 */
        this.exist = exist;
    }

    public Long getMaxScore() {
        /* 68 */
        return this.maxScore;
    }

    public void setMaxScore(Long maxScore) {
        /* 71 */
        this.maxScore = maxScore;
    }

    public Long getMinScore() {
        /* 75 */
        return this.minScore;
    }

    public void setMinScore(Long minScore) {
        /* 78 */
        this.minScore = minScore;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.GfResult
 * JD-Core Version:    0.6.0
 */