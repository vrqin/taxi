package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileBksigntokenVerifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 4199339933926417661L;

    @ApiField("createtimestamp")
    private String createtimestamp;

    @ApiField("loginid")
    private String loginid;

    @ApiField("memo")
    private String memo;

    @ApiField("resultcode")
    private Long resultcode;

    @ApiField("success")
    private Boolean success;

    @ApiField("userid")
    private String userid;

    public String getCreatetimestamp() {
        /* 57 */
        return this.createtimestamp;
    }

    public void setCreatetimestamp(String createtimestamp) {
        /* 54 */
        this.createtimestamp = createtimestamp;
    }

    public String getLoginid() {
        /* 64 */
        return this.loginid;
    }

    public void setLoginid(String loginid) {
        /* 61 */
        this.loginid = loginid;
    }

    public String getMemo() {
        /* 71 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 68 */
        this.memo = memo;
    }

    public Long getResultcode() {
        /* 78 */
        return this.resultcode;
    }

    public void setResultcode(Long resultcode) {
        /* 75 */
        this.resultcode = resultcode;
    }

    public Boolean getSuccess() {
        /* 85 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 82 */
        this.success = success;
    }

    public String getUserid() {
        /* 92 */
        return this.userid;
    }

    public void setUserid(String userid) {
        /* 89 */
        this.userid = userid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileBksigntokenVerifyResponse
 * JD-Core Version:    0.6.0
 */