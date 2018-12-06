package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SaleProduct extends AlipayObject {
    private static final long serialVersionUID = 4889778875138129716L;

    @ApiField("channel_type")
    private String channelType;

    @ApiField("id")
    private String id;

    @ApiField("market_price")
    private String marketPrice;

    @ApiField("product_provider")
    private ProductProvider productProvider;

    @ApiField("sale_price")
    private String salePrice;

    @ApiField("status")
    private String status;

    public String getChannelType() {
        /* 53 */
        return this.channelType;
    }

    public void setChannelType(String channelType) {
        /* 56 */
        this.channelType = channelType;
    }

    public String getId() {
        /* 60 */
        return this.id;
    }

    public void setId(String id) {
        /* 63 */
        this.id = id;
    }

    public String getMarketPrice() {
        /* 67 */
        return this.marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        /* 70 */
        this.marketPrice = marketPrice;
    }

    public ProductProvider getProductProvider() {
        /* 74 */
        return this.productProvider;
    }

    public void setProductProvider(ProductProvider productProvider) {
        /* 77 */
        this.productProvider = productProvider;
    }

    public String getSalePrice() {
        /* 81 */
        return this.salePrice;
    }

    public void setSalePrice(String salePrice) {
        /* 84 */
        this.salePrice = salePrice;
    }

    public String getStatus() {
        /* 88 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 91 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SaleProduct
 * JD-Core Version:    0.6.0
 */