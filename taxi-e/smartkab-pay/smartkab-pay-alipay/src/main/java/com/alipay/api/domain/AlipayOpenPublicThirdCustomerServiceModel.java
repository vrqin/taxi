package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicThirdCustomerServiceModel extends AlipayObject {
    private static final long serialVersionUID = 5876927948882328747L;

    @ApiField("channel_uid")
    private String channelUid;

    public String getChannelUid() {
        /* 23 */
        return this.channelUid;
    }

    public void setChannelUid(String channelUid) {
        /* 26 */
        this.channelUid = channelUid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicThirdCustomerServiceModel
 * JD-Core Version:    0.6.0
 */