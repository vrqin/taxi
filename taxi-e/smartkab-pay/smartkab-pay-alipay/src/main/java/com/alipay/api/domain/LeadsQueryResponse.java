package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class LeadsQueryResponse extends AlipayObject {
    private static final long serialVersionUID = 3592916238691389172L;


    @ApiField("address")
    private String address;


    @ApiField("auth_letter")
    private String authLetter;


    @ApiField("auth_letter_url")
    private String authLetterUrl;


    @ApiField("avg_price")
    private String avgPrice;


    @ApiField("box")
    private String box;


    @ApiField("branch_shop_name")
    private String branchShopName;


    @ApiField("brand_logo")
    private String brandLogo;


    @ApiField("brand_logo_url")
    private String brandLogoUrl;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("business_certificate")
    private String businessCertificate;


    @ApiField("business_certificate_expires")
    private String businessCertificateExpires;


    @ApiField("business_certificate_url")
    private String businessCertificateUrl;


    @ApiField("business_time")
    private String businessTime;


    @ApiField("category_id")
    private String categoryId;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("claim_time")
    private Date claimTime;


    @ApiField("company_name")
    private String companyName;


    @ApiField("contact_name")
    private String contactName;


    @ApiField("contact_number")
    private String contactNumber;


    @ApiField("create_time")
    private Date createTime;


    @ApiListField("detail_images")

    @ApiField("string")
    private List<String> detailImages;


    @ApiListField("detail_images_name")

    @ApiField("string")
    private List<String> detailImagesName;


    @ApiListField("detail_images_url")

    @ApiField("string")
    private List<String> detailImagesUrl;


    @ApiField("district_code")
    private String districtCode;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("implement_id")
    private String implementId;


    @ApiField("is_complete")
    private String isComplete;


    @ApiField("is_hidden")
    private String isHidden;


    @ApiField("is_operating_online")
    private String isOperatingOnline;


    @ApiField("is_system_import")
    private String isSystemImport;


    @ApiField("latitude")
    private Long latitude;


    @ApiField("leads_id")
    private String leadsId;


    @ApiField("leads_range")
    private String leadsRange;


    @ApiField("licence")
    private String licence;


    @ApiField("licence_code")
    private String licenceCode;


    @ApiField("licence_expires")
    private String licenceExpires;


    @ApiField("licence_name")
    private String licenceName;


    @ApiField("licence_url")
    private String licenceUrl;


    @ApiField("longitude")
    private Long longitude;


    @ApiField("main_image")
    private String mainImage;


    @ApiField("main_image_name")
    private String mainImageName;


    @ApiField("main_image_url")
    private String mainImageUrl;


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


    @ApiField("other_authorization")
    private String otherAuthorization;


    @ApiField("other_authorization_url")
    private String otherAuthorizationUrl;


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


    @ApiField("status")
    private String status;


    @ApiField("store_id")
    private String storeId;


    @ApiField("value_added")
    private String valueAdded;


    @ApiField("wifi")
    private String wifi;


    public String getAddress() {
        /* 379 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 382 */
        this.address = address;

    }


    public String getAuthLetter() {
        /* 386 */
        return this.authLetter;

    }


    public void setAuthLetter(String authLetter) {
        /* 389 */
        this.authLetter = authLetter;

    }


    public String getAuthLetterUrl() {
        /* 393 */
        return this.authLetterUrl;

    }


    public void setAuthLetterUrl(String authLetterUrl) {
        /* 396 */
        this.authLetterUrl = authLetterUrl;

    }


    public String getAvgPrice() {
        /* 400 */
        return this.avgPrice;

    }


    public void setAvgPrice(String avgPrice) {
        /* 403 */
        this.avgPrice = avgPrice;

    }


    public String getBox() {
        /* 407 */
        return this.box;

    }


    public void setBox(String box) {
        /* 410 */
        this.box = box;

    }


    public String getBranchShopName() {
        /* 414 */
        return this.branchShopName;

    }


    public void setBranchShopName(String branchShopName) {
        /* 417 */
        this.branchShopName = branchShopName;

    }


    public String getBrandLogo() {
        /* 421 */
        return this.brandLogo;

    }


    public void setBrandLogo(String brandLogo) {
        /* 424 */
        this.brandLogo = brandLogo;

    }


    public String getBrandLogoUrl() {
        /* 428 */
        return this.brandLogoUrl;

    }


    public void setBrandLogoUrl(String brandLogoUrl) {
        /* 431 */
        this.brandLogoUrl = brandLogoUrl;

    }


    public String getBrandName() {
        /* 435 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 438 */
        this.brandName = brandName;

    }


    public String getBusinessCertificate() {
        /* 442 */
        return this.businessCertificate;

    }


    public void setBusinessCertificate(String businessCertificate) {
        /* 445 */
        this.businessCertificate = businessCertificate;

    }


    public String getBusinessCertificateExpires() {
        /* 449 */
        return this.businessCertificateExpires;

    }


    public void setBusinessCertificateExpires(String businessCertificateExpires) {
        /* 452 */
        this.businessCertificateExpires = businessCertificateExpires;

    }


    public String getBusinessCertificateUrl() {
        /* 456 */
        return this.businessCertificateUrl;

    }


    public void setBusinessCertificateUrl(String businessCertificateUrl) {
        /* 459 */
        this.businessCertificateUrl = businessCertificateUrl;

    }


    public String getBusinessTime() {
        /* 463 */
        return this.businessTime;

    }


    public void setBusinessTime(String businessTime) {
        /* 466 */
        this.businessTime = businessTime;

    }


    public String getCategoryId() {
        /* 470 */
        return this.categoryId;

    }


    public void setCategoryId(String categoryId) {
        /* 473 */
        this.categoryId = categoryId;

    }


    public String getCityCode() {
        /* 477 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /* 480 */
        this.cityCode = cityCode;

    }


    public Date getClaimTime() {
        /* 484 */
        return this.claimTime;

    }


    public void setClaimTime(Date claimTime) {
        /* 487 */
        this.claimTime = claimTime;

    }


    public String getCompanyName() {
        /* 491 */
        return this.companyName;

    }


    public void setCompanyName(String companyName) {
        /* 494 */
        this.companyName = companyName;

    }


    public String getContactName() {
        /* 498 */
        return this.contactName;

    }


    public void setContactName(String contactName) {
        /* 501 */
        this.contactName = contactName;

    }


    public String getContactNumber() {
        /* 505 */
        return this.contactNumber;

    }


    public void setContactNumber(String contactNumber) {
        /* 508 */
        this.contactNumber = contactNumber;

    }


    public Date getCreateTime() {
        /* 512 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /* 515 */
        this.createTime = createTime;

    }


    public List<String> getDetailImages() {
        /* 519 */
        return this.detailImages;

    }


    public void setDetailImages(List<String> detailImages) {
        /* 522 */
        this.detailImages = detailImages;

    }


    public List<String> getDetailImagesName() {
        /* 526 */
        return this.detailImagesName;

    }


    public void setDetailImagesName(List<String> detailImagesName) {
        /* 529 */
        this.detailImagesName = detailImagesName;

    }


    public List<String> getDetailImagesUrl() {
        /* 533 */
        return this.detailImagesUrl;

    }


    public void setDetailImagesUrl(List<String> detailImagesUrl) {
        /* 536 */
        this.detailImagesUrl = detailImagesUrl;

    }


    public String getDistrictCode() {
        /* 540 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 543 */
        this.districtCode = districtCode;

    }


    public String getExtInfo() {
        /* 547 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 550 */
        this.extInfo = extInfo;

    }


    public String getImplementId() {
        /* 554 */
        return this.implementId;

    }


    public void setImplementId(String implementId) {
        /* 557 */
        this.implementId = implementId;

    }


    public String getIsComplete() {
        /* 561 */
        return this.isComplete;

    }


    public void setIsComplete(String isComplete) {
        /* 564 */
        this.isComplete = isComplete;

    }


    public String getIsHidden() {
        /* 568 */
        return this.isHidden;

    }


    public void setIsHidden(String isHidden) {
        /* 571 */
        this.isHidden = isHidden;

    }


    public String getIsOperatingOnline() {
        /* 575 */
        return this.isOperatingOnline;

    }


    public void setIsOperatingOnline(String isOperatingOnline) {
        /* 578 */
        this.isOperatingOnline = isOperatingOnline;

    }


    public String getIsSystemImport() {
        /* 582 */
        return this.isSystemImport;

    }


    public void setIsSystemImport(String isSystemImport) {
        /* 585 */
        this.isSystemImport = isSystemImport;

    }


    public Long getLatitude() {
        /* 589 */
        return this.latitude;

    }


    public void setLatitude(Long latitude) {
        /* 592 */
        this.latitude = latitude;

    }


    public String getLeadsId() {
        /* 596 */
        return this.leadsId;

    }


    public void setLeadsId(String leadsId) {
        /* 599 */
        this.leadsId = leadsId;

    }


    public String getLeadsRange() {
        /* 603 */
        return this.leadsRange;

    }


    public void setLeadsRange(String leadsRange) {
        /* 606 */
        this.leadsRange = leadsRange;

    }


    public String getLicence() {
        /* 610 */
        return this.licence;

    }


    public void setLicence(String licence) {
        /* 613 */
        this.licence = licence;

    }


    public String getLicenceCode() {
        /* 617 */
        return this.licenceCode;

    }


    public void setLicenceCode(String licenceCode) {
        /* 620 */
        this.licenceCode = licenceCode;

    }


    public String getLicenceExpires() {
        /* 624 */
        return this.licenceExpires;

    }


    public void setLicenceExpires(String licenceExpires) {
        /* 627 */
        this.licenceExpires = licenceExpires;

    }


    public String getLicenceName() {
        /* 631 */
        return this.licenceName;

    }


    public void setLicenceName(String licenceName) {
        /* 634 */
        this.licenceName = licenceName;

    }


    public String getLicenceUrl() {
        /* 638 */
        return this.licenceUrl;

    }


    public void setLicenceUrl(String licenceUrl) {
        /* 641 */
        this.licenceUrl = licenceUrl;

    }


    public Long getLongitude() {
        /* 645 */
        return this.longitude;

    }


    public void setLongitude(Long longitude) {
        /* 648 */
        this.longitude = longitude;

    }


    public String getMainImage() {
        /* 652 */
        return this.mainImage;

    }


    public void setMainImage(String mainImage) {
        /* 655 */
        this.mainImage = mainImage;

    }


    public String getMainImageName() {
        /* 659 */
        return this.mainImageName;

    }


    public void setMainImageName(String mainImageName) {
        /* 662 */
        this.mainImageName = mainImageName;

    }


    public String getMainImageUrl() {
        /* 666 */
        return this.mainImageUrl;

    }


    public void setMainImageUrl(String mainImageUrl) {
        /* 669 */
        this.mainImageUrl = mainImageUrl;

    }


    public String getMainShopName() {
        /* 673 */
        return this.mainShopName;

    }


    public void setMainShopName(String mainShopName) {
        /* 676 */
        this.mainShopName = mainShopName;

    }


    public String getMemo() {
        /* 680 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 683 */
        this.memo = memo;

    }


    public String getNoSmoking() {
        /* 687 */
        return this.noSmoking;

    }


    public void setNoSmoking(String noSmoking) {
        /* 690 */
        this.noSmoking = noSmoking;

    }


    public String getOnlineUrl() {
        /* 694 */
        return this.onlineUrl;

    }


    public void setOnlineUrl(String onlineUrl) {
        /* 697 */
        this.onlineUrl = onlineUrl;

    }


    public String getOpId() {
        /* 701 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 704 */
        this.opId = opId;

    }


    public String getOtherAuthorization() {
        /* 708 */
        return this.otherAuthorization;

    }


    public void setOtherAuthorization(String otherAuthorization) {
        /* 711 */
        this.otherAuthorization = otherAuthorization;

    }


    public String getOtherAuthorizationUrl() {
        /* 715 */
        return this.otherAuthorizationUrl;

    }


    public void setOtherAuthorizationUrl(String otherAuthorizationUrl) {
        /* 718 */
        this.otherAuthorizationUrl = otherAuthorizationUrl;

    }


    public String getOtherContactInfo() {
        /* 722 */
        return this.otherContactInfo;

    }


    public void setOtherContactInfo(String otherContactInfo) {
        /* 725 */
        this.otherContactInfo = otherContactInfo;

    }


    public String getParking() {
        /* 729 */
        return this.parking;

    }


    public void setParking(String parking) {
        /* 732 */
        this.parking = parking;

    }


    public String getPayType() {
        /* 736 */
        return this.payType;

    }


    public void setPayType(String payType) {
        /* 739 */
        this.payType = payType;

    }


    public String getProvinceCode() {
        /* 743 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 746 */
        this.provinceCode = provinceCode;

    }


    public String getRequestId() {
        /* 750 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 753 */
        this.requestId = requestId;

    }


    public String getStatus() {
        /* 757 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 760 */
        this.status = status;

    }


    public String getStoreId() {
        /* 764 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 767 */
        this.storeId = storeId;

    }


    public String getValueAdded() {
        /* 771 */
        return this.valueAdded;

    }


    public void setValueAdded(String valueAdded) {
        /* 774 */
        this.valueAdded = valueAdded;

    }


    public String getWifi() {
        /* 778 */
        return this.wifi;

    }


    public void setWifi(String wifi) {
        /* 781 */
        this.wifi = wifi;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.LeadsQueryResponse
 * JD-Core Version:    0.6.0
 */