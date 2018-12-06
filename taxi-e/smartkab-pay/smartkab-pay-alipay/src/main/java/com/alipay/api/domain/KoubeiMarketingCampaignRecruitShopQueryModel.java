package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignRecruitShopQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1224953181971673783L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("invitee")
    private String invitee;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_type")
    private String operatorType;

    @ApiField("page_num")
    private String pageNum;

    @ApiField("page_size")
    private String pageSize;

    public String getCampId() {
        /* 53 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 56 */
        this.campId = campId;
    }

    public String getInvitee() {
        /* 60 */
        return this.invitee;
    }

    public void setInvitee(String invitee) {
        /* 63 */
        this.invitee = invitee;
    }

    public String getOperatorId() {
        /* 67 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 70 */
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        /* 74 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 77 */
        this.operatorType = operatorType;
    }

    public String getPageNum() {
        /* 81 */
        return this.pageNum;
    }

    public void setPageNum(String pageNum) {
        /* 84 */
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        /* 88 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 91 */
        this.pageSize = pageSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignRecruitShopQueryModel
 * JD-Core Version:    0.6.0
 */