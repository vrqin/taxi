package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineMarketItemModifyModel extends AlipayObject {
    private static final long serialVersionUID = 1349818554916518314L;


    @ApiField("audit_rule")
    private AlipayItemAuditRule auditRule;


    @ApiField("gmt_end")
    private String gmtEnd;


    @ApiField("inventory")
    private Long inventory;


    @ApiField("item_id")
    private String itemId;


    @ApiField("memo")
    private String memo;


    @ApiField("operate_notify_url")
    private String operateNotifyUrl;


    @ApiField("operation_context")
    private AlipayItemOperationContext operationContext;


    @ApiField("request_id")
    private String requestId;


    @ApiField("sales_rule")
    private AlipayItemSalesRule salesRule;


    @ApiField("weight")
    private Long weight;


    public AlipayItemAuditRule getAuditRule() {
        /*  77 */
        return this.auditRule;

    }


    public void setAuditRule(AlipayItemAuditRule auditRule) {
        /*  80 */
        this.auditRule = auditRule;

    }


    public String getGmtEnd() {
        /*  84 */
        return this.gmtEnd;

    }


    public void setGmtEnd(String gmtEnd) {
        /*  87 */
        this.gmtEnd = gmtEnd;

    }


    public Long getInventory() {
        /*  91 */
        return this.inventory;

    }


    public void setInventory(Long inventory) {
        /*  94 */
        this.inventory = inventory;

    }


    public String getItemId() {
        /*  98 */
        return this.itemId;

    }


    public void setItemId(String itemId) {
        /* 101 */
        this.itemId = itemId;

    }


    public String getMemo() {
        /* 105 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 108 */
        this.memo = memo;

    }


    public String getOperateNotifyUrl() {
        /* 112 */
        return this.operateNotifyUrl;

    }


    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 115 */
        this.operateNotifyUrl = operateNotifyUrl;

    }


    public AlipayItemOperationContext getOperationContext() {
        /* 119 */
        return this.operationContext;

    }


    public void setOperationContext(AlipayItemOperationContext operationContext) {
        /* 122 */
        this.operationContext = operationContext;

    }


    public String getRequestId() {
        /* 126 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 129 */
        this.requestId = requestId;

    }


    public AlipayItemSalesRule getSalesRule() {
        /* 133 */
        return this.salesRule;

    }


    public void setSalesRule(AlipayItemSalesRule salesRule) {
        /* 136 */
        this.salesRule = salesRule;

    }


    public Long getWeight() {
        /* 140 */
        return this.weight;

    }


    public void setWeight(Long weight) {
        /* 143 */
        this.weight = weight;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketItemModifyModel
 * JD-Core Version:    0.6.0
 */