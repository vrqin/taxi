package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineProviderStaffUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 4384854421114292368L;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("operate_result")
    private String operateResult;

    @ApiField("operate_type")
    private String operateType;

    @ApiField("pid")
    private String pid;

    @ApiField("staff_id")
    private String staffId;

    public String getErrorMsg() {
        /* 51 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 48 */
        this.errorMsg = errorMsg;
    }

    public String getOperateResult() {
        /* 58 */
        return this.operateResult;
    }

    public void setOperateResult(String operateResult) {
        /* 55 */
        this.operateResult = operateResult;
    }

    public String getOperateType() {
        /* 65 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 62 */
        this.operateType = operateType;
    }

    public String getPid() {
        /* 72 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 69 */
        this.pid = pid;
    }

    public String getStaffId() {
        /* 79 */
        return this.staffId;
    }

    public void setStaffId(String staffId) {
        /* 76 */
        this.staffId = staffId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineProviderStaffUpdateResponse
 * JD-Core Version:    0.6.0
 */