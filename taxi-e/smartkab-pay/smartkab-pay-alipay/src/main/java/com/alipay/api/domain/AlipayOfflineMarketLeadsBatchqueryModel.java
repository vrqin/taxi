package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayOfflineMarketLeadsBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 7163486815372528273L;


    @ApiField("brand_name")
    private String brandName;


    @ApiField("category_id")
    private String categoryId;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("district_code")
    private String districtCode;


    @ApiField("end_time")
    private String endTime;


    @ApiListField("leads_ids")

    @ApiField("string")
    private List<String> leadsIds;


    @ApiField("leads_range")
    private String leadsRange;


    @ApiField("op_id")
    private String opId;


    @ApiField("page_no")
    private Long pageNo;


    @ApiField("page_size")
    private Long pageSize;


    @ApiField("province_code")
    private String provinceCode;


    @ApiListField("request_ids")

    @ApiField("string")
    private List<String> requestIds;


    @ApiField("shop_name")
    private String shopName;


    @ApiField("start_time")
    private String startTime;


    @ApiField("status")
    private String status;


    public String getBrandName() {
        /* 112 */
        return this.brandName;

    }


    public void setBrandName(String brandName) {
        /* 115 */
        this.brandName = brandName;

    }


    public String getCategoryId() {
        /* 119 */
        return this.categoryId;

    }


    public void setCategoryId(String categoryId) {
        /* 122 */
        this.categoryId = categoryId;

    }


    public String getCityCode() {
        /* 126 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /* 129 */
        this.cityCode = cityCode;

    }


    public String getDistrictCode() {
        /* 133 */
        return this.districtCode;

    }


    public void setDistrictCode(String districtCode) {
        /* 136 */
        this.districtCode = districtCode;

    }


    public String getEndTime() {
        /* 140 */
        return this.endTime;

    }


    public void setEndTime(String endTime) {
        /* 143 */
        this.endTime = endTime;

    }


    public List<String> getLeadsIds() {
        /* 147 */
        return this.leadsIds;

    }


    public void setLeadsIds(List<String> leadsIds) {
        /* 150 */
        this.leadsIds = leadsIds;

    }


    public String getLeadsRange() {
        /* 154 */
        return this.leadsRange;

    }


    public void setLeadsRange(String leadsRange) {
        /* 157 */
        this.leadsRange = leadsRange;

    }


    public String getOpId() {
        /* 161 */
        return this.opId;

    }


    public void setOpId(String opId) {
        /* 164 */
        this.opId = opId;

    }


    public Long getPageNo() {
        /* 168 */
        return this.pageNo;

    }


    public void setPageNo(Long pageNo) {
        /* 171 */
        this.pageNo = pageNo;

    }


    public Long getPageSize() {
        /* 175 */
        return this.pageSize;

    }


    public void setPageSize(Long pageSize) {
        /* 178 */
        this.pageSize = pageSize;

    }


    public String getProvinceCode() {
        /* 182 */
        return this.provinceCode;

    }


    public void setProvinceCode(String provinceCode) {
        /* 185 */
        this.provinceCode = provinceCode;

    }


    public List<String> getRequestIds() {
        /* 189 */
        return this.requestIds;

    }


    public void setRequestIds(List<String> requestIds) {
        /* 192 */
        this.requestIds = requestIds;

    }


    public String getShopName() {
        /* 196 */
        return this.shopName;

    }


    public void setShopName(String shopName) {
        /* 199 */
        this.shopName = shopName;

    }


    public String getStartTime() {
        /* 203 */
        return this.startTime;

    }


    public void setStartTime(String startTime) {
        /* 206 */
        this.startTime = startTime;

    }


    public String getStatus() {
        /* 210 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 213 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsBatchqueryModel
 * JD-Core Version:    0.6.0
 */