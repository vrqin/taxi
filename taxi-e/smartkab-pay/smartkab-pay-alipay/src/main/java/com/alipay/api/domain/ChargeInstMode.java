package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ChargeInstMode extends AlipayObject {
    private static final long serialVersionUID = 6218859297785263879L;

    @ApiField("charge_inst")
    private String chargeInst;

    @ApiField("charge_inst_name")
    private String chargeInstName;

    @ApiField("city")
    private String city;

    @ApiField("province")
    private String province;

    public String getChargeInst() {
        /* 41 */
        return this.chargeInst;
    }

    public void setChargeInst(String chargeInst) {
        /* 44 */
        this.chargeInst = chargeInst;
    }

    public String getChargeInstName() {
        /* 48 */
        return this.chargeInstName;
    }

    public void setChargeInstName(String chargeInstName) {
        /* 51 */
        this.chargeInstName = chargeInstName;
    }

    public String getCity() {
        /* 55 */
        return this.city;
    }

    public void setCity(String city) {
        /* 58 */
        this.city = city;
    }

    public String getProvince() {
        /* 62 */
        return this.province;
    }

    public void setProvince(String province) {
        /* 65 */
        this.province = province;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ChargeInstMode
 * JD-Core Version:    0.6.0
 */