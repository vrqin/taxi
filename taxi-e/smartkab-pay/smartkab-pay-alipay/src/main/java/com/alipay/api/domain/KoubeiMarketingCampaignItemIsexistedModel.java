package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCampaignItemIsexistedModel extends AlipayObject {
    private static final long serialVersionUID = 6684242453833612432L;

    @ApiListField("code_list")
    @ApiField("string")
    private List<String> codeList;

    public List<String> getCodeList() {
        /* 27 */
        return this.codeList;
    }

    public void setCodeList(List<String> codeList) {
        /* 30 */
        this.codeList = codeList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignItemIsexistedModel
 * JD-Core Version:    0.6.0
 */