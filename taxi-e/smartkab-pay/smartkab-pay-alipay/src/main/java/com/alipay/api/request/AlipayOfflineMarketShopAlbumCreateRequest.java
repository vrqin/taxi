package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOfflineMarketShopAlbumCreateResponse;

import java.util.Map;


public class AlipayOfflineMarketShopAlbumCreateRequest implements AlipayRequest<AlipayOfflineMarketShopAlbumCreateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  24 */   private boolean needEncrypt = false;


    public String getNotifyUrl() {
        /*  27 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  31 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  35 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  39 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  43 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  47 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  55 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  51 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  63 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  59 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  71 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  67 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  75 */
        return "alipay.offline.market.shop.album.create";

    }


    public Map<String, String> getTextParams() {
        /*  79 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  80 */
        if (this.udfParams != null) {
            /*  81 */
            txtParams.putAll(this.udfParams);

        }
        /*  83 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /*  87 */
        if (this.udfParams == null) {
            /*  88 */
            this.udfParams = new AlipayHashMap();

        }
        /*  90 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayOfflineMarketShopAlbumCreateResponse> getResponseClass() {
        /*  94 */
        return AlipayOfflineMarketShopAlbumCreateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 100 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 106 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOfflineMarketShopAlbumCreateRequest
 * JD-Core Version:    0.6.0
 */