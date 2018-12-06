package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceMedicalCardqueryModel extends AlipayObject {
    private static final long serialVersionUID = 2782731547736638484L;

    @ApiField("buyer_id")
    private String buyerId;

    @ApiField("card_org_no")
    private String cardOrgNo;

    @ApiField("extend_params")
    private String extendParams;

    @ApiField("return_url")
    private String returnUrl;

    public String getBuyerId() {
        /* 42 */
        return this.buyerId;
    }

    public void setBuyerId(String buyerId) {
        /* 45 */
        this.buyerId = buyerId;
    }

    public String getCardOrgNo() {
        /* 49 */
        return this.cardOrgNo;
    }

    public void setCardOrgNo(String cardOrgNo) {
        /* 52 */
        this.cardOrgNo = cardOrgNo;
    }

    public String getExtendParams() {
        /* 56 */
        return this.extendParams;
    }

    public void setExtendParams(String extendParams) {
        /* 59 */
        this.extendParams = extendParams;
    }

    public String getReturnUrl() {
        /* 63 */
        return this.returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        /* 66 */
        this.returnUrl = returnUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceMedicalCardqueryModel
 * JD-Core Version:    0.6.0
 */