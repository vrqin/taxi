package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityProdFacerepoAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 8778987992848578294L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("face_id")
    private String faceId;

    public String getExtInfo() {
        /* 33 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 30 */
        this.extInfo = extInfo;
    }

    public String getFaceId() {
        /* 40 */
        return this.faceId;
    }

    public void setFaceId(String faceId) {
        /* 37 */
        this.faceId = faceId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityProdFacerepoAddResponse
 * JD-Core Version:    0.6.0
 */