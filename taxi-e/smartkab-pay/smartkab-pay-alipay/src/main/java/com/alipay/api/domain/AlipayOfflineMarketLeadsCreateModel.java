package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayOfflineMarketLeadsCreateModel extends AlipayObject {
    private static final long serialVersionUID = 3834841264254917156L;


    @ApiField("address")
    private String address;


    @ApiField("branch_shop_name")
    private String branchShopName;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("category_id")
    private String categoryId;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("company_name")
    private String companyName;


    @ApiField("contact_name")
    private String contactName;


    @ApiField("contact_number")
    private String contactNumber;


    @ApiListField("detail_images")

    @ApiField("string")
    private List<String> detailImages;


    @ApiField("district_code")
    private String districtCode;


    @ApiField("latitude")
    private Long latitude;


    @ApiField("longitude")
    private Long longitude;


    @ApiField("main_image")
    private String mainImage;


    @ApiField("main_shop_name")
    private String mainShopName;


    @ApiField("memo")
    private String memo;


    @ApiField("op_id")
    private String opId;


    @ApiField("operate_notify_url")
    private String operateNotifyUrl;


    @ApiField("other_contact_info")
    private String otherContactInfo;


    @ApiField("province_code")
    private String provinceCode;


    @ApiField("request_id")
    private String requestId;


    public String getAddress() {
        /* 141 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 144 */
        this.address = address;

    }


    public String getBranchShopName() {
        /* 148 */
        return this.branchShopName;

    }


    public void setBranchShopName(String branchShopName) {
        /* 151 */
        this.branchShopName = branchShopName;

    }


    public String getBrandName() {
        /* 155 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 158 */
        this.brandName = brandName;

    }


    public String getCategoryId() {
        /* 162 */
        return this.categoryId;

    }


    public void setCategoryId(String categoryId) {
        /* 165 */
        this.categoryId = categoryId;

    }


    public String getCityCode() {
        /* 169 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /* 172 */
        this.cityCode = cityCode;

    }


    public String getCompanyName() {
        /* 176 */
        return this.companyName;

    }


    public void setCompanyName(String companyName) {
        /* 179 */
        this.companyName = companyName;

    }


    public String getContactName() {
        /* 183 */
        return this.contactName;

    }


    public void setContactName(String contactName) {
        /* 186 */
        this.contactName = contactName;

    }


    public String getContactNumber() {
        /* 190 */
        return this.contactNumber;

    }


    public void setContactNumber(String contactNumber) {
        /* 193 */
        this.contactNumber = contactNumber;

    }


    public List<String> getDetailImages() {
        /* 197 */
        return this.detailImages;

    }


    public void setDetailImages(List<String> detailImages) {
        /* 200 */
        this.detailImages = detailImages;

    }


    public String getDistrictCode() {
        /* 204 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 207 */
        this.districtCode = districtCode;

    }


    public Long getLatitude() {
        /* 211 */
        return this.latitude;

    }


    public void setLatitude(Long latitude) {
        /* 214 */
        this.latitude = latitude;

    }


    public Long getLongitude() {
        /* 218 */
        return this.longitude;

    }


    public void setLongitude(Long longitude) {
        /* 221 */
        this.longitude = longitude;

    }


    public String getMainImage() {
        /* 225 */
        return this.mainImage;

    }


    public void setMainImage(String mainImage) {
        /* 228 */
        this.mainImage = mainImage;

    }


    public String getMainShopName() {
        /* 232 */
        return this.mainShopName;

    }


    public void setMainShopName(String mainShopName) {
        /* 235 */
        this.mainShopName = mainShopName;

    }


    public String getMemo() {
        /* 239 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 242 */
        this.memo = memo;

    }


    public String getOpId() {
        /* 246 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 249 */
        this.opId = opId;

    }


    public String getOperateNotifyUrl() {
        /* 253 */
        return this.operateNotifyUrl;

    }


    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 256 */
        this.operateNotifyUrl = operateNotifyUrl;

    }


    public String getOtherContactInfo() {
        /* 260 */
        return this.otherContactInfo;

    }


    public void setOtherContactInfo(String otherContactInfo) {
        /* 263 */
        this.otherContactInfo = otherContactInfo;

    }


    public String getProvinceCode() {
        /* 267 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 270 */
        this.provinceCode = provinceCode;

    }


    public String getRequestId() {
        /* 274 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 277 */
        this.requestId = requestId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsCreateModel
 * JD-Core Version:    0.6.0
 */