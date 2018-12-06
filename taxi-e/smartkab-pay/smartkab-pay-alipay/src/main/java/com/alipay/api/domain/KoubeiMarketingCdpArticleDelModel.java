package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCdpArticleDelModel extends AlipayObject {
    private static final long serialVersionUID = 4874472964743531514L;

    @ApiField("article_id")
    private String articleId;

    public String getArticleId() {
        /* 23 */
        return this.articleId;
    }

    public void setArticleId(String articleId) {
        /* 26 */
        this.articleId = articleId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpArticleDelModel
 * JD-Core Version:    0.6.0
 */