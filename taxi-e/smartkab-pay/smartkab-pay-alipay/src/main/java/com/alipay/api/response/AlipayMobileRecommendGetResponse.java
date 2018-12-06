package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileRecommendGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 6792161755651621597L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("items")
    private String items;

    @ApiField("recommend_id")
    private String recommendId;

    public String getExtInfo() {
        /* 39 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 36 */
        this.extInfo = extInfo;
    }

    public String getItems() {
        /* 46 */
        return this.items;
    }

    public void setItems(String items) {
        /* 43 */
        this.items = items;
    }

    public String getRecommendId() {
        /* 53 */
        return this.recommendId;
    }

    public void setRecommendId(String recommendId) {
        /* 50 */
        this.recommendId = recommendId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileRecommendGetResponse
 * JD-Core Version:    0.6.0
 */