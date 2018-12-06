package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class KoubeiMarketingCampaignActivityCreateModel extends AlipayObject {
    private static final long serialVersionUID = 8352312276454718194L;


    @ApiField("budget_info")
    private BudgetInfo budgetInfo;


    @ApiField("constraint_info")
    private ConstraintInfo constraintInfo;


    @ApiField("desc")
    private String desc;


    @ApiField("end_time")
    private Date endTime;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("name")
    private String name;


    @ApiField("operator_id")
    private String operatorId;


    @ApiField("operator_type")
    private String operatorType;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiListField("promo_tools")

    @ApiField("promo_tool")
    private List<PromoTool> promoTools;


    @ApiListField("publish_channels")

    @ApiField("publish_channel")
    private List<PublishChannel> publishChannels;


    @ApiField("recruit_tool")
    private RecruitTool recruitTool;


    @ApiField("start_time")
    private Date startTime;


    @ApiField("type")
    private String type;


    public BudgetInfo getBudgetInfo() {
        /* 111 */
        return this.budgetInfo;

    }


    public void setBudgetInfo(BudgetInfo budgetInfo) {
        /* 114 */
        this.budgetInfo = budgetInfo;

    }


    public ConstraintInfo getConstraintInfo() {
        /* 118 */
        return this.constraintInfo;

    }


    public void setConstraintInfo(ConstraintInfo constraintInfo) {
        /* 121 */
        this.constraintInfo = constraintInfo;

    }


    public String getDesc() {
        /* 125 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 128 */
        this.desc = desc;

    }


    public Date getEndTime() {
        /* 132 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 135 */
        this.endTime = endTime;

    }


    public String getExtInfo() {
        /* 139 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 142 */
        this.extInfo = extInfo;

    }


    public String getName() {
        /* 146 */
        return this.name;

    }


    public void setName(String name) {
        /* 149 */
        this.name = name;

    }


    public String getOperatorId() {
        /* 153 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 156 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /* 160 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /* 163 */
        this.operatorType = operatorType;

    }


    public String getOutBizNo() {
        /* 167 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /* 170 */
        this.outBizNo = outBizNo;

    }


    public List<PromoTool> getPromoTools() {
        /* 174 */
        return this.promoTools;

    }


    public void setPromoTools(List<PromoTool> promoTools) {
        /* 177 */
        this.promoTools = promoTools;

    }


    public List<PublishChannel> getPublishChannels() {
        /* 181 */
        return this.publishChannels;

    }


    public void setPublishChannels(List<PublishChannel> publishChannels) {
        /* 184 */
        this.publishChannels = publishChannels;

    }


    public RecruitTool getRecruitTool() {
        /* 188 */
        return this.recruitTool;

    }


    public void setRecruitTool(RecruitTool recruitTool) {
        /* 191 */
        this.recruitTool = recruitTool;

    }


    public Date getStartTime() {
        /* 195 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 198 */
        this.startTime = startTime;

    }


    public String getType() {
        /* 202 */
        return this.type;

    }


    public void setType(String type) {
        /* 205 */
        this.type = type;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignActivityCreateModel
 * JD-Core Version:    0.6.0
 */