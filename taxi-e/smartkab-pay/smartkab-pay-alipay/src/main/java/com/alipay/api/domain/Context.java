package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Context extends AlipayObject {
    private static final long serialVersionUID = 3663758158792293896L;

    @ApiField("action_name")
    private String actionName;

    @ApiField("head_color")
    private String headColor;

    @ApiField("keyword1")
    private Keyword keyword1;

    @ApiField("keyword2")
    private Keyword keyword2;

    @ApiField("url")
    private String url;

    public String getActionName() {
        /* 47 */
        return this.actionName;
    }

    public void setActionName(String actionName) {
        /* 50 */
        this.actionName = actionName;
    }

    public String getHeadColor() {
        /* 54 */
        return this.headColor;
    }

    public void setHeadColor(String headColor) {
        /* 57 */
        this.headColor = headColor;
    }

    public Keyword getKeyword1() {
        /* 61 */
        return this.keyword1;
    }

    public void setKeyword1(Keyword keyword1) {
        /* 64 */
        this.keyword1 = keyword1;
    }

    public Keyword getKeyword2() {
        /* 68 */
        return this.keyword2;
    }

    public void setKeyword2(Keyword keyword2) {
        /* 71 */
        this.keyword2 = keyword2;
    }

    public String getUrl() {
        /* 75 */
        return this.url;
    }

    public void setUrl(String url) {
        /* 78 */
        this.url = url;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Context
 * JD-Core Version:    0.6.0
 */