package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySecurityInfoAnalysisResponse;

import java.util.Map;


public class AlipaySecurityInfoAnalysisRequest implements AlipayRequest<AlipaySecurityInfoAnalysisResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String envClientBaseBand;
    private String envClientBaseStation;
    private String envClientCoordinates;
    private String envClientImei;
    private String envClientImsi;
    private String envClientIosUdid;
    private String envClientIp;
    private String envClientMac;
    private String envClientScreen;
    private String envClientUuid;
    private String jsTokenId;
    private String partnerId;
    private String sceneCode;
    private String userAccountNo;
    private String userBindBankcard;
    private String userBindBankcardType;
    private String userBindMobile;
    private String userIdentityType;
    private String userRealName;
    private String userRegDate;
    private String userRegEmail;
    private String userRegMobile;
    private String userrIdentityNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 300 */   private boolean needEncrypt = false;


    public String getEnvClientBaseBand() {
        /* 139 */
        return this.envClientBaseBand;

    }


    public void setEnvClientBaseBand(String envClientBaseBand) {
        /* 136 */
        this.envClientBaseBand = envClientBaseBand;

    }


    public String getEnvClientBaseStation() {
        /* 146 */
        return this.envClientBaseStation;

    }


    public void setEnvClientBaseStation(String envClientBaseStation) {
        /* 143 */
        this.envClientBaseStation = envClientBaseStation;

    }


    public String getEnvClientCoordinates() {
        /* 153 */
        return this.envClientCoordinates;

    }


    public void setEnvClientCoordinates(String envClientCoordinates) {
        /* 150 */
        this.envClientCoordinates = envClientCoordinates;

    }


    public String getEnvClientImei() {
        /* 160 */
        return this.envClientImei;

    }


    public void setEnvClientImei(String envClientImei) {
        /* 157 */
        this.envClientImei = envClientImei;

    }


    public String getEnvClientImsi() {
        /* 167 */
        return this.envClientImsi;

    }


    public void setEnvClientImsi(String envClientImsi) {
        /* 164 */
        this.envClientImsi = envClientImsi;

    }


    public String getEnvClientIosUdid() {
        /* 174 */
        return this.envClientIosUdid;

    }


    public void setEnvClientIosUdid(String envClientIosUdid) {
        /* 171 */
        this.envClientIosUdid = envClientIosUdid;

    }


    public String getEnvClientIp() {
        /* 181 */
        return this.envClientIp;

    }


    public void setEnvClientIp(String envClientIp) {
        /* 178 */
        this.envClientIp = envClientIp;

    }


    public String getEnvClientMac() {
        /* 188 */
        return this.envClientMac;

    }


    public void setEnvClientMac(String envClientMac) {
        /* 185 */
        this.envClientMac = envClientMac;

    }


    public String getEnvClientScreen() {
        /* 195 */
        return this.envClientScreen;

    }


    public void setEnvClientScreen(String envClientScreen) {
        /* 192 */
        this.envClientScreen = envClientScreen;

    }


    public String getEnvClientUuid() {
        /* 202 */
        return this.envClientUuid;

    }


    public void setEnvClientUuid(String envClientUuid) {
        /* 199 */
        this.envClientUuid = envClientUuid;

    }


    public String getJsTokenId() {
        /* 209 */
        return this.jsTokenId;

    }


    public void setJsTokenId(String jsTokenId) {
        /* 206 */
        this.jsTokenId = jsTokenId;

    }


    public String getPartnerId() {
        /* 216 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /* 213 */
        this.partnerId = partnerId;

    }


    public String getSceneCode() {
        /* 223 */
        return this.sceneCode;

    }


    public void setSceneCode(String sceneCode) {
        /* 220 */
        this.sceneCode = sceneCode;

    }


    public String getUserAccountNo() {
        /* 230 */
        return this.userAccountNo;

    }


    public void setUserAccountNo(String userAccountNo) {
        /* 227 */
        this.userAccountNo = userAccountNo;

    }


    public String getUserBindBankcard() {
        /* 237 */
        return this.userBindBankcard;

    }


    public void setUserBindBankcard(String userBindBankcard) {
        /* 234 */
        this.userBindBankcard = userBindBankcard;

    }


    public String getUserBindBankcardType() {
        /* 244 */
        return this.userBindBankcardType;

    }


    public void setUserBindBankcardType(String userBindBankcardType) {
        /* 241 */
        this.userBindBankcardType = userBindBankcardType;

    }


    public String getUserBindMobile() {
        /* 251 */
        return this.userBindMobile;

    }


    public void setUserBindMobile(String userBindMobile) {
        /* 248 */
        this.userBindMobile = userBindMobile;

    }


    public String getUserIdentityType() {
        /* 258 */
        return this.userIdentityType;

    }


    public void setUserIdentityType(String userIdentityType) {
        /* 255 */
        this.userIdentityType = userIdentityType;

    }


    public String getUserRealName() {
        /* 265 */
        return this.userRealName;

    }


    public void setUserRealName(String userRealName) {
        /* 262 */
        this.userRealName = userRealName;

    }


    public String getUserRegDate() {
        /* 272 */
        return this.userRegDate;

    }


    public void setUserRegDate(String userRegDate) {
        /* 269 */
        this.userRegDate = userRegDate;

    }


    public String getUserRegEmail() {
        /* 279 */
        return this.userRegEmail;

    }


    public void setUserRegEmail(String userRegEmail) {
        /* 276 */
        this.userRegEmail = userRegEmail;

    }


    public String getUserRegMobile() {
        /* 286 */
        return this.userRegMobile;

    }


    public void setUserRegMobile(String userRegMobile) {
        /* 283 */
        this.userRegMobile = userRegMobile;

    }


    public String getUserrIdentityNo() {
        /* 293 */
        return this.userrIdentityNo;

    }


    public void setUserrIdentityNo(String userrIdentityNo) {
        /* 290 */
        this.userrIdentityNo = userrIdentityNo;

    }


    public String getNotifyUrl() {
        /* 303 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 307 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 311 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 315 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 319 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 323 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 331 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 327 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 339 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 335 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 347 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 343 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 351 */
        return "alipay.security.info.analysis";

    }


    public Map<String, String> getTextParams() {
        /* 355 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 356 */
        txtParams.put("env_client_base_band", this.envClientBaseBand);
        /* 357 */
        txtParams.put("env_client_base_station", this.envClientBaseStation);
        /* 358 */
        txtParams.put("env_client_coordinates", this.envClientCoordinates);
        /* 359 */
        txtParams.put("env_client_imei", this.envClientImei);
        /* 360 */
        txtParams.put("env_client_imsi", this.envClientImsi);
        /* 361 */
        txtParams.put("env_client_ios_udid", this.envClientIosUdid);
        /* 362 */
        txtParams.put("env_client_ip", this.envClientIp);
        /* 363 */
        txtParams.put("env_client_mac", this.envClientMac);
        /* 364 */
        txtParams.put("env_client_screen", this.envClientScreen);
        /* 365 */
        txtParams.put("env_client_uuid", this.envClientUuid);
        /* 366 */
        txtParams.put("js_token_id", this.jsTokenId);
        /* 367 */
        txtParams.put("partner_id", this.partnerId);
        /* 368 */
        txtParams.put("scene_code", this.sceneCode);
        /* 369 */
        txtParams.put("user_account_no", this.userAccountNo);
        /* 370 */
        txtParams.put("user_bind_bankcard", this.userBindBankcard);
        /* 371 */
        txtParams.put("user_bind_bankcard_type", this.userBindBankcardType);
        /* 372 */
        txtParams.put("user_bind_mobile", this.userBindMobile);
        /* 373 */
        txtParams.put("user_identity_type", this.userIdentityType);
        /* 374 */
        txtParams.put("user_real_name", this.userRealName);
        /* 375 */
        txtParams.put("user_reg_date", this.userRegDate);
        /* 376 */
        txtParams.put("user_reg_email", this.userRegEmail);
        /* 377 */
        txtParams.put("user_reg_mobile", this.userRegMobile);
        /* 378 */
        txtParams.put("userr_identity_no", this.userrIdentityNo);
        /* 379 */
        if (this.udfParams != null) {
            /* 380 */
            txtParams.putAll(this.udfParams);

        }
        /* 382 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 386 */
        if (this.udfParams == null) {
            /* 387 */
            this.udfParams = new AlipayHashMap();

        }
        /* 389 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySecurityInfoAnalysisResponse> getResponseClass() {
        /* 393 */
        return AlipaySecurityInfoAnalysisResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 399 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 405 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySecurityInfoAnalysisRequest
 * JD-Core Version:    0.6.0
 */