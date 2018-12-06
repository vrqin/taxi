package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class StudentInfo extends AlipayObject {
    private static final long serialVersionUID = 3582776788677974121L;


    @ApiField("city_no")
    private String cityNo;


    @ApiField("class_name")
    private String className;


    @ApiField("college_name")
    private String collegeName;


    @ApiField("college_no")
    private String collegeNo;


    @ApiField("degree")
    private String degree;


    @ApiField("departments")
    private String departments;


    @ApiField("gmt_enrollment")
    private Date gmtEnrollment;


    @ApiField("gmt_graduation")
    private Date gmtGraduation;


    @ApiField("major")
    private String major;


    @ApiField("student_id")
    private String studentId;


    public String getCityNo() {
        /*  79 */
        return this.cityNo;

    }


    public void setCityNo(String cityNo) {
        /*  82 */
        this.cityNo = cityNo;

    }


    public String getClassName() {
        /*  86 */
        return this.className;

    }


    public void setClassName(String className) {
        /*  89 */
        this.className = className;

    }


    public String getCollegeName() {
        /*  93 */
        return this.collegeName;

    }


    public void setCollegeName(String collegeName) {
        /*  96 */
        this.collegeName = collegeName;

    }


    public String getCollegeNo() {
        /* 100 */
        return this.collegeNo;

    }


    public void setCollegeNo(String collegeNo) {
        /* 103 */
        this.collegeNo = collegeNo;

    }


    public String getDegree() {
        /* 107 */
        return this.degree;

    }


    public void setDegree(String degree) {
        /* 110 */
        this.degree = degree;

    }


    public String getDepartments() {
        /* 114 */
        return this.departments;

    }


    public void setDepartments(String departments) {
        /* 117 */
        this.departments = departments;

    }


    public Date getGmtEnrollment() {
        /* 121 */
        return this.gmtEnrollment;

    }


    public void setGmtEnrollment(Date gmtEnrollment) {
        /* 124 */
        this.gmtEnrollment = gmtEnrollment;

    }


    public Date getGmtGraduation() {
        /* 128 */
        return this.gmtGraduation;

    }


    public void setGmtGraduation(Date gmtGraduation) {
        /* 131 */
        this.gmtGraduation = gmtGraduation;

    }


    public String getMajor() {
        /* 135 */
        return this.major;

    }


    public void setMajor(String major) {
        /* 138 */
        this.major = major;

    }


    public String getStudentId() {
        /* 142 */
        return this.studentId;

    }


    public void setStudentId(String studentId) {
        /* 145 */
        this.studentId = studentId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.StudentInfo
 * JD-Core Version:    0.6.0
 */