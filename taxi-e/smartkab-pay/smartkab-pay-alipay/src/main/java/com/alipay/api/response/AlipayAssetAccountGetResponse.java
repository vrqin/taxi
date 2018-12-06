package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AssetAccountResult;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayAssetAccountGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4734519858131439582L;

    @ApiListField("asset_list")
    @ApiField("asset_account_result")
    private List<AssetAccountResult> assetList;

    public List<AssetAccountResult> getAssetList() {
        /* 31 */
        return this.assetList;
    }

    public void setAssetList(List<AssetAccountResult> assetList) {
        /* 28 */
        this.assetList = assetList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAssetAccountGetResponse
 * JD-Core Version:    0.6.0
 */