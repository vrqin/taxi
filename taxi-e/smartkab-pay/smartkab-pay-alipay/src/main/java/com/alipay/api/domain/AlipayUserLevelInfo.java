package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserLevelInfo extends AlipayObject {
    private static final long serialVersionUID = 5297143957476965388L;

    @ApiField("login_id")
    private String loginId;

    @ApiField("user_id")
    private String userId;

    @ApiField("user_level")
    private String userLevel;

    public String getLoginId() {
        /* 35 */
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        /* 38 */
        this.loginId = loginId;
    }

    public String getUserId() {
        /* 42 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 45 */
        this.userId = userId;
    }

    public String getUserLevel() {
        /* 49 */
        return this.userLevel;
    }

    public void setUserLevel(String userLevel) {
        /* 52 */
        this.userLevel = userLevel;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayUserLevelInfo
 * JD-Core Version:    0.6.0
 */