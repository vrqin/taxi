package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class NewsfeedMediaLinkInfo extends AlipayObject {
    private static final long serialVersionUID = 7571885794366328843L;


    @ApiField("content_id")
    private String contentId;


    @ApiField("content_source")
    private String contentSource;


    @ApiField("content_type")
    private String contentType;


    @ApiField("desc")
    private String desc;


    @ApiField("thumb")
    private String thumb;


    @ApiField("title")
    private String title;


    @ApiField("url")
    private String url;


    public String getContentId() {
        /*  59 */
        return this.contentId;

    }


    public void setContentId(String contentId) {
        /*  62 */
        this.contentId = contentId;

    }


    public String getContentSource() {
        /*  66 */
        return this.contentSource;

    }


    public void setContentSource(String contentSource) {
        /*  69 */
        this.contentSource = contentSource;

    }


    public String getContentType() {
        /*  73 */
        return this.contentType;

    }


    public void setContentType(String contentType) {
        /*  76 */
        this.contentType = contentType;

    }


    public String getDesc() {
        /*  80 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /*  83 */
        this.desc = desc;

    }


    public String getThumb() {
        /*  87 */
        return this.thumb;

    }


    public void setThumb(String thumb) {
        /*  90 */
        this.thumb = thumb;

    }


    public String getTitle() {
        /*  94 */
        return this.title;

    }


    public void setTitle(String title) {
        /*  97 */
        this.title = title;

    }


    public String getUrl() {
        /* 101 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 104 */
        this.url = url;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.NewsfeedMediaLinkInfo
 * JD-Core Version:    0.6.0
 */