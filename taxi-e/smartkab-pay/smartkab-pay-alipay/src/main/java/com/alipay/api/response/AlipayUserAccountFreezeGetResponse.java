package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AccountFreeze;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayUserAccountFreezeGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5372915158637345893L;

    @ApiListField("freeze_items")
    @ApiField("account_freeze")
    private List<AccountFreeze> freezeItems;

    @ApiField("total_results")
    private String totalResults;

    public List<AccountFreeze> getFreezeItems() {
        /* 37 */
        return this.freezeItems;
    }

    public void setFreezeItems(List<AccountFreeze> freezeItems) {
        /* 34 */
        this.freezeItems = freezeItems;
    }

    public String getTotalResults() {
        /* 44 */
        return this.totalResults;
    }

    public void setTotalResults(String totalResults) {
        /* 41 */
        this.totalResults = totalResults;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserAccountFreezeGetResponse
 * JD-Core Version:    0.6.0
 */