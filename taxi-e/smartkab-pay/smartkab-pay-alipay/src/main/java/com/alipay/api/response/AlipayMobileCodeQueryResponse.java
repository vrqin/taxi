package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMobileCodeQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7566564733333722437L;


    @ApiField("biz_linked_id")
    private String bizLinkedId;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("code_status")
    private String codeStatus;


    @ApiField("context_str")
    private String contextStr;


    @ApiField("dynamic_img_url")
    private String dynamicImgUrl;


    @ApiField("expire_date")
    private String expireDate;


    @ApiField("is_direct")
    private String isDirect;


    @ApiField("memo")
    private String memo;


    @ApiField("qr_code")
    private String qrCode;


    @ApiField("qr_token")
    private String qrToken;


    @ApiField("source_id")
    private String sourceId;


    @ApiField("start_date")
    private String startDate;


    @ApiField("user_id")
    private String userId;


    public String getBizLinkedId() {
        /* 104 */
        return this.bizLinkedId;

    }


    public void setBizLinkedId(String bizLinkedId) {
        /* 101 */
        this.bizLinkedId = bizLinkedId;

    }


    public String getBizType() {
        /* 111 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 108 */
        this.bizType = bizType;

    }


    public String getCodeStatus() {
        /* 118 */
        return this.codeStatus;

    }


    public void setCodeStatus(String codeStatus) {
        /* 115 */
        this.codeStatus = codeStatus;

    }


    public String getContextStr() {
        /* 125 */
        return this.contextStr;

    }


    public void setContextStr(String contextStr) {
        /* 122 */
        this.contextStr = contextStr;

    }


    public String getDynamicImgUrl() {
        /* 132 */
        return this.dynamicImgUrl;

    }


    public void setDynamicImgUrl(String dynamicImgUrl) {
        /* 129 */
        this.dynamicImgUrl = dynamicImgUrl;

    }


    public String getExpireDate() {
        /* 139 */
        return this.expireDate;

    }


    public void setExpireDate(String expireDate) {
        /* 136 */
        this.expireDate = expireDate;

    }


    public String getIsDirect() {
        /* 146 */
        return this.isDirect;

    }


    public void setIsDirect(String isDirect) {
        /* 143 */
        this.isDirect = isDirect;

    }


    public String getMemo() {
        /* 153 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 150 */
        this.memo = memo;

    }


    public String getQrCode() {
        /* 160 */
        return this.qrCode;

    }


    public void setQrCode(String qrCode) {
        /* 157 */
        this.qrCode = qrCode;

    }


    public String getQrToken() {
        /* 167 */
        return this.qrToken;

    }


    public void setQrToken(String qrToken) {
        /* 164 */
        this.qrToken = qrToken;

    }


    public String getSourceId() {
        /* 174 */
        return this.sourceId;

    }


    public void setSourceId(String sourceId) {
        /* 171 */
        this.sourceId = sourceId;

    }


    public String getStartDate() {
        /* 181 */
        return this.startDate;

    }


    public void setStartDate(String startDate) {
        /* 178 */
        this.startDate = startDate;

    }


    public String getUserId() {
        /* 188 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 185 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileCodeQueryResponse
 * JD-Core Version:    0.6.0
 */