package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class EduStudentInfoShareResult extends AlipayObject {
    private static final long serialVersionUID = 6782647895859479842L;

    @ApiField("biz_type")
    private String bizType;

    @ApiListField("student_infos")
    @ApiField("student_info")
    private List<StudentInfo> studentInfos;

    @ApiField("user_id")
    private String userId;

    public String getBizType() {
        /* 39 */
        return this.bizType;
    }

    public void setBizType(String bizType) {
        /* 42 */
        this.bizType = bizType;
    }

    public List<StudentInfo> getStudentInfos() {
        /* 46 */
        return this.studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        /* 49 */
        this.studentInfos = studentInfos;
    }

    public String getUserId() {
        /* 53 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 56 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.EduStudentInfoShareResult
 * JD-Core Version:    0.6.0
 */