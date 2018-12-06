package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ContactFollower extends AlipayObject {
    private static final long serialVersionUID = 6846273222161139671L;

    @ApiField("avatar")
    private String avatar;

    @ApiField("default_avatar")
    private String defaultAvatar;

    @ApiField("each_record_flag")
    private String eachRecordFlag;

    @ApiField("user_id")
    private String userId;

    public String getAvatar() {
        /* 41 */
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        /* 44 */
        this.avatar = avatar;
    }

    public String getDefaultAvatar() {
        /* 48 */
        return this.defaultAvatar;
    }

    public void setDefaultAvatar(String defaultAvatar) {
        /* 51 */
        this.defaultAvatar = defaultAvatar;
    }

    public String getEachRecordFlag() {
        /* 55 */
        return this.eachRecordFlag;
    }

    public void setEachRecordFlag(String eachRecordFlag) {
        /* 58 */
        this.eachRecordFlag = eachRecordFlag;
    }

    public String getUserId() {
        /* 62 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 65 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ContactFollower
 * JD-Core Version:    0.6.0
 */