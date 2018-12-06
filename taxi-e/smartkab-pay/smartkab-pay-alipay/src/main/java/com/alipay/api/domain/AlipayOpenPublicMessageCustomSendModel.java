package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicMessageCustomSendModel extends AlipayObject {
    private static final long serialVersionUID = 8652736597494251113L;

    @ApiListField("articles")
    @ApiField("article")
    private List<Article> articles;

    @ApiField("msg_type")
    private String msgType;

    @ApiField("text")
    private Text text;

    @ApiField("to_user_id")
    private String toUserId;

    public List<Article> getArticles() {
        /* 45 */
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        /* 48 */
        this.articles = articles;
    }

    public String getMsgType() {
        /* 52 */
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        /* 55 */
        this.msgType = msgType;
    }

    public Text getText() {
        /* 59 */
        return this.text;
    }

    public void setText(Text text) {
        /* 62 */
        this.text = text;
    }

    public String getToUserId() {
        /* 66 */
        return this.toUserId;
    }

    public void setToUserId(String toUserId) {
        /* 69 */
        this.toUserId = toUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicMessageCustomSendModel
 * JD-Core Version:    0.6.0
 */