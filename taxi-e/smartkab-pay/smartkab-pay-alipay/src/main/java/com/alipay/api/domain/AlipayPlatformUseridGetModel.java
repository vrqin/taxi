package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayPlatformUseridGetModel extends AlipayObject {
    private static final long serialVersionUID = 6448546683713937569L;

    @ApiListField("open_ids")
    @ApiField("string")
    private List<String> openIds;

    public List<String> getOpenIds() {
        /* 27 */
        return this.openIds;
    }

    public void setOpenIds(List<String> openIds) {
        /* 30 */
        this.openIds = openIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPlatformUseridGetModel
 * JD-Core Version:    0.6.0
 */