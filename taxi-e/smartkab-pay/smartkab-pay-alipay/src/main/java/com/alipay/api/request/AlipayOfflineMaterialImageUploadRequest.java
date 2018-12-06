package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOfflineMaterialImageUploadResponse;

import java.util.HashMap;
import java.util.Map;


public class AlipayOfflineMaterialImageUploadRequest implements AlipayUploadRequest<AlipayOfflineMaterialImageUploadResponse> {
    private AlipayHashMap udfParams;
    /*  20 */   private String apiVersion = "1.0";
    private FileItem imageContent;
    private String imageName;
    private String imagePid;
    private String imageType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  74 */   private boolean needEncrypt = false;


    public FileItem getImageContent() {
        /*  46 */
        return this.imageContent;

    }


    public void setImageContent(FileItem imageContent) {
        /*  43 */
        this.imageContent = imageContent;

    }


    public String getImageName() {
        /*  53 */
        return this.imageName;

    }


    public void setImageName(String imageName) {
        /*  50 */
        this.imageName = imageName;

    }


    public String getImagePid() {
        /*  60 */
        return this.imagePid;

    }


    public void setImagePid(String imagePid) {
        /*  57 */
        this.imagePid = imagePid;

    }


    public String getImageType() {
        /*  67 */
        return this.imageType;

    }


    public void setImageType(String imageType) {
        /*  64 */
        this.imageType = imageType;

    }


    public String getNotifyUrl() {
        /*  77 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  81 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  85 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  89 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  93 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  96 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 104 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 100 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 112 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 108 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 116 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 120 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 124 */
        return "alipay.offline.material.image.upload";

    }


    public Map<String, String> getTextParams() {
        /* 128 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 129 */
        txtParams.put("image_name", this.imageName);
        /* 130 */
        txtParams.put("image_pid", this.imagePid);
        /* 131 */
        txtParams.put("image_type", this.imageType);
        /* 132 */
        if (this.udfParams != null) {
            /* 133 */
            txtParams.putAll(this.udfParams);

        }
        /* 135 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 139 */
        if (this.udfParams == null) {
            /* 140 */
            this.udfParams = new AlipayHashMap();

        }
        /* 142 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 146 */
        Map params = new HashMap();
        /* 147 */
        params.put("image_content", this.imageContent);
        /* 148 */
        return params;

    }


    public Class<AlipayOfflineMaterialImageUploadResponse> getResponseClass() {
        /* 152 */
        return AlipayOfflineMaterialImageUploadResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 157 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 163 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOfflineMaterialImageUploadRequest
 * JD-Core Version:    0.6.0
 */