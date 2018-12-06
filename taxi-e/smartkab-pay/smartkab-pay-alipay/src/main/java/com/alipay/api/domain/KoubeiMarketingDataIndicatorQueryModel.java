package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class KoubeiMarketingDataIndicatorQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2593631477471537486L;


    @ApiField("begin_date")
    private String beginDate;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("end_date")
    private String endDate;


    @ApiField("ext_info")
    private String extInfo;


    @ApiField("page_num")
    private String pageNum;


    @ApiField("page_size")
    private String pageSize;


    public String getBeginDate() {
        /*  62 */
        return this.beginDate;

    }


    public void setBeginDate(String beginDate) {
        /*  65 */
        this.beginDate = beginDate;

    }


    public String getBizType() {
        /*  69 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  72 */
        this.bizType = bizType;

    }


    public String getEndDate() {
        /*  76 */
        return this.endDate;

    }


    public void setEndDate(String endDate) {
        /*  79 */
        this.endDate = endDate;

    }


    public String getExtInfo() {
        /*  83 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  86 */
        this.extInfo = extInfo;

    }


    public String getPageNum() {
        /*  90 */
        return this.pageNum;

    }


    public void setPageNum(String pageNum) {
        /*  93 */
        this.pageNum = pageNum;

    }


    public String getPageSize() {
        /*  97 */
        return this.pageSize;

    }


    public void setPageSize(String pageSize) {
        /* 100 */
        this.pageSize = pageSize;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataIndicatorQueryModel
 * JD-Core Version:    0.6.0
 */