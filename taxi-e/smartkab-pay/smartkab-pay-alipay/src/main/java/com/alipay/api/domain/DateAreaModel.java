package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DateAreaModel extends AlipayObject {
    private static final long serialVersionUID = 2782541165831282213L;

    @ApiField("begin_date")
    private String beginDate;

    @ApiField("end_date")
    private String endDate;

    public String getBeginDate() {
        /* 29 */
        return this.beginDate;
    }

    public void setBeginDate(String beginDate) {
        /* 32 */
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        /* 36 */
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        /* 39 */
        this.endDate = endDate;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DateAreaModel
 * JD-Core Version:    0.6.0
 */