package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExtCategory;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiItemExtitemCategoryQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1625941936551147126L;

    @ApiListField("category_list")
    @ApiField("ext_category")
    private List<ExtCategory> categoryList;

    public List<ExtCategory> getCategoryList() {
        /* 31 */
        return this.categoryList;
    }

    public void setCategoryList(List<ExtCategory> categoryList) {
        /* 28 */
        this.categoryList = categoryList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiItemExtitemCategoryQueryResponse
 * JD-Core Version:    0.6.0
 */