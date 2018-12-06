package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarMerchantCommentSyncModel extends AlipayObject {
    private static final long serialVersionUID = 5517412757848992953L;

    @ApiField("vid")
    private String vid;

    public String getVid() {
        /* 23 */
        return this.vid;
    }

    public void setVid(String vid) {
        /* 26 */
        this.vid = vid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarMerchantCommentSyncModel
 * JD-Core Version:    0.6.0
 */