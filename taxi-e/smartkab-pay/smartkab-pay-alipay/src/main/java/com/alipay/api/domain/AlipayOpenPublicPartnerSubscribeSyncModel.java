package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicPartnerSubscribeSyncModel extends AlipayObject {
    private static final long serialVersionUID = 3149835522576298596L;

    @ApiField("accept_msg")
    private String acceptMsg;

    @ApiField("follow_object_id")
    private String followObjectId;

    @ApiField("operate_type")
    private String operateType;

    @ApiField("push_switch")
    private String pushSwitch;

    @ApiField("source_id")
    private String sourceId;

    @ApiField("user_id")
    private String userId;

    public String getAcceptMsg() {
        /* 53 */
        return this.acceptMsg;
    }

    public void setAcceptMsg(String acceptMsg) {
        /* 56 */
        this.acceptMsg = acceptMsg;
    }

    public String getFollowObjectId() {
        /* 60 */
        return this.followObjectId;
    }

    public void setFollowObjectId(String followObjectId) {
        /* 63 */
        this.followObjectId = followObjectId;
    }

    public String getOperateType() {
        /* 67 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 70 */
        this.operateType = operateType;
    }

    public String getPushSwitch() {
        /* 74 */
        return this.pushSwitch;
    }

    public void setPushSwitch(String pushSwitch) {
        /* 77 */
        this.pushSwitch = pushSwitch;
    }

    public String getSourceId() {
        /* 81 */
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        /* 84 */
        this.sourceId = sourceId;
    }

    public String getUserId() {
        /* 88 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 91 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicPartnerSubscribeSyncModel
 * JD-Core Version:    0.6.0
 */