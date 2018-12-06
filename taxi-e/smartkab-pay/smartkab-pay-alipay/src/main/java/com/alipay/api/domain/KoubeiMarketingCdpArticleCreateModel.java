package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class KoubeiMarketingCdpArticleCreateModel extends AlipayObject {
    private static final long serialVersionUID = 1882669387714732227L;


    @ApiField("author_intro")
    private String authorIntro;


    @ApiField("author_name")
    private String authorName;


    @ApiField("cover")
    private ArticlePicture cover;


    @ApiField("introduction")
    private String introduction;


    @ApiListField("paragraph_list")

    @ApiField("article_paragraph")
    private List<ArticleParagraph> paragraphList;


    @ApiField("provider")
    private String provider;


    @ApiField("shop_address")
    private String shopAddress;


    @ApiListField("shop_ids")

    @ApiField("string")
    private List<String> shopIds;


    @ApiField("shop_name")
    private String shopName;


    @ApiField("title")
    private String title;


    public String getAuthorIntro() {
        /*  82 */
        return this.authorIntro;

    }


    public void setAuthorIntro(String authorIntro) {
        /*  85 */
        this.authorIntro = authorIntro;

    }


    public String getAuthorName() {
        /*  89 */
        return this.authorName;

    }


    public void setAuthorName(String authorName) {
        /*  92 */
        this.authorName = authorName;

    }


    public ArticlePicture getCover() {
        /*  96 */
        return this.cover;

    }


    public void setCover(ArticlePicture cover) {
        /*  99 */
        this.cover = cover;

    }


    public String getIntroduction() {
        /* 103 */
        return this.introduction;

    }


    public void setIntroduction(String introduction) {
        /* 106 */
        this.introduction = introduction;

    }


    public List<ArticleParagraph> getParagraphList() {
        /* 110 */
        return this.paragraphList;

    }


    public void setParagraphList(List<ArticleParagraph> paragraphList) {
        /* 113 */
        this.paragraphList = paragraphList;

    }


    public String getProvider() {
        /* 117 */
        return this.provider;

    }


    public void setProvider(String provider) {
        /* 120 */
        this.provider = provider;

    }


    public String getShopAddress() {
        /* 124 */
        return this.shopAddress;

    }


    public void setShopAddress(String shopAddress) {
        /* 127 */
        this.shopAddress = shopAddress;

    }


    public List<String> getShopIds() {
        /* 131 */
        return this.shopIds;

    }


    public void setShopIds(List<String> shopIds) {
        /* 134 */
        this.shopIds = shopIds;

    }


    public String getShopName() {
        /* 138 */
        return this.shopName;

    }


    public void setShopName(String shopName) {
        /* 141 */
        this.shopName = shopName;

    }


    public String getTitle() {
        /* 145 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 148 */
        this.title = title;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpArticleCreateModel
 * JD-Core Version:    0.6.0
 */