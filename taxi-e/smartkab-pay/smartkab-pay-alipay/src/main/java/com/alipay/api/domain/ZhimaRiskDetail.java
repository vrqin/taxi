package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class ZhimaRiskDetail extends AlipayObject {
    private static final long serialVersionUID = 6184448571935355129L;


    @ApiField("data_type")
    private String dataType;


    @ApiField("extendinfo")
    private String extendinfo;


    @ApiField("risk_code")
    private String riskCode;


    @ApiField("risk_type")
    private String riskType;


    @ApiField("settlement")
    private String settlement;


    @ApiField("statement")
    private String statement;


    @ApiField("status")
    private String status;


    @ApiField("type")
    private String type;


    @ApiField("update")
    private Date update;


    public String getDataType() {
        /*  73 */
        return this.dataType;

    }


    public void setDataType(String dataType) {
        /*  76 */
        this.dataType = dataType;

    }


    public String getExtendinfo() {
        /*  80 */
        return this.extendinfo;

    }


    public void setExtendinfo(String extendinfo) {
        /*  83 */
        this.extendinfo = extendinfo;

    }


    public String getRiskCode() {
        /*  87 */
        return this.riskCode;

    }


    public void setRiskCode(String riskCode) {
        /*  90 */
        this.riskCode = riskCode;

    }


    public String getRiskType() {
        /*  94 */
        return this.riskType;

    }


    public void setRiskType(String riskType) {
        /*  97 */
        this.riskType = riskType;

    }


    public String getSettlement() {
        /* 101 */
        return this.settlement;

    }


    public void setSettlement(String settlement) {
        /* 104 */
        this.settlement = settlement;

    }


    public String getStatement() {
        /* 108 */
        return this.statement;

    }


    public void setStatement(String statement) {
        /* 111 */
        this.statement = statement;

    }


    public String getStatus() {
        /* 115 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 118 */
        this.status = status;

    }


    public String getType() {
        /* 122 */
        return this.type;

    }


    public void setType(String type) {
        /* 125 */
        this.type = type;

    }


    public Date getUpdate() {
        /* 129 */
        return this.update;

    }


    public void setUpdate(Date update) {
        /* 132 */
        this.update = update;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ZhimaRiskDetail
 * JD-Core Version:    0.6.0
 */