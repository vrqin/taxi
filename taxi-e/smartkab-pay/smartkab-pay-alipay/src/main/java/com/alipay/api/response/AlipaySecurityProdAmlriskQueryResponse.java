package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantScreenHit;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipaySecurityProdAmlriskQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3435538149337398214L;

    @ApiField("event_id")
    private String eventId;

    @ApiField("has_risk")
    private String hasRisk;

    @ApiField("merchant_id")
    private String merchantId;

    @ApiListField("risks")
    @ApiField("merchant_screen_hit")
    private List<MerchantScreenHit> risks;

    public String getEventId() {
        /* 49 */
        return this.eventId;
    }

    public void setEventId(String eventId) {
        /* 46 */
        this.eventId = eventId;
    }

    public String getHasRisk() {
        /* 56 */
        return this.hasRisk;
    }

    public void setHasRisk(String hasRisk) {
        /* 53 */
        this.hasRisk = hasRisk;
    }

    public String getMerchantId() {
        /* 63 */
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        /* 60 */
        this.merchantId = merchantId;
    }

    public List<MerchantScreenHit> getRisks() {
        /* 70 */
        return this.risks;
    }

    public void setRisks(List<MerchantScreenHit> risks) {
        /* 67 */
        this.risks = risks;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityProdAmlriskQueryResponse
 * JD-Core Version:    0.6.0
 */