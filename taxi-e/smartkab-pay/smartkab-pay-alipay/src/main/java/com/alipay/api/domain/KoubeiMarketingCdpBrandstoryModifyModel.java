package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCdpBrandstoryModifyModel extends AlipayObject {
    private static final long serialVersionUID = 8782639493359498718L;

    @ApiField("content_id")
    private String contentId;

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

    public String getContentId() {
        /* 58 */
        return this.contentId;
    }

    public void setContentId(String contentId) {
        /* 61 */
        this.contentId = contentId;
    }

    public Picture getCover() {
        /* 65 */
        return this.cover;
    }

    public void setCover(Picture cover) {
        /* 68 */
        this.cover = cover;
    }

    public List<Paragraph> getParagraphList() {
        /* 72 */
        return this.paragraphList;
    }

    public void setParagraphList(List<Paragraph> paragraphList) {
        /* 75 */
        this.paragraphList = paragraphList;
    }

    public List<String> getShopIds() {
        /* 79 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 82 */
        this.shopIds = shopIds;
    }

    public String getTitle() {
        /* 86 */
        return this.title;
    }

    public void setTitle(String title) {
        /* 89 */
        this.title = title;
    }

    public Video getVideo() {
        /* 93 */
        return this.video;
    }

    public void setVideo(Video video) {
        /* 96 */
        this.video = video;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpBrandstoryModifyModel
 * JD-Core Version:    0.6.0
 */