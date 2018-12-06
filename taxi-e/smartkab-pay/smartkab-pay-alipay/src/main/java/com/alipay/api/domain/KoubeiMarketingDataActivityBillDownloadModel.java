package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataActivityBillDownloadModel extends AlipayObject {
    private static final long serialVersionUID = 5221192685614269961L;

    @ApiField("camp_id")
    private String campId;

    public String getCampId() {
        /* 23 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 26 */
        this.campId = campId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataActivityBillDownloadModel
 * JD-Core Version:    0.6.0
 */