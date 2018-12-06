package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketExpensePostModel extends AlipayObject {
    private static final long serialVersionUID = 4336718738153426571L;

    @ApiField("action")
    private String action;

    @ApiField("request")
    private String request;

    public String getAction() {
        /* 29 */
        return this.action;
    }

    public void setAction(String action) {
        /* 32 */
        this.action = action;
    }

    public String getRequest() {
        /* 36 */
        return this.request;
    }

    public void setRequest(String request) {
        /* 39 */
        this.request = request;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketExpensePostModel
 * JD-Core Version:    0.6.0
 */