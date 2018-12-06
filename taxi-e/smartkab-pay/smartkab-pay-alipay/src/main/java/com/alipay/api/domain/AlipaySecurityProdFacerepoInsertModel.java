package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityProdFacerepoInsertModel extends AlipayObject {
    private static final long serialVersionUID = 8874999984296969357L;

    @ApiField("biz_id")
    private String bizId;

    @ApiField("face_str")
    private String faceStr;

    @ApiField("group_id")
    private String groupId;

    public String getBizId() {
        /* 35 */
        return this.bizId;
    }

    public void setBizId(String bizId) {
        /* 38 */
        this.bizId = bizId;
    }

    public String getFaceStr() {
        /* 42 */
        return this.faceStr;
    }

    public void setFaceStr(String faceStr) {
        /* 45 */
        this.faceStr = faceStr;
    }

    public String getGroupId() {
        /* 49 */
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        /* 52 */
        this.groupId = groupId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityProdFacerepoInsertModel
 * JD-Core Version:    0.6.0
 */