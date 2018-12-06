package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class BeaconDeviceInfo extends AlipayObject {
    private static final long serialVersionUID = 1328451641353474412L;

    @ApiField("actiontype")
    private String actiontype;

    @ApiField("inuse")
    private Boolean inuse;

    @ApiField("remark")
    private String remark;

    @ApiField("sn")
    private String sn;

    @ApiField("template")
    private BeaconTemplate template;

    @ApiField("uuid")
    private String uuid;

    public String getActiontype() {
        /* 53 */
        return this.actiontype;
    }

    public void setActiontype(String actiontype) {
        /* 56 */
        this.actiontype = actiontype;
    }

    public Boolean getInuse() {
        /* 60 */
        return this.inuse;
    }

    public void setInuse(Boolean inuse) {
        /* 63 */
        this.inuse = inuse;
    }

    public String getRemark() {
        /* 67 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 70 */
        this.remark = remark;
    }

    public String getSn() {
        /* 74 */
        return this.sn;
    }

    public void setSn(String sn) {
        /* 77 */
        this.sn = sn;
    }

    public BeaconTemplate getTemplate() {
        /* 81 */
        return this.template;
    }

    public void setTemplate(BeaconTemplate template) {
        /* 84 */
        this.template = template;
    }

    public String getUuid() {
        /* 88 */
        return this.uuid;
    }

    public void setUuid(String uuid) {
        /* 91 */
        this.uuid = uuid;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BeaconDeviceInfo
 * JD-Core Version:    0.6.0
 */