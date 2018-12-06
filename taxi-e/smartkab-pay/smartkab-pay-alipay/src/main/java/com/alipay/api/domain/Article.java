package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Article extends AlipayObject {
    private static final long serialVersionUID = 4768966267726138447L;

    @ApiField("action_name")
    private String actionName;

    @ApiField("desc")
    private String desc;

    @ApiField("image_url")
    private String imageUrl;

    @ApiField("title")
    private String title;

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

    public String getDesc() {
        /* 54 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 57 */
        this.desc = desc;
    }

    public String getImageUrl() {
        /* 61 */
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        /* 64 */
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        /* 68 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 71 */
        this.title = title;
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
 * Qualified Name:     com.alipay.api.domain.Article
 * JD-Core Version:    0.6.0
 */