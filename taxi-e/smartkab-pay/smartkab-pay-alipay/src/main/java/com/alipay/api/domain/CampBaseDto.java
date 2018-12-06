package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class CampBaseDto extends AlipayObject {
    private static final long serialVersionUID = 7873853315228282617L;


    @ApiField("audit_status")
    private String auditStatus;


    @ApiField("end_time")
    private Date endTime;


    @ApiField("id")
    private String id;


    @ApiField("name")
    private String name;


    @ApiField("plan_status")
    private String planStatus;


    @ApiField("start_time")
    private Date startTime;


    @ApiField("status")
    private String status;


    @ApiField("type")
    private String type;


    public String getAuditStatus() {
        /*  67 */
        return this.auditStatus;

    }


    public void setAuditStatus(String auditStatus) {
        /*  70 */
        this.auditStatus = auditStatus;

    }


    public Date getEndTime() {
        /*  74 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /*  77 */
        this.endTime = endTime;

    }


    public String getId() {
        /*  81 */
        return this.id;

    }


    public void setId(String id) {
        /*  84 */
        this.id = id;

    }


    public String getName() {
        /*  88 */
        return this.name;

    }


    public void setName(String name) {
        /*  91 */
        this.name = name;

    }


    public String getPlanStatus() {
        /*  95 */
        return this.planStatus;

    }


    public void setPlanStatus(String planStatus) {
        /*  98 */
        this.planStatus = planStatus;

    }


    public Date getStartTime() {
        /* 102 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 105 */
        this.startTime = startTime;

    }


    public String getStatus() {
        /* 109 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 112 */
        this.status = status;

    }


    public String getType() {
        /* 116 */
        return this.type;

    }


    public void setType(String type) {
        /* 119 */
        this.type = type;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CampBaseDto
 * JD-Core Version:    0.6.0
 */