package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class KoubeiMarketingCampaignActivityModifyModel extends AlipayObject {
    private static final long serialVersionUID = 7255874464642922372L;


    @ApiField("budget_info")
    private BudgetInfo budgetInfo;


    @ApiField("camp_id")
    private String campId;


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
        /* 118 */
        return this.budgetInfo;

    }


    public void setBudgetInfo(BudgetInfo budgetInfo) {
        /* 121 */
        this.budgetInfo = budgetInfo;

    }


    public String getCampId() {
        /* 125 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /* 128 */
        this.campId = campId;

    }


    public ConstraintInfo getConstraintInfo() {
        /* 132 */
        return this.constraintInfo;

    }


    public void setConstraintInfo(ConstraintInfo constraintInfo) {
        /* 135 */
        this.constraintInfo = constraintInfo;

    }


    public String getDesc() {
        /* 139 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 142 */
        this.desc = desc;

    }


    public Date getEndTime() {
        /* 146 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 149 */
        this.endTime = endTime;

    }


    public String getExtInfo() {
        /* 153 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 156 */
        this.extInfo = extInfo;

    }


    public String getName() {
        /* 160 */
        return this.name;

    }


    public void setName(String name) {
        /* 163 */
        this.name = name;

    }


    public String getOperatorId() {
        /* 167 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /* 170 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /* 174 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /* 177 */
        this.operatorType = operatorType;

    }


    public String getOutBizNo() {
        /* 181 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /* 184 */
        this.outBizNo = outBizNo;

    }


    public List<PromoTool> getPromoTools() {
        /* 188 */
        return this.promoTools;

    }


    public void setPromoTools(List<PromoTool> promoTools) {
        /* 191 */
        this.promoTools = promoTools;

    }


    public List<PublishChannel> getPublishChannels() {
        /* 195 */
        return this.publishChannels;

    }


    public void setPublishChannels(List<PublishChannel> publishChannels) {
        /* 198 */
        this.publishChannels = publishChannels;

    }


    public RecruitTool getRecruitTool() {
        /* 202 */
        return this.recruitTool;

    }


    public void setRecruitTool(RecruitTool recruitTool) {
        /* 205 */
        this.recruitTool = recruitTool;

    }


    public Date getStartTime() {
        /* 209 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 212 */
        this.startTime = startTime;

    }


    public String getType() {
        /* 216 */
        return this.type;

    }


    public void setType(String type) {
        /* 219 */
        this.type = type;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignActivityModifyModel
 * JD-Core Version:    0.6.0
 */