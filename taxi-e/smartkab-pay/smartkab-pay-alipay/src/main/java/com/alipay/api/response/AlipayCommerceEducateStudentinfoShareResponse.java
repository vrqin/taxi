package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.EduStudentInfoShareResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceEducateStudentinfoShareResponse extends AlipayResponse {
    private static final long serialVersionUID = 1297993694221774884L;

    @ApiField("student_info_share_result")
    private EduStudentInfoShareResult studentInfoShareResult;

    public EduStudentInfoShareResult getStudentInfoShareResult() {
        /* 28 */
        return this.studentInfoShareResult;
    }

    public void setStudentInfoShareResult(EduStudentInfoShareResult studentInfoShareResult) {
        /* 25 */
        this.studentInfoShareResult = studentInfoShareResult;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceEducateStudentinfoShareResponse
 * JD-Core Version:    0.6.0
 */