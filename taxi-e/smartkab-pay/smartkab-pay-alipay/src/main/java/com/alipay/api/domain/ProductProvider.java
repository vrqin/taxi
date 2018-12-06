package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ProductProvider extends AlipayObject {
    private static final long serialVersionUID = 3423847339129948689L;


    @ApiField("agency")
    private String agency;


    @ApiField("agency_name")
    private String agencyName;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("id")
    private String id;


    @ApiField("sub_biz_type")
    private String subBizType;


    @ApiField("sub_operator")
    private String subOperator;


    @ApiField("sub_operator_name")
    private String subOperatorName;


    public String getAgency() {
        /*  59 */
        return this.agency;

    }


    public void setAgency(String agency) {
        /*  62 */
        this.agency = agency;

    }


    public String getAgencyName() {
        /*  66 */
        return this.agencyName;

    }


    public void setAgencyName(String agencyName) {
        /*  69 */
        this.agencyName = agencyName;

    }


    public String getBizType() {
        /*  73 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  76 */
        this.bizType = bizType;

    }


    public String getId() {
        /*  80 */
        return this.id;

    }


    public void setId(String id) {
        /*  83 */
        this.id = id;

    }


    public String getSubBizType() {
        /*  87 */
        return this.subBizType;

    }


    public void setSubBizType(String subBizType) {
        /*  90 */
        this.subBizType = subBizType;

    }


    public String getSubOperator() {
        /*  94 */
        return this.subOperator;

    }


    public void setSubOperator(String subOperator) {
        /*  97 */
        this.subOperator = subOperator;

    }


    public String getSubOperatorName() {
        /* 101 */
        return this.subOperatorName;

    }


    public void setSubOperatorName(String subOperatorName) {
        /* 104 */
        this.subOperatorName = subOperatorName;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ProductProvider
 * JD-Core Version:    0.6.0
 */