package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayMobileCodeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2849661959625811496L;


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
    private Date startDate;


    @ApiField("user_id")
    private String userId;


    public String getBizLinkedId() {
        /* 105 */
        return this.bizLinkedId;

    }


    public void setBizLinkedId(String bizLinkedId) {
        /* 102 */
        this.bizLinkedId = bizLinkedId;

    }


    public String getBizType() {
        /* 112 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 109 */
        this.bizType = bizType;

    }


    public String getCodeStatus() {
        /* 119 */
        return this.codeStatus;

    }


    public void setCodeStatus(String codeStatus) {
        /* 116 */
        this.codeStatus = codeStatus;

    }


    public String getContextStr() {
        /* 126 */
        return this.contextStr;

    }


    public void setContextStr(String contextStr) {
        /* 123 */
        this.contextStr = contextStr;

    }


    public String getDynamicImgUrl() {
        /* 133 */
        return this.dynamicImgUrl;

    }


    public void setDynamicImgUrl(String dynamicImgUrl) {
        /* 130 */
        this.dynamicImgUrl = dynamicImgUrl;

    }


    public String getExpireDate() {
        /* 140 */
        return this.expireDate;

    }


    public void setExpireDate(String expireDate) {
        /* 137 */
        this.expireDate = expireDate;

    }


    public String getIsDirect() {
        /* 147 */
        return this.isDirect;

    }


    public void setIsDirect(String isDirect) {
        /* 144 */
        this.isDirect = isDirect;

    }


    public String getMemo() {
        /* 154 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 151 */
        this.memo = memo;

    }


    public String getQrCode() {
        /* 161 */
        return this.qrCode;

    }


    public void setQrCode(String qrCode) {
        /* 158 */
        this.qrCode = qrCode;

    }


    public String getQrToken() {
        /* 168 */
        return this.qrToken;

    }


    public void setQrToken(String qrToken) {
        /* 165 */
        this.qrToken = qrToken;

    }


    public String getSourceId() {
        /* 175 */
        return this.sourceId;

    }


    public void setSourceId(String sourceId) {
        /* 172 */
        this.sourceId = sourceId;

    }


    public Date getStartDate() {
        /* 182 */
        return this.startDate;

    }


    public void setStartDate(Date startDate) {
        /* 179 */
        this.startDate = startDate;

    }


    public String getUserId() {
        /* 189 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 186 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileCodeCreateResponse
 * JD-Core Version:    0.6.0
 */