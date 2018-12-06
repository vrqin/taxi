package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.OpenItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class KoubeiQualityTestCloudacptItemQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4897761173122892572L;


    @ApiField("activity_id")
    private String activityId;


    @ApiField("batch_id")
    private String batchId;


    @ApiField("batch_status")
    private String batchStatus;


    @ApiListField("fail_list")

    @ApiField("open_item")
    private List<OpenItem> failList;


    @ApiField("fail_num")
    private String failNum;


    @ApiListField("item_list")

    @ApiField("open_item")
    private List<OpenItem> itemList;


    @ApiField("item_num")
    private String itemNum;


    @ApiListField("pass_list")

    @ApiField("open_item")
    private List<OpenItem> passList;


    @ApiField("pass_num")
    private String passNum;


    public String getActivityId() {
        /*  85 */
        return this.activityId;

    }


    public void setActivityId(String activityId) {
        /*  82 */
        this.activityId = activityId;

    }


    public String getBatchId() {
        /*  92 */
        return this.batchId;

    }


    public void setBatchId(String batchId) {
        /*  89 */
        this.batchId = batchId;

    }


    public String getBatchStatus() {
        /*  99 */
        return this.batchStatus;

    }


    public void setBatchStatus(String batchStatus) {
        /*  96 */
        this.batchStatus = batchStatus;

    }


    public List<OpenItem> getFailList() {
        /* 106 */
        return this.failList;

    }


    public void setFailList(List<OpenItem> failList) {
        /* 103 */
        this.failList = failList;

    }


    public String getFailNum() {
        /* 113 */
        return this.failNum;

    }


    public void setFailNum(String failNum) {
        /* 110 */
        this.failNum = failNum;

    }


    public List<OpenItem> getItemList() {
        /* 120 */
        return this.itemList;

    }


    public void setItemList(List<OpenItem> itemList) {
        /* 117 */
        this.itemList = itemList;

    }


    public String getItemNum() {
        /* 127 */
        return this.itemNum;

    }


    public void setItemNum(String itemNum) {
        /* 124 */
        this.itemNum = itemNum;

    }


    public List<OpenItem> getPassList() {
        /* 134 */
        return this.passList;

    }


    public void setPassList(List<OpenItem> passList) {
        /* 131 */
        this.passList = passList;

    }


    public String getPassNum() {
        /* 141 */
        return this.passNum;

    }


    public void setPassNum(String passNum) {
        /* 138 */
        this.passNum = passNum;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiQualityTestCloudacptItemQueryResponse
 * JD-Core Version:    0.6.0
 */