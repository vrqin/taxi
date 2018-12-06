package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ExtItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiItemExtitemBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4274985753765386787L;

    @ApiListField("model_list")
    @ApiField("ext_item")
    private List<ExtItem> modelList;

    @ApiField("page_num")
    private String pageNum;

    @ApiField("page_size")
    private String pageSize;

    @ApiField("total_size")
    private String totalSize;

    public List<ExtItem> getModelList() {
        /* 49 */
        return this.modelList;
    }

    public void setModelList(List<ExtItem> modelList) {
        /* 46 */
        this.modelList = modelList;
    }

    public String getPageNum() {
        /* 56 */
        return this.pageNum;
    }

    public void setPageNum(String pageNum) {
        /* 53 */
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        /* 63 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 60 */
        this.pageSize = pageSize;
    }

    public String getTotalSize() {
        /* 70 */
        return this.totalSize;
    }

    public void setTotalSize(String totalSize) {
        /* 67 */
        this.totalSize = totalSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiItemExtitemBatchqueryResponse
 * JD-Core Version:    0.6.0
 */