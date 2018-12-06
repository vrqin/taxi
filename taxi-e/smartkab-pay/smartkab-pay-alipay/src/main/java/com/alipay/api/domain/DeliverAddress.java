package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class DeliverAddress extends AlipayObject {
    private static final long serialVersionUID = 4117386218251864799L;


    @ApiField("address")
    private String address;


    @ApiField("address_code")
    private String addressCode;


    @ApiField("default_deliver_address")
    private String defaultDeliverAddress;


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


    @ApiField("zip")
    private String zip;


    public String getAddress() {
        /*  77 */
        return this.address;

    }


    public void setAddress(String address) {
        /*  80 */
        this.address = address;

    }


    public String getAddressCode() {
        /*  84 */
        return this.addressCode;

    }


    public void setAddressCode(String addressCode) {
        /*  87 */
        this.addressCode = addressCode;

    }


    public String getDefaultDeliverAddress() {
        /*  91 */
        return this.defaultDeliverAddress;

    }


    public void setDefaultDeliverAddress(String defaultDeliverAddress) {
        /*  94 */
        this.defaultDeliverAddress = defaultDeliverAddress;

    }


    public String getDeliverArea() {
        /*  98 */
        return this.deliverArea;

    }


    public void setDeliverArea(String deliverArea) {
        /* 101 */
        this.deliverArea = deliverArea;

    }


    public String getDeliverCity() {
        /* 105 */
        return this.deliverCity;

    }


    public void setDeliverCity(String deliverCity) {
        /* 108 */
        this.deliverCity = deliverCity;

    }


    public String getDeliverFullname() {
        /* 112 */
        return this.deliverFullname;

    }


    public void setDeliverFullname(String deliverFullname) {
        /* 115 */
        this.deliverFullname = deliverFullname;

    }


    public String getDeliverMobile() {
        /* 119 */
        return this.deliverMobile;

    }


    public void setDeliverMobile(String deliverMobile) {
        /* 122 */
        this.deliverMobile = deliverMobile;

    }


    public String getDeliverPhone() {
        /* 126 */
        return this.deliverPhone;

    }


    public void setDeliverPhone(String deliverPhone) {
        /* 129 */
        this.deliverPhone = deliverPhone;

    }


    public String getDeliverProvince() {
        /* 133 */
        return this.deliverProvince;

    }


    public void setDeliverProvince(String deliverProvince) {
        /* 136 */
        this.deliverProvince = deliverProvince;

    }


    public String getZip() {
        /* 140 */
        return this.zip;

    }


    public void setZip(String zip) {
        /* 143 */
        this.zip = zip;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DeliverAddress
 * JD-Core Version:    0.6.0
 */