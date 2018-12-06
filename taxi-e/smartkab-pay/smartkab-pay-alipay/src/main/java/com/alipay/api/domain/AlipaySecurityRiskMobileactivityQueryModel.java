package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskMobileactivityQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4698593962382168643L;

    @ApiField("mobile")
    private String mobile;

    @ApiField("scene_id")
    private String sceneId;

    @ApiField("user_id")
    private String userId;

    public String getMobile() {
        /* 35 */
        return this.mobile;
    }

    public void setMobile(String mobile) {
        /* 38 */
        this.mobile = mobile;
    }

    public String getSceneId() {
        /* 42 */
        return this.sceneId;
    }

    public void setSceneId(String sceneId) {
        /* 45 */
        this.sceneId = sceneId;
    }

    public String getUserId() {
        /* 49 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 52 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityRiskMobileactivityQueryModel
 * JD-Core Version:    0.6.0
 */