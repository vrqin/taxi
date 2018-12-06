package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class ClaimProgress extends AlipayObject {
    private static final long serialVersionUID = 3276592799917293731L;

    @ApiField("update_content")
    private String updateContent;

    @ApiField("update_time")
    private Date updateTime;

    public String getUpdateContent() {
        /* 31 */
        return this.updateContent;
    }

    public void setUpdateContent(String updateContent) {
        /* 34 */
        this.updateContent = updateContent;
    }

    public Date getUpdateTime() {
        /* 38 */
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        /* 41 */
        this.updateTime = updateTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ClaimProgress
 * JD-Core Version:    0.6.0
 */