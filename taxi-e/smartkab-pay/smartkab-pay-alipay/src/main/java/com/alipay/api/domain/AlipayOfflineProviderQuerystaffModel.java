package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineProviderQuerystaffModel extends AlipayObject {
    private static final long serialVersionUID = 3571232559588338989L;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("page_no")
    private String pageNo;

    @ApiField("page_size")
    private String pageSize;

    @ApiField("request_id")
    private String requestId;

    public String getOpePid() {
        /* 41 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 44 */
        this.opePid = opePid;
    }

    public String getPageNo() {
        /* 48 */
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        /* 51 */
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        /* 55 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 58 */
        this.pageSize = pageSize;
    }

    public String getRequestId() {
        /* 62 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 65 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineProviderQuerystaffModel
 * JD-Core Version:    0.6.0
 */