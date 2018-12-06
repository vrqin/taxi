package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class RoyaltyInfo extends AlipayObject {
    private static final long serialVersionUID = 5618773853141942694L;

    @ApiListField("royalty_detail_infos")
    @ApiField("royalty_detail_infos")
    private List<RoyaltyDetailInfos> royaltyDetailInfos;

    @ApiField("royalty_type")
    private String royaltyType;

    public List<RoyaltyDetailInfos> getRoyaltyDetailInfos() {
        /* 34 */
        return this.royaltyDetailInfos;
    }

    public void setRoyaltyDetailInfos(List<RoyaltyDetailInfos> royaltyDetailInfos) {
        /* 37 */
        this.royaltyDetailInfos = royaltyDetailInfos;
    }

    public String getRoyaltyType() {
        /* 41 */
        return this.royaltyType;
    }

    public void setRoyaltyType(String royaltyType) {
        /* 44 */
        this.royaltyType = royaltyType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RoyaltyInfo
 * JD-Core Version:    0.6.0
 */