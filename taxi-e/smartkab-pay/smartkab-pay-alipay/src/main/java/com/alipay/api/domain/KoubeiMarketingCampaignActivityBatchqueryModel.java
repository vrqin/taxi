package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCampaignActivityBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 3833239495132661716L;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_type")
    private String operatorType;

    @ApiField("page_number")
    private String pageNumber;

    @ApiField("page_size")
    private String pageSize;

    @ApiListField("query_criterias")
    @ApiField("condition")
    private List<Condition> queryCriterias;

    public String getOperatorId() {
        /* 51 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 54 */
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        /* 58 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 61 */
        this.operatorType = operatorType;
    }

    public String getPageNumber() {
        /* 65 */
        return this.pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        /* 68 */
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        /* 72 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 75 */
        this.pageSize = pageSize;
    }

    public List<Condition> getQueryCriterias() {
        /* 79 */
        return this.queryCriterias;
    }

    public void setQueryCriterias(List<Condition> queryCriterias) {
        /* 82 */
        this.queryCriterias = queryCriterias;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignActivityBatchqueryModel
 * JD-Core Version:    0.6.0
 */