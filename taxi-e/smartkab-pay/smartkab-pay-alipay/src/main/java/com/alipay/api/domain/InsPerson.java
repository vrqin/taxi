package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class InsPerson extends AlipayObject {
    private static final long serialVersionUID = 5392843377918177741L;


    @ApiField("address")
    private String address;


    @ApiField("alipay_account_no")
    private String alipayAccountNo;


    @ApiField("birthday")
    private Date birthday;


    @ApiField("biz_data")
    private String bizData;


    @ApiField("channel_account_id")
    private String channelAccountId;


    @ApiField("channel_account_type")
    private String channelAccountType;


    @ApiField("email")
    private String email;


    @ApiField("gender")
    private String gender;


    @ApiField("id_card_name")
    private String idCardName;


    @ApiField("id_card_no")
    private String idCardNo;


    @ApiField("id_card_type")
    private String idCardType;


    @ApiField("phone")
    private String phone;


    public String getAddress() {
        /*  92 */
        return this.address;

    }


    public void setAddress(String address) {
        /*  95 */
        this.address = address;

    }


    public String getAlipayAccountNo() {
        /*  99 */
        return this.alipayAccountNo;

    }


    public void setAlipayAccountNo(String alipayAccountNo) {
        /* 102 */
        this.alipayAccountNo = alipayAccountNo;

    }


    public Date getBirthday() {
        /* 106 */
        return this.birthday;

    }


    public void setBirthday(Date birthday) {
        /* 109 */
        this.birthday = birthday;

    }


    public String getBizData() {
        /* 113 */
        return this.bizData;

    }


    public void setBizData(String bizData) {
        /* 116 */
        this.bizData = bizData;

    }


    public String getChannelAccountId() {
        /* 120 */
        return this.channelAccountId;

    }


    public void setChannelAccountId(String channelAccountId) {
        /* 123 */
        this.channelAccountId = channelAccountId;

    }


    public String getChannelAccountType() {
        /* 127 */
        return this.channelAccountType;

    }


    public void setChannelAccountType(String channelAccountType) {
        /* 130 */
        this.channelAccountType = channelAccountType;

    }


    public String getEmail() {
        /* 134 */
        return this.email;

    }


    public void setEmail(String email) {
        /* 137 */
        this.email = email;

    }


    public String getGender() {
        /* 141 */
        return this.gender;

    }


    public void setGender(String gender) {
        /* 144 */
        this.gender = gender;

    }


    public String getIdCardName() {
        /* 148 */
        return this.idCardName;

    }


    public void setIdCardName(String idCardName) {
        /* 151 */
        this.idCardName = idCardName;

    }


    public String getIdCardNo() {
        /* 155 */
        return this.idCardNo;

    }


    public void setIdCardNo(String idCardNo) {
        /* 158 */
        this.idCardNo = idCardNo;

    }


    public String getIdCardType() {
        /* 162 */
        return this.idCardType;

    }


    public void setIdCardType(String idCardType) {
        /* 165 */
        this.idCardType = idCardType;

    }


    public String getPhone() {
        /* 169 */
        return this.phone;

    }


    public void setPhone(String phone) {
        /* 172 */
        this.phone = phone;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.InsPerson
 * JD-Core Version:    0.6.0
 */