package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class GroupMemberInfo extends AlipayObject {
    private static final long serialVersionUID = 4563815642131861794L;

    @ApiField("group_nickname")
    private String groupNickname;

    @ApiField("nickname")
    private String nickname;

    @ApiField("user_id")
    private String userId;

    public String getGroupNickname() {
        /* 35 */
        return this.groupNickname;
    }

    public void setGroupNickname(String groupNickname) {
        /* 38 */
        this.groupNickname = groupNickname;
    }

    public String getNickname() {
        /* 42 */
        return this.nickname;
    }

    public void setNickname(String nickname) {
        /* 45 */
        this.nickname = nickname;
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
 * Qualified Name:     com.alipay.api.domain.GroupMemberInfo
 * JD-Core Version:    0.6.0
 */