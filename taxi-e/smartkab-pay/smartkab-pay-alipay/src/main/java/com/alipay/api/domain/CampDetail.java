package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class CampDetail extends AlipayObject {
    private static final long serialVersionUID = 1737927922575176369L;


    @ApiField("audit_status")
    private String auditStatus;


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


    @ApiField("id")
    private String id;


    @ApiField("name")
    private String name;


    @ApiListField("promo_tools")

    @ApiField("promo_tool")
    private List<PromoTool> promoTools;


    @ApiListField("publish_channels")

    @ApiField("publish_channel")
    private List<PublishChannel> publishChannels;


    @ApiField("recruit_info")
    private RecruitInfo recruitInfo;


    @ApiField("start_time")
    private Date startTime;


    @ApiField("status")
    private String status;


    @ApiField("type")
    private String type;


    public String getAuditStatus() {
        /* 107 */
        return this.auditStatus;

    }


    public void setAuditStatus(String auditStatus) {
        /* 110 */
        this.auditStatus = auditStatus;

    }


    public BudgetInfo getBudgetInfo() {
        /* 114 */
        return this.budgetInfo;

    }


    public void setBudgetInfo(BudgetInfo budgetInfo) {
        /* 117 */
        this.budgetInfo = budgetInfo;

    }


    public ConstraintInfo getConstraintInfo() {
        /* 121 */
        return this.constraintInfo;

    }


    public void setConstraintInfo(ConstraintInfo constraintInfo) {
        /* 124 */
        this.constraintInfo = constraintInfo;

    }


    public String getDesc() {
        /* 128 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 131 */
        this.desc = desc;

    }


    public Date getEndTime() {
        /* 135 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 138 */
        this.endTime = endTime;

    }


    public String getExtInfo() {
        /* 142 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 145 */
        this.extInfo = extInfo;

    }


    public String getId() {
        /* 149 */
        return this.id;

    }


    public void setId(String id) {
        /* 152 */
        this.id = id;

    }


    public String getName() {
        /* 156 */
        return this.name;

    }


    public void setName(String name) {
        /* 159 */
        this.name = name;

    }


    public List<PromoTool> getPromoTools() {
        /* 163 */
        return this.promoTools;

    }


    public void setPromoTools(List<PromoTool> promoTools) {
        /* 166 */
        this.promoTools = promoTools;

    }


    public List<PublishChannel> getPublishChannels() {
        /* 170 */
        return this.publishChannels;

    }


    public void setPublishChannels(List<PublishChannel> publishChannels) {
        /* 173 */
        this.publishChannels = publishChannels;

    }


    public RecruitInfo getRecruitInfo() {
        /* 177 */
        return this.recruitInfo;

    }


    public void setRecruitInfo(RecruitInfo recruitInfo) {
        /* 180 */
        this.recruitInfo = recruitInfo;

    }


    public Date getStartTime() {
        /* 184 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 187 */
        this.startTime = startTime;

    }


    public String getStatus() {
        /* 191 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 194 */
        this.status = status;

    }


    public String getType() {
        /* 198 */
        return this.type;

    }


    public void setType(String type) {
        /* 201 */
        this.type = type;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CampDetail
 * JD-Core Version:    0.6.0
 */