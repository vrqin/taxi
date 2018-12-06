package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayOfflineMarketLeadsModifyModel extends AlipayObject {
    private static final long serialVersionUID = 4686933793389688631L;


    @ApiField("address")
    private String address;


    @ApiField("auth_letter")
    private String authLetter;


    @ApiField("avg_price")
    private String avgPrice;


    @ApiField("box")
    private String box;


    @ApiField("branch_shop_name")
    private String branchShopName;


    @ApiField("brand_logo")
    private String brandLogo;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("business_certificate")
    private String businessCertificate;


    @ApiField("business_certificate_expires")
    private String businessCertificateExpires;


    @ApiField("business_time")
    private String businessTime;


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


    @ApiField("implement_id")
    private String implementId;


    @ApiField("is_complete")
    private String isComplete;


    @ApiField("is_operating_online")
    private String isOperatingOnline;


    @ApiField("latitude")
    private Long latitude;


    @ApiField("leads_id")
    private String leadsId;


    @ApiField("licence")
    private String licence;


    @ApiField("licence_code")
    private String licenceCode;


    @ApiField("licence_expires")
    private String licenceExpires;


    @ApiField("licence_name")
    private String licenceName;


    @ApiField("longitude")
    private Long longitude;


    @ApiField("main_image")
    private String mainImage;


    @ApiField("main_shop_name")
    private String mainShopName;


    @ApiField("memo")
    private String memo;


    @ApiField("no_smoking")
    private String noSmoking;


    @ApiField("online_url")
    private String onlineUrl;


    @ApiField("op_id")
    private String opId;


    @ApiField("operate_notify_url")
    private String operateNotifyUrl;


    @ApiField("other_authorization")
    private String otherAuthorization;


    @ApiField("other_contact_info")
    private String otherContactInfo;


    @ApiField("parking")
    private String parking;


    @ApiField("pay_type")
    private String payType;


    @ApiField("province_code")
    private String provinceCode;


    @ApiField("request_id")
    private String requestId;


    @ApiField("store_id")
    private String storeId;


    @ApiField("value_added")
    private String valueAdded;


    @ApiField("wifi")
    private String wifi;


    public String getAddress() {
        /* 280 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 283 */
        this.address = address;

    }


    public String getAuthLetter() {
        /* 287 */
        return this.authLetter;

    }


    public void setAuthLetter(String authLetter) {
        /* 290 */
        this.authLetter = authLetter;

    }


    public String getAvgPrice() {
        /* 294 */
        return this.avgPrice;

    }


    public void setAvgPrice(String avgPrice) {
        /* 297 */
        this.avgPrice = avgPrice;

    }


    public String getBox() {
        /* 301 */
        return this.box;

    }


    public void setBox(String box) {
        /* 304 */
        this.box = box;

    }


    public String getBranchShopName() {
        /* 308 */
        return this.branchShopName;

    }


    public void setBranchShopName(String branchShopName) {
        /* 311 */
        this.branchShopName = branchShopName;

    }


    public String getBrandLogo() {
        /* 315 */
        return this.brandLogo;

    }


    public void setBrandLogo(String brandLogo) {
        /* 318 */
        this.brandLogo = brandLogo;

    }


    public String getBrandName() {
        /* 322 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 325 */
        this.brandName = brandName;

    }


    public String getBusinessCertificate() {
        /* 329 */
        return this.businessCertificate;

    }


    public void setBusinessCertificate(String businessCertificate) {
        /* 332 */
        this.businessCertificate = businessCertificate;

    }


    public String getBusinessCertificateExpires() {
        /* 336 */
        return this.businessCertificateExpires;

    }


    public void setBusinessCertificateExpires(String businessCertificateExpires) {
        /* 339 */
        this.businessCertificateExpires = businessCertificateExpires;

    }


    public String getBusinessTime() {
        /* 343 */
        return this.businessTime;

    }


    public void setBusinessTime(String businessTime) {
        /* 346 */
        this.businessTime = businessTime;

    }


    public String getCategoryId() {
        /* 350 */
        return this.categoryId;

    }


    public void setCategoryId(String categoryId) {
        /* 353 */
        this.categoryId = categoryId;

    }


    public String getCityCode() {
        /* 357 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /* 360 */
        this.cityCode = cityCode;

    }


    public String getCompanyName() {
        /* 364 */
        return this.companyName;

    }


    public void setCompanyName(String companyName) {
        /* 367 */
        this.companyName = companyName;

    }


    public String getContactName() {
        /* 371 */
        return this.contactName;

    }


    public void setContactName(String contactName) {
        /* 374 */
        this.contactName = contactName;

    }


    public String getContactNumber() {
        /* 378 */
        return this.contactNumber;

    }


    public void setContactNumber(String contactNumber) {
        /* 381 */
        this.contactNumber = contactNumber;

    }


    public List<String> getDetailImages() {
        /* 385 */
        return this.detailImages;

    }


    public void setDetailImages(List<String> detailImages) {
        /* 388 */
        this.detailImages = detailImages;

    }


    public String getDistrictCode() {
        /* 392 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 395 */
        this.districtCode = districtCode;

    }


    public String getImplementId() {
        /* 399 */
        return this.implementId;

    }


    public void setImplementId(String implementId) {
        /* 402 */
        this.implementId = implementId;

    }


    public String getIsComplete() {
        /* 406 */
        return this.isComplete;

    }


    public void setIsComplete(String isComplete) {
        /* 409 */
        this.isComplete = isComplete;

    }


    public String getIsOperatingOnline() {
        /* 413 */
        return this.isOperatingOnline;

    }


    public void setIsOperatingOnline(String isOperatingOnline) {
        /* 416 */
        this.isOperatingOnline = isOperatingOnline;

    }


    public Long getLatitude() {
        /* 420 */
        return this.latitude;

    }


    public void setLatitude(Long latitude) {
        /* 423 */
        this.latitude = latitude;

    }


    public String getLeadsId() {
        /* 427 */
        return this.leadsId;

    }


    public void setLeadsId(String leadsId) {
        /* 430 */
        this.leadsId = leadsId;

    }


    public String getLicence() {
        /* 434 */
        return this.licence;

    }


    public void setLicence(String licence) {
        /* 437 */
        this.licence = licence;

    }


    public String getLicenceCode() {
        /* 441 */
        return this.licenceCode;

    }


    public void setLicenceCode(String licenceCode) {
        /* 444 */
        this.licenceCode = licenceCode;

    }


    public String getLicenceExpires() {
        /* 448 */
        return this.licenceExpires;

    }


    public void setLicenceExpires(String licenceExpires) {
        /* 451 */
        this.licenceExpires = licenceExpires;

    }


    public String getLicenceName() {
        /* 455 */
        return this.licenceName;

    }


    public void setLicenceName(String licenceName) {
        /* 458 */
        this.licenceName = licenceName;

    }


    public Long getLongitude() {
        /* 462 */
        return this.longitude;

    }


    public void setLongitude(Long longitude) {
        /* 465 */
        this.longitude = longitude;

    }


    public String getMainImage() {
        /* 469 */
        return this.mainImage;

    }


    public void setMainImage(String mainImage) {
        /* 472 */
        this.mainImage = mainImage;

    }


    public String getMainShopName() {
        /* 476 */
        return this.mainShopName;

    }


    public void setMainShopName(String mainShopName) {
        /* 479 */
        this.mainShopName = mainShopName;

    }


    public String getMemo() {
        /* 483 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 486 */
        this.memo = memo;

    }


    public String getNoSmoking() {
        /* 490 */
        return this.noSmoking;

    }


    public void setNoSmoking(String noSmoking) {
        /* 493 */
        this.noSmoking = noSmoking;

    }


    public String getOnlineUrl() {
        /* 497 */
        return this.onlineUrl;

    }


    public void setOnlineUrl(String onlineUrl) {
        /* 500 */
        this.onlineUrl = onlineUrl;

    }


    public String getOpId() {
        /* 504 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 507 */
        this.opId = opId;

    }


    public String getOperateNotifyUrl() {
        /* 511 */
        return this.operateNotifyUrl;

    }


    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 514 */
        this.operateNotifyUrl = operateNotifyUrl;

    }


    public String getOtherAuthorization() {
        /* 518 */
        return this.otherAuthorization;

    }


    public void setOtherAuthorization(String otherAuthorization) {
        /* 521 */
        this.otherAuthorization = otherAuthorization;

    }


    public String getOtherContactInfo() {
        /* 525 */
        return this.otherContactInfo;

    }


    public void setOtherContactInfo(String otherContactInfo) {
        /* 528 */
        this.otherContactInfo = otherContactInfo;

    }


    public String getParking() {
        /* 532 */
        return this.parking;

    }


    public void setParking(String parking) {
        /* 535 */
        this.parking = parking;

    }


    public String getPayType() {
        /* 539 */
        return this.payType;

    }


    public void setPayType(String payType) {
        /* 542 */
        this.payType = payType;

    }


    public String getProvinceCode() {
        /* 546 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 549 */
        this.provinceCode = provinceCode;

    }


    public String getRequestId() {
        /* 553 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 556 */
        this.requestId = requestId;

    }


    public String getStoreId() {
        /* 560 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 563 */
        this.storeId = storeId;

    }


    public String getValueAdded() {
        /* 567 */
        return this.valueAdded;

    }


    public void setValueAdded(String valueAdded) {
        /* 570 */
        this.valueAdded = valueAdded;

    }


    public String getWifi() {
        /* 574 */
        return this.wifi;

    }


    public void setWifi(String wifi) {
        /* 577 */
        this.wifi = wifi;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsModifyModel
 * JD-Core Version:    0.6.0
 */