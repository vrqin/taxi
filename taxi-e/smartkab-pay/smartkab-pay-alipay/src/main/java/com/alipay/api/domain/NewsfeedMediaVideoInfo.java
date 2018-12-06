package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class NewsfeedMediaVideoInfo extends AlipayObject {
    private static final long serialVersionUID = 3754758687731866611L;

    @ApiField("height")
    private String height;

    @ApiField("img_id")
    private String imgId;

    @ApiField("video_id")
    private String videoId;

    @ApiField("width")
    private String width;

    public String getHeight() {
        /* 41 */
        return this.height;
    }

    public void setHeight(String height) {
        /* 44 */
        this.height = height;
    }

    public String getImgId() {
        /* 48 */
        return this.imgId;
    }

    public void setImgId(String imgId) {
        /* 51 */
        this.imgId = imgId;
    }

    public String getVideoId() {
        /* 55 */
        return this.videoId;
    }

    public void setVideoId(String videoId) {
        /* 58 */
        this.videoId = videoId;
    }

    public String getWidth() {
        /* 62 */
        return this.width;
    }

    public void setWidth(String width) {
        /* 65 */
        this.width = width;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.NewsfeedMediaVideoInfo
 * JD-Core Version:    0.6.0
 */