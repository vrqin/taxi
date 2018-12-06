package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class MerchantCard extends AlipayObject {
    private static final long serialVersionUID = 5257689928786546279L;


    @ApiField("balance")
    private String balance;


    @ApiField("biz_card_no")
    private String bizCardNo;


    @ApiField("external_card_no")
    private String externalCardNo;


    @ApiField("level")
    private String level;


    @ApiField("open_date")
    private Date openDate;


    @ApiField("point")
    private String point;


    @ApiField("valid_date")
    private String validDate;


    public String getBalance() {
        /*  61 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /*  64 */
        this.balance = balance;

    }


    public String getBizCardNo() {
        /*  68 */
        return this.bizCardNo;

    }


    public void setBizCardNo(String bizCardNo) {
        /*  71 */
        this.bizCardNo = bizCardNo;

    }


    public String getExternalCardNo() {
        /*  75 */
        return this.externalCardNo;

    }


    public void setExternalCardNo(String externalCardNo) {
        /*  78 */
        this.externalCardNo = externalCardNo;

    }


    public String getLevel() {
        /*  82 */
        return this.level;

    }


    public void setLevel(String level) {
        /*  85 */
        this.level = level;

    }


    public Date getOpenDate() {
        /*  89 */
        return this.openDate;

    }


    public void setOpenDate(Date openDate) {
        /*  92 */
        this.openDate = openDate;

    }


    public String getPoint() {
        /*  96 */
        return this.point;

    }


    public void setPoint(String point) {
        /*  99 */
        this.point = point;

    }


    public String getValidDate() {
        /* 103 */
        return this.validDate;

    }


    public void setValidDate(String validDate) {
        /* 106 */
        this.validDate = validDate;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MerchantCard
 * JD-Core Version:    0.6.0
 */