package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.DeliverAddress;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayUserUserinfoShareResponse extends AlipayResponse {
    private static final long serialVersionUID = 7321695129254752215L;


    @ApiField("address")
    private String address;


    @ApiField("address_code")
    private String addressCode;


    @ApiField("alipay_user_id")
    private String alipayUserId;


    @ApiField("area")
    private String area;


    @ApiField("avatar")
    private String avatar;


    @ApiField("balance_freeze_type")
    private String balanceFreezeType;


    @ApiField("birthday")
    private String birthday;


    @ApiField("cert_no")
    private String certNo;


    @ApiField("cert_type_value")
    private String certTypeValue;


    @ApiField("city")
    private String city;


    @ApiField("default_deliver_address")
    private String defaultDeliverAddress;


    @ApiListField("deliver_address_list")

    @ApiField("deliver_address")
    private List<DeliverAddress> deliverAddressList;


    @ApiField("deliver_area")
    private String deliverArea;


    @ApiField("deliver_city")
    private String deliverCity;


    @ApiField("deliver_fullname")
    private String deliverFullname;


    @ApiField("deliver_mobile")
    private String deliverMobile;


    @ApiField("deliver_phone")
    private String deliverPhone;


    @ApiField("deliver_province")
    private String deliverProvince;


    @ApiField("email")
    private String email;


    @ApiField("family_name")
    private String familyName;


    @ApiField("firm_name")
    private String firmName;


    @ApiField("gender")
    private String gender;


    @ApiField("is_balance_frozen")
    private String isBalanceFrozen;


    @ApiField("is_bank_auth")
    private String isBankAuth;


    @ApiField("is_certified")
    private String isCertified;


    @ApiField("is_certify_grade_a")
    private String isCertifyGradeA;


    @ApiField("is_id_auth")
    private String isIdAuth;


    @ApiField("is_licence_auth")
    private String isLicenceAuth;


    @ApiField("is_mobile_auth")
    private String isMobileAuth;


    @ApiField("is_student_certified")
    private String isStudentCertified;


    @ApiField("mobile")
    private String mobile;


    @ApiField("nick_name")
    private String nickName;


    @ApiField("phone")
    private String phone;


    @ApiField("province")
    private String province;


    @ApiField("real_name")
    private String realName;


    @ApiField("reduced_birthday")
    private String reducedBirthday;


    @ApiField("user_id")
    private String userId;


    @ApiField("user_status")
    private String userStatus;


    @ApiField("user_type_value")
    private String userTypeValue;


    @ApiField("zip")
    private String zip;


    public String getAddress() {
        /* 288 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 285 */
        this.address = address;

    }


    public String getAddressCode() {
        /* 295 */
        return this.addressCode;

    }


    public void setAddressCode(String addressCode) {
        /* 292 */
        this.addressCode = addressCode;

    }


    public String getAlipayUserId() {
        /* 302 */
        return this.alipayUserId;

    }


    public void setAlipayUserId(String alipayUserId) {
        /* 299 */
        this.alipayUserId = alipayUserId;

    }


    public String getArea() {
        /* 309 */
        return this.area;

    }


    public void setArea(String area) {
        /* 306 */
        this.area = area;

    }


    public String getAvatar() {
        /* 316 */
        return this.avatar;

    }


    public void setAvatar(String avatar) {
        /* 313 */
        this.avatar = avatar;

    }


    public String getBalanceFreezeType() {
        /* 323 */
        return this.balanceFreezeType;

    }


    public void setBalanceFreezeType(String balanceFreezeType) {
        /* 320 */
        this.balanceFreezeType = balanceFreezeType;

    }


    public String getBirthday() {
        /* 330 */
        return this.birthday;

    }


    public void setBirthday(String birthday) {
        /* 327 */
        this.birthday = birthday;

    }


    public String getCertNo() {
        /* 337 */
        return this.certNo;

    }


    public void setCertNo(String certNo) {
        /* 334 */
        this.certNo = certNo;

    }


    public String getCertTypeValue() {
        /* 344 */
        return this.certTypeValue;

    }


    public void setCertTypeValue(String certTypeValue) {
        /* 341 */
        this.certTypeValue = certTypeValue;

    }


    public String getCity() {
        /* 351 */
        return this.city;

    }


    public void setCity(String city) {
        /* 348 */
        this.city = city;

    }


    public String getDefaultDeliverAddress() {
        /* 358 */
        return this.defaultDeliverAddress;

    }


    public void setDefaultDeliverAddress(String defaultDeliverAddress) {
        /* 355 */
        this.defaultDeliverAddress = defaultDeliverAddress;

    }


    public List<DeliverAddress> getDeliverAddressList() {
        /* 365 */
        return this.deliverAddressList;

    }


    public void setDeliverAddressList(List<DeliverAddress> deliverAddressList) {
        /* 362 */
        this.deliverAddressList = deliverAddressList;

    }


    public String getDeliverArea() {
        /* 372 */
        return this.deliverArea;

    }


    public void setDeliverArea(String deliverArea) {
        /* 369 */
        this.deliverArea = deliverArea;

    }


    public String getDeliverCity() {
        /* 379 */
        return this.deliverCity;

    }


    public void setDeliverCity(String deliverCity) {
        /* 376 */
        this.deliverCity = deliverCity;

    }


    public String getDeliverFullname() {
        /* 386 */
        return this.deliverFullname;

    }


    public void setDeliverFullname(String deliverFullname) {
        /* 383 */
        this.deliverFullname = deliverFullname;

    }


    public String getDeliverMobile() {
        /* 393 */
        return this.deliverMobile;

    }


    public void setDeliverMobile(String deliverMobile) {
        /* 390 */
        this.deliverMobile = deliverMobile;

    }


    public String getDeliverPhone() {
        /* 400 */
        return this.deliverPhone;

    }


    public void setDeliverPhone(String deliverPhone) {
        /* 397 */
        this.deliverPhone = deliverPhone;

    }


    public String getDeliverProvince() {
        /* 407 */
        return this.deliverProvince;

    }


    public void setDeliverProvince(String deliverProvince) {
        /* 404 */
        this.deliverProvince = deliverProvince;

    }


    public String getEmail() {
        /* 414 */
        return this.email;

    }


    public void setEmail(String email) {
        /* 411 */
        this.email = email;

    }


    public String getFamilyName() {
        /* 421 */
        return this.familyName;

    }


    public void setFamilyName(String familyName) {
        /* 418 */
        this.familyName = familyName;

    }


    public String getFirmName() {
        /* 428 */
        return this.firmName;

    }


    public void setFirmName(String firmName) {
        /* 425 */
        this.firmName = firmName;

    }


    public String getGender() {
        /* 435 */
        return this.gender;

    }


    public void setGender(String gender) {
        /* 432 */
        this.gender = gender;

    }


    public String getIsBalanceFrozen() {
        /* 442 */
        return this.isBalanceFrozen;

    }


    public void setIsBalanceFrozen(String isBalanceFrozen) {
        /* 439 */
        this.isBalanceFrozen = isBalanceFrozen;

    }


    public String getIsBankAuth() {
        /* 449 */
        return this.isBankAuth;

    }


    public void setIsBankAuth(String isBankAuth) {
        /* 446 */
        this.isBankAuth = isBankAuth;

    }


    public String getIsCertified() {
        /* 456 */
        return this.isCertified;

    }


    public void setIsCertified(String isCertified) {
        /* 453 */
        this.isCertified = isCertified;

    }


    public String getIsCertifyGradeA() {
        /* 463 */
        return this.isCertifyGradeA;

    }


    public void setIsCertifyGradeA(String isCertifyGradeA) {
        /* 460 */
        this.isCertifyGradeA = isCertifyGradeA;

    }


    public String getIsIdAuth() {
        /* 470 */
        return this.isIdAuth;

    }


    public void setIsIdAuth(String isIdAuth) {
        /* 467 */
        this.isIdAuth = isIdAuth;

    }


    public String getIsLicenceAuth() {
        /* 477 */
        return this.isLicenceAuth;

    }


    public void setIsLicenceAuth(String isLicenceAuth) {
        /* 474 */
        this.isLicenceAuth = isLicenceAuth;

    }


    public String getIsMobileAuth() {
        /* 484 */
        return this.isMobileAuth;

    }


    public void setIsMobileAuth(String isMobileAuth) {
        /* 481 */
        this.isMobileAuth = isMobileAuth;

    }


    public String getIsStudentCertified() {
        /* 491 */
        return this.isStudentCertified;

    }


    public void setIsStudentCertified(String isStudentCertified) {
        /* 488 */
        this.isStudentCertified = isStudentCertified;

    }


    public String getMobile() {
        /* 498 */
        return this.mobile;

    }


    public void setMobile(String mobile) {
        /* 495 */
        this.mobile = mobile;

    }


    public String getNickName() {
        /* 505 */
        return this.nickName;

    }


    public void setNickName(String nickName) {
        /* 502 */
        this.nickName = nickName;

    }


    public String getPhone() {
        /* 512 */
        return this.phone;

    }


    public void setPhone(String phone) {
        /* 509 */
        this.phone = phone;

    }


    public String getProvince() {
        /* 519 */
        return this.province;

    }


    public void setProvince(String province) {
        /* 516 */
        this.province = province;

    }


    public String getRealName() {
        /* 526 */
        return this.realName;

    }


    public void setRealName(String realName) {
        /* 523 */
        this.realName = realName;

    }


    public String getReducedBirthday() {
        /* 533 */
        return this.reducedBirthday;

    }


    public void setReducedBirthday(String reducedBirthday) {
        /* 530 */
        this.reducedBirthday = reducedBirthday;

    }


    public String getUserId() {
        /* 540 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 537 */
        this.userId = userId;

    }


    public String getUserStatus() {
        /* 547 */
        return this.userStatus;

    }


    public void setUserStatus(String userStatus) {
        /* 544 */
        this.userStatus = userStatus;

    }


    public String getUserTypeValue() {
        /* 554 */
        return this.userTypeValue;

    }


    public void setUserTypeValue(String userTypeValue) {
        /* 551 */
        this.userTypeValue = userTypeValue;

    }


    public String getZip() {
        /* 561 */
        return this.zip;

    }


    public void setZip(String zip) {
        /* 558 */
        this.zip = zip;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserUserinfoShareResponse
 * JD-Core Version:    0.6.0
 */