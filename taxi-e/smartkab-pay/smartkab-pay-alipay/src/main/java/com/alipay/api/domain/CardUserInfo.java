package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CardUserInfo extends AlipayObject {
    private static final long serialVersionUID = 7464313726839686518L;

    @ApiField("user_uni_id")
    private String userUniId;

    @ApiField("user_uni_id_type")
    private String userUniIdType;

    public String getUserUniId() {
        /* 35 */
        return this.userUniId;
    }

    public void setUserUniId(String userUniId) {
        /* 38 */
        this.userUniId = userUniId;
    }

    public String getUserUniIdType() {
        /* 42 */
        return this.userUniIdType;
    }

    public void setUserUniIdType(String userUniIdType) {
        /* 45 */
        this.userUniIdType = userUniIdType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CardUserInfo
 * JD-Core Version:    0.6.0
 */