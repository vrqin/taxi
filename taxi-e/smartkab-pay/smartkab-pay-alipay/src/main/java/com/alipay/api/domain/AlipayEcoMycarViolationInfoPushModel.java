package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayEcoMycarViolationInfoPushModel extends AlipayObject {
    private static final long serialVersionUID = 3373557961833292618L;


    @ApiField("deal_type")
    private String dealType;


    @ApiField("push_type")
    private String pushType;


    @ApiField("vi_address")
    private String viAddress;


    @ApiField("vi_fine")
    private String viFine;


    @ApiField("vi_handled")
    private String viHandled;


    @ApiField("vi_number")
    private String viNumber;


    @ApiField("vi_point")
    private String viPoint;


    @ApiField("vi_time")
    private Date viTime;


    @ApiField("vi_type")
    private String viType;


    public String getDealType() {
        /*  73 */
        return this.dealType;

    }


    public void setDealType(String dealType) {
        /*  76 */
        this.dealType = dealType;

    }


    public String getPushType() {
        /*  80 */
        return this.pushType;

    }


    public void setPushType(String pushType) {
        /*  83 */
        this.pushType = pushType;

    }


    public String getViAddress() {
        /*  87 */
        return this.viAddress;

    }


    public void setViAddress(String viAddress) {
        /*  90 */
        this.viAddress = viAddress;

    }


    public String getViFine() {
        /*  94 */
        return this.viFine;

    }


    public void setViFine(String viFine) {
        /*  97 */
        this.viFine = viFine;

    }


    public String getViHandled() {
        /* 101 */
        return this.viHandled;

    }


    public void setViHandled(String viHandled) {
        /* 104 */
        this.viHandled = viHandled;

    }


    public String getViNumber() {
        /* 108 */
        return this.viNumber;

    }


    public void setViNumber(String viNumber) {
        /* 111 */
        this.viNumber = viNumber;

    }


    public String getViPoint() {
        /* 115 */
        return this.viPoint;

    }


    public void setViPoint(String viPoint) {
        /* 118 */
        this.viPoint = viPoint;

    }


    public Date getViTime() {
        /* 122 */
        return this.viTime;

    }


    public void setViTime(Date viTime) {
        /* 125 */
        this.viTime = viTime;

    }


    public String getViType() {
        /* 129 */
        return this.viType;

    }


    public void setViType(String viType) {
        /* 132 */
        this.viType = viType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarViolationInfoPushModel
 * JD-Core Version:    0.6.0
 */