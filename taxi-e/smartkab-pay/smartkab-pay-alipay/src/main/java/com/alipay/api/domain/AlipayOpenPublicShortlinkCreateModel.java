package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicShortlinkCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2743874395815838535L;

    @ApiField("remark")
    private String remark;

    @ApiField("scene_id")
    private String sceneId;

    public String getRemark() {
        /* 29 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 32 */
        this.remark = remark;
    }

    public String getSceneId() {
        /* 36 */
        return this.sceneId;
    }

    public void setSceneId(String sceneId) {
        /* 39 */
        this.sceneId = sceneId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicShortlinkCreateModel
 * JD-Core Version:    0.6.0
 */