package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipaySiteprobeShopInfoGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 2268432649849255877L;


    @ApiField("adv_type")
    private String advType;


    @ApiField("code")
    private String code;


    @ApiField("logo")
    private String logo;


    @ApiField("msg")
    private String msg;


    @ApiField("public_name")
    private String publicName;


    @ApiField("shop_name")
    private String shopName;


    @ApiField("shop_notice")
    private String shopNotice;


    @ApiField("third_party_shop_name")
    private String thirdPartyShopName;


    @ApiField("url")
    private String url;


    public String getAdvType() {
        /*  75 */
        return this.advType;

    }


    public void setAdvType(String advType) {
        /*  72 */
        this.advType = advType;

    }


    public String getCode() {
        /*  82 */
        return this.code;

    }


    public void setCode(String code) {
        /*  79 */
        this.code = code;

    }


    public String getLogo() {
        /*  89 */
        return this.logo;

    }


    public void setLogo(String logo) {
        /*  86 */
        this.logo = logo;

    }


    public String getMsg() {
        /*  96 */
        return this.msg;

    }


    public void setMsg(String msg) {
        /*  93 */
        this.msg = msg;

    }


    public String getPublicName() {
        /* 103 */
        return this.publicName;

    }


    public void setPublicName(String publicName) {
        /* 100 */
        this.publicName = publicName;

    }


    public String getShopName() {
        /* 110 */
        return this.shopName;

    }


    public void setShopName(String shopName) {
        /* 107 */
        this.shopName = shopName;

    }


    public String getShopNotice() {
        /* 117 */
        return this.shopNotice;

    }


    public void setShopNotice(String shopNotice) {
        /* 114 */
        this.shopNotice = shopNotice;

    }


    public String getThirdPartyShopName() {
        /* 124 */
        return this.thirdPartyShopName;

    }


    public void setThirdPartyShopName(String thirdPartyShopName) {
        /* 121 */
        this.thirdPartyShopName = thirdPartyShopName;

    }


    public String getUrl() {
        /* 131 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 128 */
        this.url = url;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeShopInfoGetResponse
 * JD-Core Version:    0.6.0
 */