package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOfflineMarketingVoucherCodeUploadResponse;

import java.util.HashMap;
import java.util.Map;


public class AlipayOfflineMarketingVoucherCodeUploadRequest implements AlipayUploadRequest<AlipayOfflineMarketingVoucherCodeUploadResponse> {
    private AlipayHashMap udfParams;
    /*  20 */   private String apiVersion = "1.0";
    private String extendParams;
    private String fileCharset;
    private FileItem fileContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  62 */   private boolean needEncrypt = false;


    public String getExtendParams() {
        /*  41 */
        return this.extendParams;

    }


    public void setExtendParams(String extendParams) {
        /*  38 */
        this.extendParams = extendParams;

    }


    public String getFileCharset() {
        /*  48 */
        return this.fileCharset;

    }


    public void setFileCharset(String fileCharset) {
        /*  45 */
        this.fileCharset = fileCharset;

    }


    public FileItem getFileContent() {
        /*  55 */
        return this.fileContent;

    }


    public void setFileContent(FileItem fileContent) {
        /*  52 */
        this.fileContent = fileContent;

    }


    public String getNotifyUrl() {
        /*  65 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  69 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  73 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  77 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  81 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  84 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  92 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  88 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 100 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  96 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 104 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 108 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 112 */
        return "alipay.offline.marketing.voucher.code.upload";

    }


    public Map<String, String> getTextParams() {
        /* 116 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 117 */
        txtParams.put("extend_params", this.extendParams);
        /* 118 */
        txtParams.put("file_charset", this.fileCharset);
        /* 119 */
        if (this.udfParams != null) {
            /* 120 */
            txtParams.putAll(this.udfParams);

        }
        /* 122 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 126 */
        if (this.udfParams == null) {
            /* 127 */
            this.udfParams = new AlipayHashMap();

        }
        /* 129 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 133 */
        Map params = new HashMap();
        /* 134 */
        params.put("file_content", this.fileContent);
        /* 135 */
        return params;

    }


    public Class<AlipayOfflineMarketingVoucherCodeUploadResponse> getResponseClass() {
        /* 139 */
        return AlipayOfflineMarketingVoucherCodeUploadResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 144 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 150 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOfflineMarketingVoucherCodeUploadRequest
 * JD-Core Version:    0.6.0
 */