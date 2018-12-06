package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberDataExtitemQuerypageModel extends AlipayObject {
    private static final long serialVersionUID = 7726954413728786199L;

    @ApiField("brand_code")
    private String brandCode;

    @ApiField("category_code")
    private String categoryCode;

    @ApiField("page_num")
    private String pageNum;

    @ApiField("page_size")
    private String pageSize;

    @ApiField("title")
    private String title;

    public String getBrandCode() {
        /* 47 */
        return this.brandCode;
    }

    public void setBrandCode(String brandCode) {
        /* 50 */
        this.brandCode = brandCode;
    }

    public String getCategoryCode() {
        /* 54 */
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        /* 57 */
        this.categoryCode = categoryCode;
    }

    public String getPageNum() {
        /* 61 */
        return this.pageNum;
    }

    public void setPageNum(String pageNum) {
        /* 64 */
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        /* 68 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 71 */
        this.pageSize = pageSize;
    }

    public String getTitle() {
        /* 75 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 78 */
        this.title = title;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMemberDataExtitemQuerypageModel
 * JD-Core Version:    0.6.0
 */