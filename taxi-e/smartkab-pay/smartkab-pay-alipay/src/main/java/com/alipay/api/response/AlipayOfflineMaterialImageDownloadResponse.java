package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMaterialImageDownloadResponse extends AlipayResponse {
    private static final long serialVersionUID = 6431898222182745692L;

    @ApiListField("image_urls")
    @ApiField("string")
    private List<String> imageUrls;

    public List<String> getImageUrls() {
        /* 30 */
        return this.imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        /* 27 */
        this.imageUrls = imageUrls;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMaterialImageDownloadResponse
 * JD-Core Version:    0.6.0
 */