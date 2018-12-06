package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayZdatafrontCommonQueryResponse;

import java.util.Map;


public class AlipayZdatafrontCommonQueryRequest implements AlipayRequest<AlipayZdatafrontCommonQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private Long cacheInterval;
    private String queryConditions;
    private String serviceName;
    private String visitBiz;
    private String visitBizLine;
    private String visitDomain;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  98 */   private boolean needEncrypt = false;


    public Long getCacheInterval() {
        /*  56 */
        return this.cacheInterval;

    }


    public void setCacheInterval(Long cacheInterval) {
        /*  53 */
        this.cacheInterval = cacheInterval;

    }


    public String getQueryConditions() {
        /*  63 */
        return this.queryConditions;

    }


    public void setQueryConditions(String queryConditions) {
        /*  60 */
        this.queryConditions = queryConditions;

    }


    public String getServiceName() {
        /*  70 */
        return this.serviceName;

    }


    public void setServiceName(String serviceName) {
        /*  67 */
        this.serviceName = serviceName;

    }


    public String getVisitBiz() {
        /*  77 */
        return this.visitBiz;

    }


    public void setVisitBiz(String visitBiz) {
        /*  74 */
        this.visitBiz = visitBiz;

    }


    public String getVisitBizLine() {
        /*  84 */
        return this.visitBizLine;

    }


    public void setVisitBizLine(String visitBizLine) {
        /*  81 */
        this.visitBizLine = visitBizLine;

    }


    public String getVisitDomain() {
        /*  91 */
        return this.visitDomain;

    }


    public void setVisitDomain(String visitDomain) {
        /*  88 */
        this.visitDomain = visitDomain;

    }


    public String getNotifyUrl() {
        /* 101 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 105 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 109 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 113 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 117 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 121 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 129 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 125 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 137 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 133 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 145 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 141 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 149 */
        return "alipay.zdatafront.common.query";

    }


    public Map<String, String> getTextParams() {
        /* 153 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 154 */
        txtParams.put("cache_interval", this.cacheInterval);
        /* 155 */
        txtParams.put("query_conditions", this.queryConditions);
        /* 156 */
        txtParams.put("service_name", this.serviceName);
        /* 157 */
        txtParams.put("visit_biz", this.visitBiz);
        /* 158 */
        txtParams.put("visit_biz_line", this.visitBizLine);
        /* 159 */
        txtParams.put("visit_domain", this.visitDomain);
        /* 160 */
        if (this.udfParams != null) {
            /* 161 */
            txtParams.putAll(this.udfParams);

        }
        /* 163 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 167 */
        if (this.udfParams == null) {
            /* 168 */
            this.udfParams = new AlipayHashMap();

        }
        /* 170 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayZdatafrontCommonQueryResponse> getResponseClass() {
        /* 174 */
        return AlipayZdatafrontCommonQueryResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 180 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 186 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayZdatafrontCommonQueryRequest
 * JD-Core Version:    0.6.0
 */