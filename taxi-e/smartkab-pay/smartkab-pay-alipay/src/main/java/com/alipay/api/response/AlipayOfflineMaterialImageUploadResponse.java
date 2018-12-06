package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMaterialImageUploadResponse extends AlipayResponse {
    private static final long serialVersionUID = 7355137934839844972L;

    @ApiField("image_id")
    private String imageId;

    @ApiField("image_url")
    private String imageUrl;

    public String getImageId() {
        /* 33 */
        return this.imageId;
    }

    public void setImageId(String imageId) {
        /* 30 */
        this.imageId = imageId;
    }

    public String getImageUrl() {
        /* 40 */
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        /* 37 */
        this.imageUrl = imageUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMaterialImageUploadResponse
 * JD-Core Version:    0.6.0
 */