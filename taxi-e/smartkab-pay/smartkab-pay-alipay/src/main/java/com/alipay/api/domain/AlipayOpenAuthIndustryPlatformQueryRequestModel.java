package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthIndustryPlatformQueryRequestModel extends AlipayObject {
    private static final long serialVersionUID = 3727872583152856383L;

    @ApiField("external_system_name")
    private String externalSystemName;

    @ApiField("is_transfer_uid")
    private Boolean isTransferUid;

    @ApiField("operate_type")
    private String operateType;

    @ApiField("query_condition")
    private String queryCondition;

    public String getExternalSystemName() {
        /* 41 */
        return this.externalSystemName;
    }

    public void setExternalSystemName(String externalSystemName) {
        /* 44 */
        this.externalSystemName = externalSystemName;
    }

    public Boolean getIsTransferUid() {
        /* 48 */
        return this.isTransferUid;
    }

    public void setIsTransferUid(Boolean isTransferUid) {
        /* 51 */
        this.isTransferUid = isTransferUid;
    }

    public String getOperateType() {
        /* 55 */
        return this.operateType;
    }

    public void setOperateType(String operateType) {
        /* 58 */
        this.operateType = operateType;
    }

    public String getQueryCondition() {
        /* 62 */
        return this.queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        /* 65 */
        this.queryCondition = queryCondition;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAuthIndustryPlatformQueryRequestModel
 * JD-Core Version:    0.6.0
 */