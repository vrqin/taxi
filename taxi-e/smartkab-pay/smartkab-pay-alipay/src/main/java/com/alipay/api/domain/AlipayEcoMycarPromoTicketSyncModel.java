package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcoMycarPromoTicketSyncModel extends AlipayObject {
    private static final long serialVersionUID = 2622212962456296452L;

    @ApiField("active_id")
    private String activeId;

    @ApiListField("code_no_list")
    @ApiField("code_n_o_list")
    private List<CodeNOList> codeNoList;

    @ApiField("source_type")
    private String sourceType;

    public String getActiveId() {
        /* 39 */
        return this.activeId;
    }

    public void setActiveId(String activeId) {
        /* 42 */
        this.activeId = activeId;
    }

    public List<CodeNOList> getCodeNoList() {
        /* 46 */
        return this.codeNoList;
    }

    public void setCodeNoList(List<CodeNOList> codeNoList) {
        /* 49 */
        this.codeNoList = codeNoList;
    }

    public String getSourceType() {
        /* 53 */
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        /* 56 */
        this.sourceType = sourceType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarPromoTicketSyncModel
 * JD-Core Version:    0.6.0
 */