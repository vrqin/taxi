package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AntMerchantExpandImageUploadResponse;

import java.util.HashMap;
import java.util.Map;


public class AntMerchantExpandImageUploadRequest implements AlipayUploadRequest<AntMerchantExpandImageUploadResponse> {
    private AlipayHashMap udfParams;
    /*  20 */   private String apiVersion = "1.0";
    private FileItem imageContent;
    private String imageType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  50 */   private boolean needEncrypt = false;


    public FileItem getImageContent() {
        /*  36 */
        return this.imageContent;

    }


    public void setImageContent(FileItem imageContent) {
        /*  33 */
        this.imageContent = imageContent;

    }


    public String getImageType() {
        /*  43 */
        return this.imageType;

    }


    public void setImageType(String imageType) {
        /*  40 */
        this.imageType = imageType;

    }


    public String getNotifyUrl() {
        /*  53 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  57 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  61 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  65 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  69 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  72 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  80 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  76 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  88 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  84 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  92 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  96 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 100 */
        return "ant.merchant.expand.image.upload";

    }


    public Map<String, String> getTextParams() {
        /* 104 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 105 */
        txtParams.put("image_type", this.imageType);
        /* 106 */
        if (this.udfParams != null) {
            /* 107 */
            txtParams.putAll(this.udfParams);

        }
        /* 109 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 113 */
        if (this.udfParams == null) {
            /* 114 */
            this.udfParams = new AlipayHashMap();

        }
        /* 116 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 120 */
        Map params = new HashMap();
        /* 121 */
        params.put("image_content", this.imageContent);
        /* 122 */
        return params;

    }


    public Class<AntMerchantExpandImageUploadResponse> getResponseClass() {
        /* 126 */
        return AntMerchantExpandImageUploadResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 131 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 137 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AntMerchantExpandImageUploadRequest
 * JD-Core Version:    0.6.0
 */