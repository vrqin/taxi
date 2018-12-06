package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class StaffDTO extends AlipayObject {
    private static final long serialVersionUID = 4164364776621948247L;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("bizunit_id")
    private String bizunitId;


    @ApiField("email")
    private String email;


    @ApiField("merchant_id")
    private String merchantId;


    @ApiField("merchant_id_type")
    private String merchantIdType;


    @ApiField("remark")
    private String remark;


    @ApiField("staff_biz_code")
    private String staffBizCode;


    @ApiField("staff_id")
    private String staffId;


    @ApiField("staff_mobile")
    private String staffMobile;


    @ApiField("staff_name")
    private String staffName;


    @ApiField("staff_type")
    private String staffType;


    public String getBizType() {
        /*  83 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  86 */
        this.bizType = bizType;

    }


    public String getBizunitId() {
        /*  90 */
        return this.bizunitId;

    }


    public void setBizunitId(String bizunitId) {
        /*  93 */
        this.bizunitId = bizunitId;

    }


    public String getEmail() {
        /*  97 */
        return this.email;

    }


    public void setEmail(String email) {
        /* 100 */
        this.email = email;

    }


    public String getMerchantId() {
        /* 104 */
        return this.merchantId;

    }


    public void setMerchantId(String merchantId) {
        /* 107 */
        this.merchantId = merchantId;

    }


    public String getMerchantIdType() {
        /* 111 */
        return this.merchantIdType;

    }


    public void setMerchantIdType(String merchantIdType) {
        /* 114 */
        this.merchantIdType = merchantIdType;

    }


    public String getRemark() {
        /* 118 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 121 */
        this.remark = remark;

    }


    public String getStaffBizCode() {
        /* 125 */
        return this.staffBizCode;

    }


    public void setStaffBizCode(String staffBizCode) {
        /* 128 */
        this.staffBizCode = staffBizCode;

    }


    public String getStaffId() {
        /* 132 */
        return this.staffId;

    }


    public void setStaffId(String staffId) {
        /* 135 */
        this.staffId = staffId;

    }


    public String getStaffMobile() {
        /* 139 */
        return this.staffMobile;

    }


    public void setStaffMobile(String staffMobile) {
        /* 142 */
        this.staffMobile = staffMobile;

    }


    public String getStaffName() {
        /* 146 */
        return this.staffName;

    }


    public void setStaffName(String staffName) {
        /* 149 */
        this.staffName = staffName;

    }


    public String getStaffType() {
        /* 153 */
        return this.staffType;

    }


    public void setStaffType(String staffType) {
        /* 156 */
        this.staffType = staffType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.StaffDTO
 * JD-Core Version:    0.6.0
 */