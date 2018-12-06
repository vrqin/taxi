package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class Material extends AlipayObject {
    private static final long serialVersionUID = 5593179859659826283L;

    @ApiListField("articles")
    @ApiField("article")
    private List<Article> articles;

    @ApiField("msg_type")
    private String msgType;

    @ApiField("text")
    private Text text;

    public List<Article> getArticles() {
        /* 39 */
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        /* 42 */
        this.articles = articles;
    }

    public String getMsgType() {
        /* 46 */
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        /* 49 */
        this.msgType = msgType;
    }

    public Text getText() {
        /* 53 */
        return this.text;
    }

    public void setText(Text text) {
        /* 56 */
        this.text = text;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Material
 * JD-Core Version:    0.6.0
 */