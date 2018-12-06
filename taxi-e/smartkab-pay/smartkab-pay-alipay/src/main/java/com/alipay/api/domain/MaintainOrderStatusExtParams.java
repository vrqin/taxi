package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class MaintainOrderStatusExtParams extends AlipayObject {
    private static final long serialVersionUID = 6653263138524989713L;

    @ApiField("logistics_code")
    private String logisticsCode;

    @ApiField("logistics_company")
    private String logisticsCompany;

    @ApiField("logistics_no")
    private String logisticsNo;

    @ApiField("order_status_txt")
    private String orderStatusTxt;

    @ApiField("receiver_addr")
    private String receiverAddr;

    @ApiField("sender_addr")
    private String senderAddr;

    public String getLogisticsCode() {
        /* 53 */
        return this.logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        /* 56 */
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCompany() {
        /* 60 */
        return this.logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        /* 63 */
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsNo() {
        /* 67 */
        return this.logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        /* 70 */
        this.logisticsNo = logisticsNo;
    }

    public String getOrderStatusTxt() {
        /* 74 */
        return this.orderStatusTxt;
    }

    public void setOrderStatusTxt(String orderStatusTxt) {
        /* 77 */
        this.orderStatusTxt = orderStatusTxt;
    }

    public String getReceiverAddr() {
        /* 81 */
        return this.receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        /* 84 */
        this.receiverAddr = receiverAddr;
    }

    public String getSenderAddr() {
        /* 88 */
        return this.senderAddr;
    }

    public void setSenderAddr(String senderAddr) {
        /* 91 */
        this.senderAddr = senderAddr;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MaintainOrderStatusExtParams
 * JD-Core Version:    0.6.0
 */