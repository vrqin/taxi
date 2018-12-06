package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class ShopSummaryQueryResponse extends AlipayObject {
    private static final long serialVersionUID = 1861577262642672249L;


    @ApiField("address")
    private String address;


    @ApiField("branch_shop_name")
    private String branchShopName;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("business_time")
    private String businessTime;


    @ApiListField("category_infos")

    @ApiField("shop_category_info")
    private List<ShopCategoryInfo> categoryInfos;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("district_code")
    private String districtCode;


    @ApiField("gmt_create")
    private String gmtCreate;


    @ApiField("main_shop_name")
    private String mainShopName;


    @ApiField("province_code")
    private String provinceCode;


    @ApiField("shop_id")
    private String shopId;


    @ApiField("shop_type")
    private String shopType;


    @ApiField("status")
    private String status;


    public String getAddress() {
        /*  99 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 102 */
        this.address = address;

    }


    public String getBranchShopName() {
        /* 106 */
        return this.branchShopName;

    }


    public void setBranchShopName(String branchShopName) {
        /* 109 */
        this.branchShopName = branchShopName;

    }


    public String getBrandName() {
        /* 113 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 116 */
        this.brandName = brandName;

    }


    public String getBusinessTime() {
        /* 120 */
        return this.businessTime;

    }


    public void setBusinessTime(String businessTime) {
        /* 123 */
        this.businessTime = businessTime;

    }


    public List<ShopCategoryInfo> getCategoryInfos() {
        /* 127 */
        return this.categoryInfos;

    }


    public void setCategoryInfos(List<ShopCategoryInfo> categoryInfos) {
        /* 130 */
        this.categoryInfos = categoryInfos;

    }


    public String getCityCode() {
        /* 134 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /* 137 */
        this.cityCode = cityCode;

    }


    public String getDistrictCode() {
        /* 141 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 144 */
        this.districtCode = districtCode;

    }


    public String getGmtCreate() {
        /* 148 */
        return this.gmtCreate;

    }


    public void setGmtCreate(String gmtCreate) {
        /* 151 */
        this.gmtCreate = gmtCreate;

    }


    public String getMainShopName() {
        /* 155 */
        return this.mainShopName;

    }


    public void setMainShopName(String mainShopName) {
        /* 158 */
        this.mainShopName = mainShopName;

    }


    public String getProvinceCode() {
        /* 162 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 165 */
        this.provinceCode = provinceCode;

    }


    public String getShopId() {
        /* 169 */
        return this.shopId;

    }


    public void setShopId(String shopId) {
        /* 172 */
        this.shopId = shopId;

    }


    public String getShopType() {
        /* 176 */
        return this.shopType;

    }


    public void setShopType(String shopType) {
        /* 179 */
        this.shopType = shopType;

    }


    public String getStatus() {
        /* 183 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 186 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ShopSummaryQueryResponse
 * JD-Core Version:    0.6.0
 */