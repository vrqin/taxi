package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPcreditLoanApplyCreateModel extends AlipayObject {
    private static final long serialVersionUID = 4748657346385289145L;

    @ApiField("apply_amt")
    private String applyAmt;

    @ApiField("cert_no")
    private String certNo;

    @ApiField("name")
    private String name;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("ratio")
    private Long ratio;

    @ApiField("scene")
    private String scene;

    public String getApplyAmt() {
        /* 53 */
        return this.applyAmt;
    }

    public void setApplyAmt(String applyAmt) {
        /* 56 */
        this.applyAmt = applyAmt;
    }

    public String getCertNo() {
        /* 60 */
        return this.certNo;
    }

    public void setCertNo(String certNo) {
        /* 63 */
        this.certNo = certNo;
    }

    public String getName() {
        /* 67 */
        return this.name;
    }

    public void setName(String name) {
        /* 70 */
        this.name = name;
    }

    public String getOutBizNo() {
        /* 74 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 77 */
        this.outBizNo = outBizNo;
    }

    public Long getRatio() {
        /* 81 */
        return this.ratio;
    }

    public void setRatio(Long ratio) {
        /* 84 */
        this.ratio = ratio;
    }

    public String getScene() {
        /* 88 */
        return this.scene;
    }

    public void setScene(String scene) {
        /* 91 */
        this.scene = scene;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPcreditLoanApplyCreateModel
 * JD-Core Version:    0.6.0
 */