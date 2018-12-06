package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpBrandstoryCreateModel extends AlipayObject {
    private static final long serialVersionUID = 1788123412184179536L;

    @ApiField("cover")
    private Picture cover;

    @ApiListField("paragraph_list")
    @ApiField("paragraph")
    private List<Paragraph> paragraphList;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    @ApiField("title")
    private String title;

    @ApiField("video")
    private Video video;

    public Picture getCover() {
        /* 52 */
        return this.cover;
    }

    public void setCover(Picture cover) {
        /* 55 */
        this.cover = cover;
    }

    public List<Paragraph> getParagraphList() {
        /* 59 */
        return this.paragraphList;
    }

    public void setParagraphList(List<Paragraph> paragraphList) {
        /* 62 */
        this.paragraphList = paragraphList;
    }

    public List<String> getShopIds() {
        /* 66 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 69 */
        this.shopIds = shopIds;
    }

    public String getTitle() {
        /* 73 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 76 */
        this.title = title;
    }

    public Video getVideo() {
        /* 80 */
        return this.video;
    }

    public void setVideo(Video video) {
        /* 83 */
        this.video = video;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpBrandstoryCreateModel
 * JD-Core Version:    0.6.0
 */