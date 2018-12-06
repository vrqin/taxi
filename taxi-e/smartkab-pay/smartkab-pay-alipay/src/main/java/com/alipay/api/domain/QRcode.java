package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class QRcode extends AlipayObject {
    private static final long serialVersionUID = 6865331441167798823L;

    @ApiField("card_id")
    private String cardId;

    @ApiField("qrcode_url")
    private String qrcodeUrl;

    public String getCardId() {
        /* 29 */
        return this.cardId;
    }

    public void setCardId(String cardId) {
        /* 32 */
        this.cardId = cardId;
    }

    public String getQrcodeUrl() {
        /* 36 */
        return this.qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        /* 39 */
        this.qrcodeUrl = qrcodeUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.QRcode
 * JD-Core Version:    0.6.0
 */