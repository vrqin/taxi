package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.Coupon;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayMemberCouponQuerylistResponse extends AlipayResponse {
    private static final long serialVersionUID = 6815143172516682656L;


    @ApiListField("coupon_list")

    @ApiField("coupon")
    private List<Coupon> couponList;


    @ApiField("error_code")
    private String errorCode;


    @ApiField("error_msg")
    private String errorMsg;


    @ApiField("list_size")
    private String listSize;


    @ApiField("success_code")
    private String successCode;


    @ApiField("total_num")
    private String totalNum;


    public List<Coupon> getCouponList() {
        /*  67 */
        return this.couponList;

    }


    public void setCouponList(List<Coupon> couponList) {
        /*  64 */
        this.couponList = couponList;

    }


    public String getErrorCode() {
        /*  74 */
        return this.errorCode;

    }


    public void setErrorCode(String errorCode) {
        /*  71 */
        this.errorCode = errorCode;

    }


    public String getErrorMsg() {
        /*  81 */
        return this.errorMsg;

    }


    public void setErrorMsg(String errorMsg) {
        /*  78 */
        this.errorMsg = errorMsg;

    }


    public String getListSize() {
        /*  88 */
        return this.listSize;

    }


    public void setListSize(String listSize) {
        /*  85 */
        this.listSize = listSize;

    }


    public String getSuccessCode() {
        /*  95 */
        return this.successCode;

    }


    public void setSuccessCode(String successCode) {
        /*  92 */
        this.successCode = successCode;

    }


    public String getTotalNum() {
        /* 102 */
        return this.totalNum;

    }


    public void setTotalNum(String totalNum) {
        /*  99 */
        this.totalNum = totalNum;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMemberCouponQuerylistResponse
 * JD-Core Version:    0.6.0
 */