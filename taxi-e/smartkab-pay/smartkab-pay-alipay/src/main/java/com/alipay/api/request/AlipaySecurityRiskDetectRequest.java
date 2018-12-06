package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySecurityRiskDetectResponse;

import java.util.Map;


public class AlipaySecurityRiskDetectRequest implements AlipayRequest<AlipaySecurityRiskDetectResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String buyerAccountNo;
    private String buyerBindBankcard;
    private String buyerBindBankcardType;
    private String buyerBindMobile;
    private String buyerGrade;
    private String buyerIdentityNo;
    private String buyerIdentityType;
    private String buyerRealName;
    private String buyerRegDate;
    private String buyerRegEmail;
    private String buyerRegMobile;
    private String buyerSceneBankcard;
    private String buyerSceneBankcardType;
    private String buyerSceneEmail;
    private String buyerSceneMobile;
    private String currency;
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
    private String itemQuantity;
    private String itemUnitPrice;
    private String jsTokenId;
    private String orderAmount;
    private String orderCategory;
    private String orderCredateTime;
    private String orderItemCity;
    private String orderItemName;
    private String orderNo;
    private String partnerId;
    private String receiverAddress;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverEmail;
    private String receiverMobile;
    private String receiverName;
    private String receiverState;
    private String receiverZip;
    private String sceneCode;
    private String sellerAccountNo;
    private String sellerBindBankcard;
    private String sellerBindBankcardType;
    private String sellerBindMobile;
    private String sellerIdentityNo;
    private String sellerIdentityType;
    private String sellerRealName;
    private String sellerRegDate;
    private String sellerRegEmail;
    private String sellerRegMoile;
    private String transportType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 696 */   private boolean needEncrypt = false;


    public String getBuyerAccountNo() {
        /* 304 */
        return this.buyerAccountNo;

    }


    public void setBuyerAccountNo(String buyerAccountNo) {
        /* 301 */
        this.buyerAccountNo = buyerAccountNo;

    }


    public String getBuyerBindBankcard() {
        /* 311 */
        return this.buyerBindBankcard;

    }


    public void setBuyerBindBankcard(String buyerBindBankcard) {
        /* 308 */
        this.buyerBindBankcard = buyerBindBankcard;

    }


    public String getBuyerBindBankcardType() {
        /* 318 */
        return this.buyerBindBankcardType;

    }


    public void setBuyerBindBankcardType(String buyerBindBankcardType) {
        /* 315 */
        this.buyerBindBankcardType = buyerBindBankcardType;

    }


    public String getBuyerBindMobile() {
        /* 325 */
        return this.buyerBindMobile;

    }


    public void setBuyerBindMobile(String buyerBindMobile) {
        /* 322 */
        this.buyerBindMobile = buyerBindMobile;

    }


    public String getBuyerGrade() {
        /* 332 */
        return this.buyerGrade;

    }


    public void setBuyerGrade(String buyerGrade) {
        /* 329 */
        this.buyerGrade = buyerGrade;

    }


    public String getBuyerIdentityNo() {
        /* 339 */
        return this.buyerIdentityNo;

    }


    public void setBuyerIdentityNo(String buyerIdentityNo) {
        /* 336 */
        this.buyerIdentityNo = buyerIdentityNo;

    }


    public String getBuyerIdentityType() {
        /* 346 */
        return this.buyerIdentityType;

    }


    public void setBuyerIdentityType(String buyerIdentityType) {
        /* 343 */
        this.buyerIdentityType = buyerIdentityType;

    }


    public String getBuyerRealName() {
        /* 353 */
        return this.buyerRealName;

    }


    public void setBuyerRealName(String buyerRealName) {
        /* 350 */
        this.buyerRealName = buyerRealName;

    }


    public String getBuyerRegDate() {
        /* 360 */
        return this.buyerRegDate;

    }


    public void setBuyerRegDate(String buyerRegDate) {
        /* 357 */
        this.buyerRegDate = buyerRegDate;

    }


    public String getBuyerRegEmail() {
        /* 367 */
        return this.buyerRegEmail;

    }


    public void setBuyerRegEmail(String buyerRegEmail) {
        /* 364 */
        this.buyerRegEmail = buyerRegEmail;

    }


    public String getBuyerRegMobile() {
        /* 374 */
        return this.buyerRegMobile;

    }


    public void setBuyerRegMobile(String buyerRegMobile) {
        /* 371 */
        this.buyerRegMobile = buyerRegMobile;

    }


    public String getBuyerSceneBankcard() {
        /* 381 */
        return this.buyerSceneBankcard;

    }


    public void setBuyerSceneBankcard(String buyerSceneBankcard) {
        /* 378 */
        this.buyerSceneBankcard = buyerSceneBankcard;

    }


    public String getBuyerSceneBankcardType() {
        /* 388 */
        return this.buyerSceneBankcardType;

    }


    public void setBuyerSceneBankcardType(String buyerSceneBankcardType) {
        /* 385 */
        this.buyerSceneBankcardType = buyerSceneBankcardType;

    }


    public String getBuyerSceneEmail() {
        /* 395 */
        return this.buyerSceneEmail;

    }


    public void setBuyerSceneEmail(String buyerSceneEmail) {
        /* 392 */
        this.buyerSceneEmail = buyerSceneEmail;

    }


    public String getBuyerSceneMobile() {
        /* 402 */
        return this.buyerSceneMobile;

    }


    public void setBuyerSceneMobile(String buyerSceneMobile) {
        /* 399 */
        this.buyerSceneMobile = buyerSceneMobile;

    }


    public String getCurrency() {
        /* 409 */
        return this.currency;

    }


    public void setCurrency(String currency) {
        /* 406 */
        this.currency = currency;

    }


    public String getEnvClientBaseBand() {
        /* 416 */
        return this.envClientBaseBand;

    }


    public void setEnvClientBaseBand(String envClientBaseBand) {
        /* 413 */
        this.envClientBaseBand = envClientBaseBand;

    }


    public String getEnvClientBaseStation() {
        /* 423 */
        return this.envClientBaseStation;

    }


    public void setEnvClientBaseStation(String envClientBaseStation) {
        /* 420 */
        this.envClientBaseStation = envClientBaseStation;

    }


    public String getEnvClientCoordinates() {
        /* 430 */
        return this.envClientCoordinates;

    }


    public void setEnvClientCoordinates(String envClientCoordinates) {
        /* 427 */
        this.envClientCoordinates = envClientCoordinates;

    }


    public String getEnvClientImei() {
        /* 437 */
        return this.envClientImei;

    }


    public void setEnvClientImei(String envClientImei) {
        /* 434 */
        this.envClientImei = envClientImei;

    }


    public String getEnvClientImsi() {
        /* 444 */
        return this.envClientImsi;

    }


    public void setEnvClientImsi(String envClientImsi) {
        /* 441 */
        this.envClientImsi = envClientImsi;

    }


    public String getEnvClientIosUdid() {
        /* 451 */
        return this.envClientIosUdid;

    }


    public void setEnvClientIosUdid(String envClientIosUdid) {
        /* 448 */
        this.envClientIosUdid = envClientIosUdid;

    }


    public String getEnvClientIp() {
        /* 458 */
        return this.envClientIp;

    }


    public void setEnvClientIp(String envClientIp) {
        /* 455 */
        this.envClientIp = envClientIp;

    }


    public String getEnvClientMac() {
        /* 465 */
        return this.envClientMac;

    }


    public void setEnvClientMac(String envClientMac) {
        /* 462 */
        this.envClientMac = envClientMac;

    }


    public String getEnvClientScreen() {
        /* 472 */
        return this.envClientScreen;

    }


    public void setEnvClientScreen(String envClientScreen) {
        /* 469 */
        this.envClientScreen = envClientScreen;

    }


    public String getEnvClientUuid() {
        /* 479 */
        return this.envClientUuid;

    }


    public void setEnvClientUuid(String envClientUuid) {
        /* 476 */
        this.envClientUuid = envClientUuid;

    }


    public String getItemQuantity() {
        /* 486 */
        return this.itemQuantity;

    }


    public void setItemQuantity(String itemQuantity) {
        /* 483 */
        this.itemQuantity = itemQuantity;

    }


    public String getItemUnitPrice() {
        /* 493 */
        return this.itemUnitPrice;

    }


    public void setItemUnitPrice(String itemUnitPrice) {
        /* 490 */
        this.itemUnitPrice = itemUnitPrice;

    }


    public String getJsTokenId() {
        /* 500 */
        return this.jsTokenId;

    }


    public void setJsTokenId(String jsTokenId) {
        /* 497 */
        this.jsTokenId = jsTokenId;

    }


    public String getOrderAmount() {
        /* 507 */
        return this.orderAmount;

    }


    public void setOrderAmount(String orderAmount) {
        /* 504 */
        this.orderAmount = orderAmount;

    }


    public String getOrderCategory() {
        /* 514 */
        return this.orderCategory;

    }


    public void setOrderCategory(String orderCategory) {
        /* 511 */
        this.orderCategory = orderCategory;

    }


    public String getOrderCredateTime() {
        /* 521 */
        return this.orderCredateTime;

    }


    public void setOrderCredateTime(String orderCredateTime) {
        /* 518 */
        this.orderCredateTime = orderCredateTime;

    }


    public String getOrderItemCity() {
        /* 528 */
        return this.orderItemCity;

    }


    public void setOrderItemCity(String orderItemCity) {
        /* 525 */
        this.orderItemCity = orderItemCity;

    }


    public String getOrderItemName() {
        /* 535 */
        return this.orderItemName;

    }


    public void setOrderItemName(String orderItemName) {
        /* 532 */
        this.orderItemName = orderItemName;

    }


    public String getOrderNo() {
        /* 542 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /* 539 */
        this.orderNo = orderNo;

    }


    public String getPartnerId() {
        /* 549 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /* 546 */
        this.partnerId = partnerId;

    }


    public String getReceiverAddress() {
        /* 556 */
        return this.receiverAddress;

    }


    public void setReceiverAddress(String receiverAddress) {
        /* 553 */
        this.receiverAddress = receiverAddress;

    }


    public String getReceiverCity() {
        /* 563 */
        return this.receiverCity;

    }


    public void setReceiverCity(String receiverCity) {
        /* 560 */
        this.receiverCity = receiverCity;

    }


    public String getReceiverDistrict() {
        /* 570 */
        return this.receiverDistrict;

    }


    public void setReceiverDistrict(String receiverDistrict) {
        /* 567 */
        this.receiverDistrict = receiverDistrict;

    }


    public String getReceiverEmail() {
        /* 577 */
        return this.receiverEmail;

    }


    public void setReceiverEmail(String receiverEmail) {
        /* 574 */
        this.receiverEmail = receiverEmail;

    }


    public String getReceiverMobile() {
        /* 584 */
        return this.receiverMobile;

    }


    public void setReceiverMobile(String receiverMobile) {
        /* 581 */
        this.receiverMobile = receiverMobile;

    }


    public String getReceiverName() {
        /* 591 */
        return this.receiverName;

    }


    public void setReceiverName(String receiverName) {
        /* 588 */
        this.receiverName = receiverName;

    }


    public String getReceiverState() {
        /* 598 */
        return this.receiverState;

    }


    public void setReceiverState(String receiverState) {
        /* 595 */
        this.receiverState = receiverState;

    }


    public String getReceiverZip() {
        /* 605 */
        return this.receiverZip;

    }


    public void setReceiverZip(String receiverZip) {
        /* 602 */
        this.receiverZip = receiverZip;

    }


    public String getSceneCode() {
        /* 612 */
        return this.sceneCode;

    }


    public void setSceneCode(String sceneCode) {
        /* 609 */
        this.sceneCode = sceneCode;

    }


    public String getSellerAccountNo() {
        /* 619 */
        return this.sellerAccountNo;

    }


    public void setSellerAccountNo(String sellerAccountNo) {
        /* 616 */
        this.sellerAccountNo = sellerAccountNo;

    }


    public String getSellerBindBankcard() {
        /* 626 */
        return this.sellerBindBankcard;

    }


    public void setSellerBindBankcard(String sellerBindBankcard) {
        /* 623 */
        this.sellerBindBankcard = sellerBindBankcard;

    }


    public String getSellerBindBankcardType() {
        /* 633 */
        return this.sellerBindBankcardType;

    }


    public void setSellerBindBankcardType(String sellerBindBankcardType) {
        /* 630 */
        this.sellerBindBankcardType = sellerBindBankcardType;

    }


    public String getSellerBindMobile() {
        /* 640 */
        return this.sellerBindMobile;

    }


    public void setSellerBindMobile(String sellerBindMobile) {
        /* 637 */
        this.sellerBindMobile = sellerBindMobile;

    }


    public String getSellerIdentityNo() {
        /* 647 */
        return this.sellerIdentityNo;

    }


    public void setSellerIdentityNo(String sellerIdentityNo) {
        /* 644 */
        this.sellerIdentityNo = sellerIdentityNo;

    }


    public String getSellerIdentityType() {
        /* 654 */
        return this.sellerIdentityType;

    }


    public void setSellerIdentityType(String sellerIdentityType) {
        /* 651 */
        this.sellerIdentityType = sellerIdentityType;

    }


    public String getSellerRealName() {
        /* 661 */
        return this.sellerRealName;

    }


    public void setSellerRealName(String sellerRealName) {
        /* 658 */
        this.sellerRealName = sellerRealName;

    }


    public String getSellerRegDate() {
        /* 668 */
        return this.sellerRegDate;

    }


    public void setSellerRegDate(String sellerRegDate) {
        /* 665 */
        this.sellerRegDate = sellerRegDate;

    }


    public String getSellerRegEmail() {
        /* 675 */
        return this.sellerRegEmail;

    }


    public void setSellerRegEmail(String sellerRegEmail) {
        /* 672 */
        this.sellerRegEmail = sellerRegEmail;

    }


    public String getSellerRegMoile() {
        /* 682 */
        return this.sellerRegMoile;

    }


    public void setSellerRegMoile(String sellerRegMoile) {
        /* 679 */
        this.sellerRegMoile = sellerRegMoile;

    }


    public String getTransportType() {
        /* 689 */
        return this.transportType;

    }


    public void setTransportType(String transportType) {
        /* 686 */
        this.transportType = transportType;

    }


    public String getNotifyUrl() {
        /* 699 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 703 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 707 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 711 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 715 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 719 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 727 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 723 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 735 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 731 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 743 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 739 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 747 */
        return "alipay.security.risk.detect";

    }


    public Map<String, String> getTextParams() {
        /* 751 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 752 */
        txtParams.put("buyer_account_no", this.buyerAccountNo);
        /* 753 */
        txtParams.put("buyer_bind_bankcard", this.buyerBindBankcard);
        /* 754 */
        txtParams.put("buyer_bind_bankcard_type", this.buyerBindBankcardType);
        /* 755 */
        txtParams.put("buyer_bind_mobile", this.buyerBindMobile);
        /* 756 */
        txtParams.put("buyer_grade", this.buyerGrade);
        /* 757 */
        txtParams.put("buyer_identity_no", this.buyerIdentityNo);
        /* 758 */
        txtParams.put("buyer_identity_type", this.buyerIdentityType);
        /* 759 */
        txtParams.put("buyer_real_name", this.buyerRealName);
        /* 760 */
        txtParams.put("buyer_reg_date", this.buyerRegDate);
        /* 761 */
        txtParams.put("buyer_reg_email", this.buyerRegEmail);
        /* 762 */
        txtParams.put("buyer_reg_mobile", this.buyerRegMobile);
        /* 763 */
        txtParams.put("buyer_scene_bankcard", this.buyerSceneBankcard);
        /* 764 */
        txtParams.put("buyer_scene_bankcard_type", this.buyerSceneBankcardType);
        /* 765 */
        txtParams.put("buyer_scene_email", this.buyerSceneEmail);
        /* 766 */
        txtParams.put("buyer_scene_mobile", this.buyerSceneMobile);
        /* 767 */
        txtParams.put("currency", this.currency);
        /* 768 */
        txtParams.put("env_client_base_band", this.envClientBaseBand);
        /* 769 */
        txtParams.put("env_client_base_station", this.envClientBaseStation);
        /* 770 */
        txtParams.put("env_client_coordinates", this.envClientCoordinates);
        /* 771 */
        txtParams.put("env_client_imei", this.envClientImei);
        /* 772 */
        txtParams.put("env_client_imsi", this.envClientImsi);
        /* 773 */
        txtParams.put("env_client_ios_udid", this.envClientIosUdid);
        /* 774 */
        txtParams.put("env_client_ip", this.envClientIp);
        /* 775 */
        txtParams.put("env_client_mac", this.envClientMac);
        /* 776 */
        txtParams.put("env_client_screen", this.envClientScreen);
        /* 777 */
        txtParams.put("env_client_uuid", this.envClientUuid);
        /* 778 */
        txtParams.put("item_quantity", this.itemQuantity);
        /* 779 */
        txtParams.put("item_unit_price", this.itemUnitPrice);
        /* 780 */
        txtParams.put("js_token_id", this.jsTokenId);
        /* 781 */
        txtParams.put("order_amount", this.orderAmount);
        /* 782 */
        txtParams.put("order_category", this.orderCategory);
        /* 783 */
        txtParams.put("order_credate_time", this.orderCredateTime);
        /* 784 */
        txtParams.put("order_item_city", this.orderItemCity);
        /* 785 */
        txtParams.put("order_item_name", this.orderItemName);
        /* 786 */
        txtParams.put("order_no", this.orderNo);
        /* 787 */
        txtParams.put("partner_id", this.partnerId);
        /* 788 */
        txtParams.put("receiver_address", this.receiverAddress);
        /* 789 */
        txtParams.put("receiver_city", this.receiverCity);
        /* 790 */
        txtParams.put("receiver_district", this.receiverDistrict);
        /* 791 */
        txtParams.put("receiver_email", this.receiverEmail);
        /* 792 */
        txtParams.put("receiver_mobile", this.receiverMobile);
        /* 793 */
        txtParams.put("receiver_name", this.receiverName);
        /* 794 */
        txtParams.put("receiver_state", this.receiverState);
        /* 795 */
        txtParams.put("receiver_zip", this.receiverZip);
        /* 796 */
        txtParams.put("scene_code", this.sceneCode);
        /* 797 */
        txtParams.put("seller_account_no", this.sellerAccountNo);
        /* 798 */
        txtParams.put("seller_bind_bankcard", this.sellerBindBankcard);
        /* 799 */
        txtParams.put("seller_bind_bankcard_type", this.sellerBindBankcardType);
        /* 800 */
        txtParams.put("seller_bind_mobile", this.sellerBindMobile);
        /* 801 */
        txtParams.put("seller_identity_no", this.sellerIdentityNo);
        /* 802 */
        txtParams.put("seller_identity_type", this.sellerIdentityType);
        /* 803 */
        txtParams.put("seller_real_name", this.sellerRealName);
        /* 804 */
        txtParams.put("seller_reg_date", this.sellerRegDate);
        /* 805 */
        txtParams.put("seller_reg_email", this.sellerRegEmail);
        /* 806 */
        txtParams.put("seller_reg_moile", this.sellerRegMoile);
        /* 807 */
        txtParams.put("transport_type", this.transportType);
        /* 808 */
        if (this.udfParams != null) {
            /* 809 */
            txtParams.putAll(this.udfParams);

        }
        /* 811 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 815 */
        if (this.udfParams == null) {
            /* 816 */
            this.udfParams = new AlipayHashMap();

        }
        /* 818 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySecurityRiskDetectResponse> getResponseClass() {
        /* 822 */
        return AlipaySecurityRiskDetectResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 828 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 834 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySecurityRiskDetectRequest
 * JD-Core Version:    0.6.0
 */