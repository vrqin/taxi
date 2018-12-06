package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipaySecurityRiskAmlriskModel extends AlipayObject {
    private static final long serialVersionUID = 7886434438842295273L;


    @ApiField("business_address")
    private String businessAddress;


    @ApiField("event_id")
    private String eventId;


    @ApiListField("individual_list")

    @ApiField("individual_info")
    private List<IndividualInfo> individualList;


    @ApiField("legal_name")
    private String legalName;


    @ApiField("merchant_id")
    private String merchantId;


    @ApiField("order_id")
    private String orderId;


    @ApiField("registered_address")
    private String registeredAddress;


    @ApiField("registration_number")
    private String registrationNumber;


    public String getBusinessAddress() {
        /*  69 */
        return this.businessAddress;

    }


    public void setBusinessAddress(String businessAddress) {
        /*  72 */
        this.businessAddress = businessAddress;

    }


    public String getEventId() {
        /*  76 */
        return this.eventId;

    }


    public void setEventId(String eventId) {
        /*  79 */
        this.eventId = eventId;

    }


    public List<IndividualInfo> getIndividualList() {
        /*  83 */
        return this.individualList;

    }


    public void setIndividualList(List<IndividualInfo> individualList) {
        /*  86 */
        this.individualList = individualList;

    }


    public String getLegalName() {
        /*  90 */
        return this.legalName;

    }


    public void setLegalName(String legalName) {
        /*  93 */
        this.legalName = legalName;

    }


    public String getMerchantId() {
        /*  97 */
        return this.merchantId;

    }


    public void setMerchantId(String merchantId) {
        /* 100 */
        this.merchantId = merchantId;

    }


    public String getOrderId() {
        /* 104 */
        return this.orderId;

    }


    public void setOrderId(String orderId) {
        /* 107 */
        this.orderId = orderId;

    }


    public String getRegisteredAddress() {
        /* 111 */
        return this.registeredAddress;

    }


    public void setRegisteredAddress(String registeredAddress) {
        /* 114 */
        this.registeredAddress = registeredAddress;

    }


    public String getRegistrationNumber() {
        /* 118 */
        return this.registrationNumber;

    }


    public void setRegistrationNumber(String registrationNumber) {
        /* 121 */
        this.registrationNumber = registrationNumber;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityRiskAmlriskModel
 * JD-Core Version:    0.6.0
 */