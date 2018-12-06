package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayOfflineMarketItemCreateModel extends AlipayObject {
    private static final long serialVersionUID = 3665316369846245528L;


    @ApiField("audit_rule")
    private AlipayItemAuditRule auditRule;


    @ApiField("cover")
    private String cover;


    @ApiListField("descriptions")

    @ApiField("alipay_item_description")
    private List<AlipayItemDescription> descriptions;


    @ApiField("gmt_end")
    private Date gmtEnd;


    @ApiField("gmt_start")
    private Date gmtStart;


    @ApiField("inventory")
    private Long inventory;


    @ApiField("is_auto_expanded")
    private Boolean isAutoExpanded;


    @ApiField("item_type")
    private String itemType;


    @ApiField("operate_notify_url")
    private String operateNotifyUrl;


    @ApiField("operation_context")
    private AlipayItemOperationContext operationContext;


    @ApiField("purchase_mode")
    private String purchaseMode;


    @ApiField("request_id")
    private String requestId;


    @ApiField("sales_rule")
    private AlipayItemSalesRule salesRule;


    @ApiField("shop_list")
    private String shopList;


    @ApiField("subject")
    private String subject;


    @ApiField("voucher_templete")
    private AlipayItemVoucherTemplete voucherTemplete;


    @ApiField("weight")
    private Long weight;


    public AlipayItemAuditRule getAuditRule() {
        /* 126 */
        return this.auditRule;

    }


    public void setAuditRule(AlipayItemAuditRule auditRule) {
        /* 129 */
        this.auditRule = auditRule;

    }


    public String getCover() {
        /* 133 */
        return this.cover;

    }


    public void setCover(String cover) {
        /* 136 */
        this.cover = cover;

    }


    public List<AlipayItemDescription> getDescriptions() {
        /* 140 */
        return this.descriptions;

    }


    public void setDescriptions(List<AlipayItemDescription> descriptions) {
        /* 143 */
        this.descriptions = descriptions;

    }


    public Date getGmtEnd() {
        /* 147 */
        return this.gmtEnd;

    }


    public void setGmtEnd(Date gmtEnd) {
        /* 150 */
        this.gmtEnd = gmtEnd;

    }


    public Date getGmtStart() {
        /* 154 */
        return this.gmtStart;

    }


    public void setGmtStart(Date gmtStart) {
        /* 157 */
        this.gmtStart = gmtStart;

    }


    public Long getInventory() {
        /* 161 */
        return this.inventory;

    }


    public void setInventory(Long inventory) {
        /* 164 */
        this.inventory = inventory;

    }


    public Boolean getIsAutoExpanded() {
        /* 168 */
        return this.isAutoExpanded;

    }


    public void setIsAutoExpanded(Boolean isAutoExpanded) {
        /* 171 */
        this.isAutoExpanded = isAutoExpanded;

    }


    public String getItemType() {
        /* 175 */
        return this.itemType;

    }


    public void setItemType(String itemType) {
        /* 178 */
        this.itemType = itemType;

    }


    public String getOperateNotifyUrl() {
        /* 182 */
        return this.operateNotifyUrl;

    }


    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 185 */
        this.operateNotifyUrl = operateNotifyUrl;

    }


    public AlipayItemOperationContext getOperationContext() {
        /* 189 */
        return this.operationContext;

    }


    public void setOperationContext(AlipayItemOperationContext operationContext) {
        /* 192 */
        this.operationContext = operationContext;

    }


    public String getPurchaseMode() {
        /* 196 */
        return this.purchaseMode;

    }


    public void setPurchaseMode(String purchaseMode) {
        /* 199 */
        this.purchaseMode = purchaseMode;

    }


    public String getRequestId() {
        /* 203 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 206 */
        this.requestId = requestId;

    }


    public AlipayItemSalesRule getSalesRule() {
        /* 210 */
        return this.salesRule;

    }


    public void setSalesRule(AlipayItemSalesRule salesRule) {
        /* 213 */
        this.salesRule = salesRule;

    }


    public String getShopList() {
        /* 217 */
        return this.shopList;

    }


    public void setShopList(String shopList) {
        /* 220 */
        this.shopList = shopList;

    }


    public String getSubject() {
        /* 224 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 227 */
        this.subject = subject;

    }


    public AlipayItemVoucherTemplete getVoucherTemplete() {
        /* 231 */
        return this.voucherTemplete;

    }


    public void setVoucherTemplete(AlipayItemVoucherTemplete voucherTemplete) {
        /* 234 */
        this.voucherTemplete = voucherTemplete;

    }


    public Long getWeight() {
        /* 238 */
        return this.weight;

    }


    public void setWeight(Long weight) {
        /* 241 */
        this.weight = weight;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketItemCreateModel
 * JD-Core Version:    0.6.0
 */