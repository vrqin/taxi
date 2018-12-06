package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CustomTagInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomtagBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4494333539669153482L;

    @ApiListField("custom_tag_list")
    @ApiField("custom_tag_info")
    private List<CustomTagInfo> customTagList;

    public List<CustomTagInfo> getCustomTagList() {
        /* 31 */
        return this.customTagList;
    }

    public void setCustomTagList(List<CustomTagInfo> customTagList) {
        /* 28 */
        this.customTagList = customTagList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomtagBatchqueryResponse
 * JD-Core Version:    0.6.0
 */