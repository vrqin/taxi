package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipaySocialBaseGroupmemberAddModel extends AlipayObject {
    private static final long serialVersionUID = 4197863174228433262L;

    @ApiField("friend_validate")
    private Boolean friendValidate;

    @ApiField("group_id")
    private String groupId;

    @ApiListField("user_ids")
    @ApiField("string")
    private List<String> userIds;

    public Boolean getFriendValidate() {
        /* 39 */
        return this.friendValidate;
    }

    public void setFriendValidate(Boolean friendValidate) {
        /* 42 */
        this.friendValidate = friendValidate;
    }

    public String getGroupId() {
        /* 46 */
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        /* 49 */
        this.groupId = groupId;
    }

    public List<String> getUserIds() {
        /* 53 */
        return this.userIds;
    }

    public void setUserIds(List<String> userIds) {
        /* 56 */
        this.userIds = userIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseGroupmemberAddModel
 * JD-Core Version:    0.6.0
 */