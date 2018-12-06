package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class GradeDiscountPoint extends AlipayObject {
    private static final long serialVersionUID = 3193485874262542121L;

    @ApiField("benefit_id")
    private Long benefitId;

    @ApiField("discount_point")
    private String discountPoint;

    @ApiField("grade")
    private String grade;

    public Long getBenefitId() {
        /* 35 */
        return this.benefitId;
    }

    public void setBenefitId(Long benefitId) {
        /* 38 */
        this.benefitId = benefitId;
    }

    public String getDiscountPoint() {
        /* 42 */
        return this.discountPoint;
    }

    public void setDiscountPoint(String discountPoint) {
        /* 45 */
        this.discountPoint = discountPoint;
    }

    public String getGrade() {
        /* 49 */
        return this.grade;
    }

    public void setGrade(String grade) {
        /* 52 */
        this.grade = grade;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.GradeDiscountPoint
 * JD-Core Version:    0.6.0
 */