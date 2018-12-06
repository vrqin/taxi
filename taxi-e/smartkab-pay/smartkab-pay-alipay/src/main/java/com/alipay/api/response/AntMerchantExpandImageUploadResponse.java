package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AntMerchantExpandImageUploadResponse extends AlipayResponse {
    private static final long serialVersionUID = 4114484888496644915L;

    @ApiField("image_id")
    private String imageId;

    public String getImageId() {
        /* 27 */
        return this.imageId;
    }

    public void setImageId(String imageId) {
        /* 24 */
        this.imageId = imageId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AntMerchantExpandImageUploadResponse
 * JD-Core Version:    0.6.0
 */