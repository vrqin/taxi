package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ExproductconfResponse extends AlipayObject {
    private static final long serialVersionUID = 7398436819659169186L;


    @ApiField("charge_inst")
    private String chargeInst;


    @ApiField("chargeinst_name")
    private String chargeinstName;


    @ApiField("chargeoff_inst")
    private String chargeoffInst;


    @ApiField("chargeoffinst_name")
    private String chargeoffinstName;


    @ApiField("city")
    private String city;


    @ApiField("extend")
    private String extend;


    @ApiField("province")
    private String province;


    @ApiField("status")
    private String status;


    public String getChargeInst() {
        /*  65 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /*  68 */
        this.chargeInst = chargeInst;

    }


    public String getChargeinstName() {
        /*  72 */
        return this.chargeinstName;

    }


    public void setChargeinstName(String chargeinstName) {
        /*  75 */
        this.chargeinstName = chargeinstName;

    }


    public String getChargeoffInst() {
        /*  79 */
        return this.chargeoffInst;

    }


    public void setChargeoffInst(String chargeoffInst) {
        /*  82 */
        this.chargeoffInst = chargeoffInst;

    }


    public String getChargeoffinstName() {
        /*  86 */
        return this.chargeoffinstName;

    }


    public void setChargeoffinstName(String chargeoffinstName) {
        /*  89 */
        this.chargeoffinstName = chargeoffinstName;

    }


    public String getCity() {
        /*  93 */
        return this.city;

    }


    public void setCity(String city) {
        /*  96 */
        this.city = city;

    }


    public String getExtend() {
        /* 100 */
        return this.extend;

    }


    public void setExtend(String extend) {
        /* 103 */
        this.extend = extend;

    }


    public String getProvince() {
        /* 107 */
        return this.province;

    }


    public void setProvince(String province) {
        /* 110 */
        this.province = province;

    }


    public String getStatus() {
        /* 114 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 117 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExproductconfResponse
 * JD-Core Version:    0.6.0
 */