package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class MonitorHeartbeatSynResponse extends AlipayResponse {
    private static final long serialVersionUID = 3255897855315821735L;

    @ApiField("pid")
    private String pid;

    public String getPid() {
        /* 27 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 24 */
        this.pid = pid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.MonitorHeartbeatSynResponse
 * JD-Core Version:    0.6.0
 */