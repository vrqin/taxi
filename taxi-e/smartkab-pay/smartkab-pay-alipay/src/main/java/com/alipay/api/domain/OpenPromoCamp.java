package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenPromoCamp extends AlipayObject {
    private static final long serialVersionUID = 1537877141697653244L;

    @ApiField("camp_alias")
    private String campAlias;

    @ApiField("camp_desc")
    private String campDesc;

    @ApiField("camp_end_time")
    private String campEndTime;

    @ApiField("camp_name")
    private String campName;

    @ApiField("camp_start_time")
    private String campStartTime;

    @ApiField("camp_type")
    private String campType;

    public String getCampAlias() {
        /* 53 */
        return this.campAlias;
    }

    public void setCampAlias(String campAlias) {
        /* 56 */
        this.campAlias = campAlias;
    }

    public String getCampDesc() {
        /* 60 */
        return this.campDesc;
    }

    public void setCampDesc(String campDesc) {
        /* 63 */
        this.campDesc = campDesc;
    }

    public String getCampEndTime() {
        /* 67 */
        return this.campEndTime;
    }

    public void setCampEndTime(String campEndTime) {
        /* 70 */
        this.campEndTime = campEndTime;
    }

    public String getCampName() {
        /* 74 */
        return this.campName;
    }

    public void setCampName(String campName) {
        /* 77 */
        this.campName = campName;
    }

    public String getCampStartTime() {
        /* 81 */
        return this.campStartTime;
    }

    public void setCampStartTime(String campStartTime) {
        /* 84 */
        this.campStartTime = campStartTime;
    }

    public String getCampType() {
        /* 88 */
        return this.campType;
    }

    public void setCampType(String campType) {
        /* 91 */
        this.campType = campType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenPromoCamp
 * JD-Core Version:    0.6.0
 */