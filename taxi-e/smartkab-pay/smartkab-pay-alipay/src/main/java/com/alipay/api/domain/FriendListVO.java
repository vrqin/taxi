package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class FriendListVO extends AlipayObject {
    private static final long serialVersionUID = 3864395226693293753L;

    @ApiField("head_img")
    private String headImg;

    @ApiField("real_friend")
    private Boolean realFriend;

    @ApiField("user_id")
    private String userId;

    @ApiField("view_name")
    private String viewName;

    public String getHeadImg() {
        /* 41 */
        return this.headImg;
    }

    public void setHeadImg(String headImg) {
        /* 44 */
        this.headImg = headImg;
    }

    public Boolean getRealFriend() {
        /* 48 */
        return this.realFriend;
    }

    public void setRealFriend(Boolean realFriend) {
        /* 51 */
        this.realFriend = realFriend;
    }

    public String getUserId() {
        /* 55 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 58 */
        this.userId = userId;
    }

    public String getViewName() {
        /* 62 */
        return this.viewName;
    }

    public void setViewName(String viewName) {
        /* 65 */
        this.viewName = viewName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FriendListVO
 * JD-Core Version:    0.6.0
 */