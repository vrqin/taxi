package com.alipay.api.request;


import com.alipay.api.AlipayUploadRequest;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayZdatafrontDatatransferedFileuploadResponse;

import java.util.HashMap;
import java.util.Map;


public class AlipayZdatafrontDatatransferedFileuploadRequest implements AlipayUploadRequest<AlipayZdatafrontDatatransferedFileuploadResponse> {
    private AlipayHashMap udfParams;
    /*  20 */   private String apiVersion = "1.0";
    private String columns;
    private FileItem file;
    private String fileDescription;
    private String fileDigest;
    private String fileType;
    private String primaryKey;
    private Long records;
    private String typeId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 122 */   private boolean needEncrypt = false;


    public String getColumns() {
        /*  66 */
        return this.columns;

    }


    public void setColumns(String columns) {
        /*  63 */
        this.columns = columns;

    }


    public FileItem getFile() {
        /*  73 */
        return this.file;

    }


    public void setFile(FileItem file) {
        /*  70 */
        this.file = file;

    }


    public String getFileDescription() {
        /*  80 */
        return this.fileDescription;

    }


    public void setFileDescription(String fileDescription) {
        /*  77 */
        this.fileDescription = fileDescription;

    }


    public String getFileDigest() {
        /*  87 */
        return this.fileDigest;

    }


    public void setFileDigest(String fileDigest) {
        /*  84 */
        this.fileDigest = fileDigest;

    }


    public String getFileType() {
        /*  94 */
        return this.fileType;

    }


    public void setFileType(String fileType) {
        /*  91 */
        this.fileType = fileType;

    }


    public String getPrimaryKey() {
        /* 101 */
        return this.primaryKey;

    }


    public void setPrimaryKey(String primaryKey) {
        /*  98 */
        this.primaryKey = primaryKey;

    }


    public Long getRecords() {
        /* 108 */
        return this.records;

    }


    public void setRecords(Long records) {
        /* 105 */
        this.records = records;

    }


    public String getTypeId() {
        /* 115 */
        return this.typeId;

    }


    public void setTypeId(String typeId) {
        /* 112 */
        this.typeId = typeId;

    }


    public String getNotifyUrl() {
        /* 125 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 129 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 133 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 137 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 141 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 144 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 152 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 148 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 160 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 156 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 164 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 168 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 172 */
        return "alipay.zdatafront.datatransfered.fileupload";

    }


    public Map<String, String> getTextParams() {
        /* 176 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 177 */
        txtParams.put("columns", this.columns);
        /* 178 */
        txtParams.put("file_description", this.fileDescription);
        /* 179 */
        txtParams.put("file_digest", this.fileDigest);
        /* 180 */
        txtParams.put("file_type", this.fileType);
        /* 181 */
        txtParams.put("primary_key", this.primaryKey);
        /* 182 */
        txtParams.put("records", this.records);
        /* 183 */
        txtParams.put("type_id", this.typeId);
        /* 184 */
        if (this.udfParams != null) {
            /* 185 */
            txtParams.putAll(this.udfParams);

        }
        /* 187 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 191 */
        if (this.udfParams == null) {
            /* 192 */
            this.udfParams = new AlipayHashMap();

        }
        /* 194 */
        this.udfParams.put(key, value);

    }


    public Map<String, FileItem> getFileParams() {
        /* 198 */
        Map params = new HashMap();
        /* 199 */
        params.put("file", this.file);
        /* 200 */
        return params;

    }


    public Class<AlipayZdatafrontDatatransferedFileuploadResponse> getResponseClass() {
        /* 204 */
        return AlipayZdatafrontDatatransferedFileuploadResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 209 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 215 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayZdatafrontDatatransferedFileuploadRequest
 * JD-Core Version:    0.6.0
 */