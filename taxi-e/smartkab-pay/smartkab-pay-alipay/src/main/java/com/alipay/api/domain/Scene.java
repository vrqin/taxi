package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Scene extends AlipayObject {
    private static final long serialVersionUID = 1359321124777877946L;

    @ApiField("scene_id")
    private String sceneId;

    public String getSceneId() {
        /* 23 */
        return this.sceneId;
    }

    public void setSceneId(String sceneId) {
        /* 26 */
        this.sceneId = sceneId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Scene
 * JD-Core Version:    0.6.0
 */