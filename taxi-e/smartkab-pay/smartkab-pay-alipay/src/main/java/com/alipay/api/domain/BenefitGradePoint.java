package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class BenefitGradePoint extends AlipayObject {
    private static final long serialVersionUID = 8712618963218489766L;

    @ApiField("benefit_id")
    private String benefitId;

    @ApiListField("grade_points")
    @ApiField("grade_discount_point")
    private List<GradeDiscountPoint> gradePoints;

    @ApiField("original_point")
    private String originalPoint;

    @ApiField("own_grades")
    private String ownGrades;

    public String getBenefitId() {
        /* 45 */
        return this.benefitId;
    }

    public void setBenefitId(String benefitId) {
        /* 48 */
        this.benefitId = benefitId;
    }

    public List<GradeDiscountPoint> getGradePoints() {
        /* 52 */
        return this.gradePoints;
    }

    public void setGradePoints(List<GradeDiscountPoint> gradePoints) {
        /* 55 */
        this.gradePoints = gradePoints;
    }

    public String getOriginalPoint() {
        /* 59 */
        return this.originalPoint;
    }

    public void setOriginalPoint(String originalPoint) {
        /* 62 */
        this.originalPoint = originalPoint;
    }

    public String getOwnGrades() {
        /* 66 */
        return this.ownGrades;
    }

    public void setOwnGrades(String ownGrades) {
        /* 69 */
        this.ownGrades = ownGrades;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BenefitGradePoint
 * JD-Core Version:    0.6.0
 */