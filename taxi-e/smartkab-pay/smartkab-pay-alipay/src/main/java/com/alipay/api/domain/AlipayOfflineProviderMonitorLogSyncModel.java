package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineProviderMonitorLogSyncModel extends AlipayObject {
    private static final long serialVersionUID = 6173986414268511492L;

    @ApiListField("logs")
    @ApiField("i_s_v_log_sync")
    private List<ISVLogSync> logs;

    public List<ISVLogSync> getLogs() {
        /* 27 */
        return this.logs;
    }

    public void setLogs(List<ISVLogSync> logs) {
        /* 30 */
        this.logs = logs;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineProviderMonitorLogSyncModel
 * JD-Core Version:    0.6.0
 */