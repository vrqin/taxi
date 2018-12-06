package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayInsAutoSavecarModel extends AlipayObject {
    private static final long serialVersionUID = 7498872579354138842L;

    @ApiField("car_no")
    private String carNo;

    @ApiField("user_id")
    private String userId;

    public String getCarNo() {
        /* 29 */
        return this.carNo;
    }

    public void setCarNo(String carNo) {
        /* 32 */
        this.carNo = carNo;
    }

    public String getUserId() {
        /* 36 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 39 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayInsAutoSavecarModel
 * JD-Core Version:    0.6.0
 */