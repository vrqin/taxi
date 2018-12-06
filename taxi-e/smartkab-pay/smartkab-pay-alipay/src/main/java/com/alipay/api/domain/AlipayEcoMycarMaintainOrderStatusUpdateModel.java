package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarMaintainOrderStatusUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 6266652134221422538L;

    @ApiField("ext_param")
    private MaintainOrderStatusExtParams extParam;

    @ApiField("industry_code")
    private String industryCode;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("order_status")
    private String orderStatus;

    @ApiField("type")
    private String type;

    public MaintainOrderStatusExtParams getExtParam() {
        /* 47 */
        return this.extParam;
    }

    public void setExtParam(MaintainOrderStatusExtParams extParam) {
        /* 50 */
        this.extParam = extParam;
    }

    public String getIndustryCode() {
        /* 54 */
        return this.industryCode;
    }

    public void setIndustryCode(String industryCode) {
        /* 57 */
        this.industryCode = industryCode;
    }

    public String getOrderNo() {
        /* 61 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 64 */
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        /* 68 */
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        /* 71 */
        this.orderStatus = orderStatus;
    }

    public String getType() {
        /* 75 */
        return this.type;
    }

    public void setType(String type) {
        /* 78 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarMaintainOrderStatusUpdateModel
 * JD-Core Version:    0.6.0
 */