package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOpenPublicLifeAccountCreateResponse;

import java.util.HashMap;
import java.util.Map;


public class AlipayOpenPublicLifeAccountCreateRequest implements AlipayUploadRequest<AlipayOpenPublicLifeAccountCreateResponse> {
    private AlipayHashMap udfParams;
    /*  20 */   private String apiVersion = "1.0";
    private FileItem background;
    private String catagoryId;
    private String contactEmail;
    private String contactTel;
    private String content;
    private String customerTel;
    private String lifeName;
    private FileItem logo;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 135 */   private boolean needEncrypt = false;


    public FileItem getBackground() {
        /*  72 */
        return this.background;

    }


    public void setBackground(FileItem background) {
        /*  69 */
        this.background = background;

    }


    public String getCatagoryId() {
        /*  79 */
        return this.catagoryId;

    }


    public void setCatagoryId(String catagoryId) {
        /*  76 */
        this.catagoryId = catagoryId;

    }


    public String getContactEmail() {
        /*  86 */
        return this.contactEmail;

    }


    public void setContactEmail(String contactEmail) {
        /*  83 */
        this.contactEmail = contactEmail;

    }


    public String getContactTel() {
        /*  93 */
        return this.contactTel;

    }


    public void setContactTel(String contactTel) {
        /*  90 */
        this.contactTel = contactTel;

    }


    public String getContent() {
        /* 100 */
        return this.content;

    }


    public void setContent(String content) {
        /*  97 */
        this.content = content;

    }


    public String getCustomerTel() {
        /* 107 */
        return this.customerTel;

    }


    public void setCustomerTel(String customerTel) {
        /* 104 */
        this.customerTel = customerTel;

    }


    public String getLifeName() {
        /* 114 */
        return this.lifeName;

    }


    public void setLifeName(String lifeName) {
        /* 111 */
        this.lifeName = lifeName;

    }


    public FileItem getLogo() {
        /* 121 */
        return this.logo;

    }


    public void setLogo(FileItem logo) {
        /* 118 */
        this.logo = logo;

    }


    public String getUserId() {
        /* 128 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 125 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /* 138 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 142 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 146 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 150 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 154 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 157 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 165 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 161 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 173 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 169 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 177 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 181 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 185 */
        return "alipay.open.public.life.account.create";

    }


    public Map<String, String> getTextParams() {
        /* 189 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 190 */
        txtParams.put("catagory_id", this.catagoryId);
        /* 191 */
        txtParams.put("contact_email", this.contactEmail);
        /* 192 */
        txtParams.put("contact_tel", this.contactTel);
        /* 193 */
        txtParams.put("content", this.content);
        /* 194 */
        txtParams.put("customer_tel", this.customerTel);
        /* 195 */
        txtParams.put("life_name", this.lifeName);
        /* 196 */
        txtParams.put("user_id", this.userId);
        /* 197 */
        if (this.udfParams != null) {
            /* 198 */
            txtParams.putAll(this.udfParams);

        }
        /* 200 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 204 */
        if (this.udfParams == null) {
            /* 205 */
            this.udfParams = new AlipayHashMap();

        }
        /* 207 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 211 */
        Map params = new HashMap();
        /* 212 */
        params.put("background", this.background);
        /* 213 */
        params.put("logo", this.logo);
        /* 214 */
        return params;

    }


    public Class<AlipayOpenPublicLifeAccountCreateResponse> getResponseClass() {
        /* 218 */
        return AlipayOpenPublicLifeAccountCreateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 223 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 229 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOpenPublicLifeAccountCreateRequest
 * JD-Core Version:    0.6.0
 */