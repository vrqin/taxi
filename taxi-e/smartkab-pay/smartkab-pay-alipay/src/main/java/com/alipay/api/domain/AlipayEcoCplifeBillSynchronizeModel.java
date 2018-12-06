package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoCplifeBillSynchronizeModel extends AlipayObject {
    private static final long serialVersionUID = 7786111466818175631L;

    @ApiField("bill_entry_id")
    private String billEntryId;

    @ApiField("community_id")
    private String communityId;

    @ApiField("new_deadline")
    private String newDeadline;

    @ApiField("new_entry_amount")
    private String newEntryAmount;

    @ApiField("operate_type")
    private String operateType;

    public String getBillEntryId() {
        /* 53 */
        return this.billEntryId;
    }

    public void setBillEntryId(String billEntryId) {
        /* 56 */
        this.billEntryId = billEntryId;
    }

    public String getCommunityId() {
        /* 60 */
        return this.communityId;
    }

    public void setCommunityId(String communityId) {
        /* 63 */
        this.communityId = communityId;
    }

    public String getNewDeadline() {
        /* 67 */
        return this.newDeadline;
    }

    public void setNewDeadline(String newDeadline) {
        /* 70 */
        this.newDeadline = newDeadline;
    }

    public String getNewEntryAmount() {
        /* 74 */
        return this.newEntryAmount;
    }

    public void setNewEntryAmount(String newEntryAmount) {
        /* 77 */
        this.newEntryAmount = newEntryAmount;
    }

    public String getOperateType() {
        /* 81 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 84 */
        this.operateType = operateType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoCplifeBillSynchronizeModel
 * JD-Core Version:    0.6.0
 */