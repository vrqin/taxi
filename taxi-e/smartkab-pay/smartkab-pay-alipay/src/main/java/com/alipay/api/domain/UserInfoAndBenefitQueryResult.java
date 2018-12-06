package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class UserInfoAndBenefitQueryResult extends AlipayObject {
    private static final long serialVersionUID = 5744962514539636627L;

    @ApiField("balance")
    private Long balance;

    @ApiListField("benefit_info_list")
    @ApiField("benefit_grade_point")
    private List<BenefitGradePoint> benefitInfoList;

    @ApiField("grade")
    private String grade;

    public Long getBalance() {
        /* 39 */
        return this.balance;
    }

    public void setBalance(Long balance) {
        /* 42 */
        this.balance = balance;
    }

    public List<BenefitGradePoint> getBenefitInfoList() {
        /* 46 */
        return this.benefitInfoList;
    }

    public void setBenefitInfoList(List<BenefitGradePoint> benefitInfoList) {
        /* 49 */
        this.benefitInfoList = benefitInfoList;
    }

    public String getGrade() {
        /* 53 */
        return this.grade;
    }

    public void setGrade(String grade) {
        /* 56 */
        this.grade = grade;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.UserInfoAndBenefitQueryResult
 * JD-Core Version:    0.6.0
 */