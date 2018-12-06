package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineMarketItemListingModel extends AlipayObject {
    private static final long serialVersionUID = 2498677439717891395L;


    @ApiField("audit_rule")
    private AlipayItemAuditRule auditRule;


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


    @ApiField("state_type")
    private String stateType;


    public AlipayItemAuditRule getAuditRule() {
        /*  59 */
        return this.auditRule;

    }


    public void setAuditRule(AlipayItemAuditRule auditRule) {
        /*  62 */
        this.auditRule = auditRule;

    }


    public String getItemId() {
        /*  66 */
        return this.itemId;

    }


    public void setItemId(String itemId) {
        /*  69 */
        this.itemId = itemId;

    }


    public String getMemo() {
        /*  73 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  76 */
        this.memo = memo;

    }


    public String getOperateNotifyUrl() {
        /*  80 */
        return this.operateNotifyUrl;

    }


    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /*  83 */
        this.operateNotifyUrl = operateNotifyUrl;

    }


    public AlipayItemOperationContext getOperationContext() {
        /*  87 */
        return this.operationContext;

    }


    public void setOperationContext(AlipayItemOperationContext operationContext) {
        /*  90 */
        this.operationContext = operationContext;

    }


    public String getRequestId() {
        /*  94 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /*  97 */
        this.requestId = requestId;

    }


    public String getStateType() {
        /* 101 */
        return this.stateType;

    }


    public void setStateType(String stateType) {
        /* 104 */
        this.stateType = stateType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketItemListingModel
 * JD-Core Version:    0.6.0
 */