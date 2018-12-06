package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayBossProdSubmerchantModifyModel extends AlipayObject {
    private static final long serialVersionUID = 4331271595657483175L;


    @ApiField("address")
    private String address;


    @ApiField("alias_name")
    private String aliasName;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("contact_name")
    private String contactName;


    @ApiField("district_code")
    private String districtCode;


    @ApiField("external_id")
    private String externalId;


    @ApiField("province_code")
    private String provinceCode;


    @ApiField("service_phone")
    private String servicePhone;


    @ApiField("source")
    private String source;


    @ApiField("sub_merchant_id")
    private String subMerchantId;


    public String getAddress() {
        /*  77 */
        return this.address;

    }


    public void setAddress(String address) {
        /*  80 */
        this.address = address;

    }


    public String getAliasName() {
        /*  84 */
        return this.aliasName;

    }


    public void setAliasName(String aliasName) {
        /*  87 */
        this.aliasName = aliasName;

    }


    public String getCityCode() {
        /*  91 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /*  94 */
        this.cityCode = cityCode;

    }


    public String getContactName() {
        /*  98 */
        return this.contactName;

    }


    public void setContactName(String contactName) {
        /* 101 */
        this.contactName = contactName;

    }


    public String getDistrictCode() {
        /* 105 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 108 */
        this.districtCode = districtCode;

    }


    public String getExternalId() {
        /* 112 */
        return this.externalId;

    }


    public void setExternalId(String externalId) {
        /* 115 */
        this.externalId = externalId;

    }


    public String getProvinceCode() {
        /* 119 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 122 */
        this.provinceCode = provinceCode;

    }


    public String getServicePhone() {
        /* 126 */
        return this.servicePhone;

    }


    public void setServicePhone(String servicePhone) {
        /* 129 */
        this.servicePhone = servicePhone;

    }


    public String getSource() {
        /* 133 */
        return this.source;

    }


    public void setSource(String source) {
        /* 136 */
        this.source = source;

    }


    public String getSubMerchantId() {
        /* 140 */
        return this.subMerchantId;

    }


    public void setSubMerchantId(String subMerchantId) {
        /* 143 */
        this.subMerchantId = subMerchantId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayBossProdSubmerchantModifyModel
 * JD-Core Version:    0.6.0
 */