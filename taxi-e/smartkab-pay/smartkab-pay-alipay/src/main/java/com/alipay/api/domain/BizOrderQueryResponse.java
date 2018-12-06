package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class BizOrderQueryResponse extends AlipayObject {
    private static final long serialVersionUID = 1592147946555239718L;


    @ApiField("action")
    private String action;


    @ApiField("action_mode")
    private String actionMode;


    @ApiField("apply_id")
    private String applyId;


    @ApiField("biz_context_info")
    private String bizContextInfo;


    @ApiField("biz_id")
    private String bizId;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("op_id")
    private String opId;


    @ApiField("request_id")
    private String requestId;


    @ApiField("result_code")
    private String resultCode;


    @ApiField("result_desc")
    private String resultDesc;


    @ApiField("status")
    private String status;


    @ApiField("sub_status")
    private String subStatus;


    @ApiField("update_time")
    private Date updateTime;


    public String getAction() {
        /* 113 */
        return this.action;

    }


    public void setAction(String action) {
        /* 116 */
        this.action = action;

    }


    public String getActionMode() {
        /* 120 */
        return this.actionMode;

    }


    public void setActionMode(String actionMode) {
        /* 123 */
        this.actionMode = actionMode;

    }


    public String getApplyId() {
        /* 127 */
        return this.applyId;

    }


    public void setApplyId(String applyId) {
        /* 130 */
        this.applyId = applyId;

    }


    public String getBizContextInfo() {
        /* 134 */
        return this.bizContextInfo;

    }


    public void setBizContextInfo(String bizContextInfo) {
        /* 137 */
        this.bizContextInfo = bizContextInfo;

    }


    public String getBizId() {
        /* 141 */
        return this.bizId;

    }


    public void setBizId(String bizId) {
        /* 144 */
        this.bizId = bizId;

    }


    public String getBizType() {
        /* 148 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 151 */
        this.bizType = bizType;

    }


    public Date getCreateTime() {
        /* 155 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /* 158 */
        this.createTime = createTime;

    }


    public String getOpId() {
        /* 162 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 165 */
        this.opId = opId;

    }


    public String getRequestId() {
        /* 169 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /* 172 */
        this.requestId = requestId;

    }


    public String getResultCode() {
        /* 176 */
        return this.resultCode;

    }


    public void setResultCode(String resultCode) {
        /* 179 */
        this.resultCode = resultCode;

    }


    public String getResultDesc() {
        /* 183 */
        return this.resultDesc;

    }


    public void setResultDesc(String resultDesc) {
        /* 186 */
        this.resultDesc = resultDesc;

    }


    public String getStatus() {
        /* 190 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 193 */
        this.status = status;

    }


    public String getSubStatus() {
        /* 197 */
        return this.subStatus;

    }


    public void setSubStatus(String subStatus) {
        /* 200 */
        this.subStatus = subStatus;

    }


    public Date getUpdateTime() {
        /* 204 */
        return this.updateTime;

    }


    public void setUpdateTime(Date updateTime) {
        /* 207 */
        this.updateTime = updateTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BizOrderQueryResponse
 * JD-Core Version:    0.6.0
 */