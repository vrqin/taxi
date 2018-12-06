package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class NewsfeedWithMeInfo extends AlipayObject {
    private static final long serialVersionUID = 8679546246185293769L;

    @ApiField("login_id")
    private String loginId;

    @ApiField("user_id")
    private String userId;

    public String getLoginId() {
        /* 29 */
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        /* 32 */
        this.loginId = loginId;
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
 * Qualified Name:     com.alipay.api.domain.NewsfeedWithMeInfo
 * JD-Core Version:    0.6.0
 */