package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayOfflineMarketApplyorderBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 5518783767291717439L;


    @ApiField("action")
    private String action;


    @ApiListField("apply_ids")

    @ApiField("string")
    private List<String> applyIds;


    @ApiField("biz_id")
    private String bizId;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("end_time")
    private Date endTime;


    @ApiField("op_id")
    private String opId;


    @ApiField("op_role")
    private String opRole;


    @ApiField("page_no")
    private Long pageNo;


    @ApiField("page_size")
    private Long pageSize;


    @ApiListField("request_ids")

    @ApiField("string")
    private List<String> requestIds;


    @ApiField("start_time")
    private Date startTime;


    @ApiField("status")
    private String status;


    public String getAction() {
        /*  96 */
        return this.action;

    }


    public void setAction(String action) {
        /*  99 */
        this.action = action;

    }


    public List<String> getApplyIds() {
        /* 103 */
        return this.applyIds;

    }


    public void setApplyIds(List<String> applyIds) {
        /* 106 */
        this.applyIds = applyIds;

    }


    public String getBizId() {
        /* 110 */
        return this.bizId;

    }


    public void setBizId(String bizId) {
        /* 113 */
        this.bizId = bizId;

    }


    public String getBizType() {
        /* 117 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 120 */
        this.bizType = bizType;

    }


    public Date getEndTime() {
        /* 124 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 127 */
        this.endTime = endTime;

    }


    public String getOpId() {
        /* 131 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 134 */
        this.opId = opId;

    }


    public String getOpRole() {
        /* 138 */
        return this.opRole;

    }


    public void setOpRole(String opRole) {
        /* 141 */
        this.opRole = opRole;

    }


    public Long getPageNo() {
        /* 145 */
        return this.pageNo;

    }


    public void setPageNo(Long pageNo) {
        /* 148 */
        this.pageNo = pageNo;

    }


    public Long getPageSize() {
        /* 152 */
        return this.pageSize;

    }


    public void setPageSize(Long pageSize) {
        /* 155 */
        this.pageSize = pageSize;

    }


    public List<String> getRequestIds() {
        /* 159 */
        return this.requestIds;

    }


    public void setRequestIds(List<String> requestIds) {
        /* 162 */
        this.requestIds = requestIds;

    }


    public Date getStartTime() {
        /* 166 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 169 */
        this.startTime = startTime;

    }


    public String getStatus() {
        /* 173 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 176 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketApplyorderBatchqueryModel
 * JD-Core Version:    0.6.0
 */