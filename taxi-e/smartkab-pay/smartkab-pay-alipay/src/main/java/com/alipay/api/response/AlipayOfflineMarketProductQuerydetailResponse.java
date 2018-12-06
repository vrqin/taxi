package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayDataItemDescription;
import com.alipay.api.domain.AlipayDataItemSalesRule;
import com.alipay.api.domain.AlipayDataItemVoucherTemplete;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayOfflineMarketProductQuerydetailResponse extends AlipayResponse {
    private static final long serialVersionUID = 1217272762413479857L;


    @ApiField("cover")
    private String cover;


    @ApiListField("descriptions")

    @ApiField("alipay_data_item_description")
    private List<AlipayDataItemDescription> descriptions;


    @ApiField("gmt_end")
    private Date gmtEnd;


    @ApiField("gmt_start")
    private Date gmtStart;


    @ApiField("inventory")
    private Long inventory;


    @ApiField("is_auto_expanded")
    private Boolean isAutoExpanded;


    @ApiField("item_status")
    private String itemStatus;


    @ApiField("item_type")
    private String itemType;


    @ApiField("pic_coll")
    private String picColl;


    @ApiField("purchase_mode")
    private String purchaseMode;


    @ApiField("sales_rule")
    private AlipayDataItemSalesRule salesRule;


    @ApiListField("shop_list")

    @ApiField("string")
    private List<String> shopList;


    @ApiField("subject")
    private String subject;


    @ApiField("voucher_templete")
    private AlipayDataItemVoucherTemplete voucherTemplete;


    @ApiField("weight")
    private Long weight;


    public String getCover() {
        /* 126 */
        return this.cover;

    }


    public void setCover(String cover) {
        /* 123 */
        this.cover = cover;

    }


    public List<AlipayDataItemDescription> getDescriptions() {
        /* 133 */
        return this.descriptions;

    }


    public void setDescriptions(List<AlipayDataItemDescription> descriptions) {
        /* 130 */
        this.descriptions = descriptions;

    }


    public Date getGmtEnd() {
        /* 140 */
        return this.gmtEnd;

    }


    public void setGmtEnd(Date gmtEnd) {
        /* 137 */
        this.gmtEnd = gmtEnd;

    }


    public Date getGmtStart() {
        /* 147 */
        return this.gmtStart;

    }


    public void setGmtStart(Date gmtStart) {
        /* 144 */
        this.gmtStart = gmtStart;

    }


    public Long getInventory() {
        /* 154 */
        return this.inventory;

    }


    public void setInventory(Long inventory) {
        /* 151 */
        this.inventory = inventory;

    }


    public Boolean getIsAutoExpanded() {
        /* 161 */
        return this.isAutoExpanded;

    }


    public void setIsAutoExpanded(Boolean isAutoExpanded) {
        /* 158 */
        this.isAutoExpanded = isAutoExpanded;

    }


    public String getItemStatus() {
        /* 168 */
        return this.itemStatus;

    }


    public void setItemStatus(String itemStatus) {
        /* 165 */
        this.itemStatus = itemStatus;

    }


    public String getItemType() {
        /* 175 */
        return this.itemType;

    }


    public void setItemType(String itemType) {
        /* 172 */
        this.itemType = itemType;

    }


    public String getPicColl() {
        /* 182 */
        return this.picColl;

    }


    public void setPicColl(String picColl) {
        /* 179 */
        this.picColl = picColl;

    }


    public String getPurchaseMode() {
        /* 189 */
        return this.purchaseMode;

    }


    public void setPurchaseMode(String purchaseMode) {
        /* 186 */
        this.purchaseMode = purchaseMode;

    }


    public AlipayDataItemSalesRule getSalesRule() {
        /* 196 */
        return this.salesRule;

    }


    public void setSalesRule(AlipayDataItemSalesRule salesRule) {
        /* 193 */
        this.salesRule = salesRule;

    }


    public List<String> getShopList() {
        /* 203 */
        return this.shopList;

    }


    public void setShopList(List<String> shopList) {
        /* 200 */
        this.shopList = shopList;

    }


    public String getSubject() {
        /* 210 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 207 */
        this.subject = subject;

    }


    public AlipayDataItemVoucherTemplete getVoucherTemplete() {
        /* 217 */
        return this.voucherTemplete;

    }


    public void setVoucherTemplete(AlipayDataItemVoucherTemplete voucherTemplete) {
        /* 214 */
        this.voucherTemplete = voucherTemplete;

    }


    public Long getWeight() {
        /* 224 */
        return this.weight;

    }


    public void setWeight(Long weight) {
        /* 221 */
        this.weight = weight;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketProductQuerydetailResponse
 * JD-Core Version:    0.6.0
 */