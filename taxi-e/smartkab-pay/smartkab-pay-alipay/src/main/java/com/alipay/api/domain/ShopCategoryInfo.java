package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ShopCategoryInfo extends AlipayObject {
    private static final long serialVersionUID = 6383418396617216154L;

    @ApiField("category_id")
    private String categoryId;

    @ApiField("category_level")
    private String categoryLevel;

    @ApiField("category_name")
    private String categoryName;

    public String getCategoryId() {
        /* 35 */
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        /* 38 */
        this.categoryId = categoryId;
    }

    public String getCategoryLevel() {
        /* 42 */
        return this.categoryLevel;
    }

    public void setCategoryLevel(String categoryLevel) {
        /* 45 */
        this.categoryLevel = categoryLevel;
    }

    public String getCategoryName() {
        /* 49 */
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        /* 52 */
        this.categoryName = categoryName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ShopCategoryInfo
 * JD-Core Version:    0.6.0
 */