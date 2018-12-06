package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineProviderEquipmentAuthQuerybypageModel extends AlipayObject {
    private static final long serialVersionUID = 4131328675121119644L;


    @ApiField("begin_time")
    private String beginTime;


    @ApiField("device_type")
    private String deviceType;


    @ApiField("end_time")
    private String endTime;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("merchant_pid")
    private String merchantPid;


    @ApiField("page_num")
    private String pageNum;


    @ApiField("page_size")
    private String pageSize;


    public String getBeginTime() {
        /*  59 */
        return this.beginTime;

    }


    public void setBeginTime(String beginTime) {
        /*  62 */
        this.beginTime = beginTime;

    }


    public String getDeviceType() {
        /*  66 */
        return this.deviceType;

    }


    public void setDeviceType(String deviceType) {
        /*  69 */
        this.deviceType = deviceType;

    }


    public String getEndTime() {
        /*  73 */
        return this.endTime;

    }


    public void setEndTime(String endTime) {
        /*  76 */
        this.endTime = endTime;

    }


    public String getExtInfo() {
        /*  80 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  83 */
        this.extInfo = extInfo;

    }


    public String getMerchantPid() {
        /*  87 */
        return this.merchantPid;

    }


    public void setMerchantPid(String merchantPid) {
        /*  90 */
        this.merchantPid = merchantPid;

    }


    public String getPageNum() {
        /*  94 */
        return this.pageNum;

    }


    public void setPageNum(String pageNum) {
        /*  97 */
        this.pageNum = pageNum;

    }


    public String getPageSize() {
        /* 101 */
        return this.pageSize;

    }


    public void setPageSize(String pageSize) {
        /* 104 */
        this.pageSize = pageSize;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineProviderEquipmentAuthQuerybypageModel
 * JD-Core Version:    0.6.0
 */