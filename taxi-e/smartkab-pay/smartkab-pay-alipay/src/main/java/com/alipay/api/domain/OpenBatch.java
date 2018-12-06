package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenBatch extends AlipayObject {
    private static final long serialVersionUID = 4191346658972357263L;

    @ApiField("batch_id")
    private String batchId;

    @ApiField("batch_status")
    private String batchStatus;

    @ApiField("item_num")
    private String itemNum;

    public String getBatchId() {
        /* 39 */
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        /* 42 */
        this.batchId = batchId;
    }

    public String getBatchStatus() {
        /* 46 */
        return this.batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        /* 49 */
        this.batchStatus = batchStatus;
    }

    public String getItemNum() {
        /* 53 */
        return this.itemNum;
    }

    public void setItemNum(String itemNum) {
        /* 56 */
        this.itemNum = itemNum;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenBatch
 * JD-Core Version:    0.6.0
 */