package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMarketingCdpAdvertiseReportQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1369532986297889417L;


    @ApiField("click_pv_dd")
    private String clickPvDd;


    @ApiField("click_pv_history")
    private String clickPvHistory;


    @ApiField("click_uv_dd")
    private String clickUvDd;


    @ApiField("click_uv_history")
    private String clickUvHistory;


    @ApiField("report_date")
    private String reportDate;


    @ApiField("show_pv_dd")
    private String showPvDd;


    @ApiField("show_pv_history")
    private String showPvHistory;


    @ApiField("show_uv_dd")
    private String showUvDd;


    @ApiField("show_uv_history")
    private String showUvHistory;


    public String getClickPvDd() {
        /*  75 */
        return this.clickPvDd;

    }


    public void setClickPvDd(String clickPvDd) {
        /*  72 */
        this.clickPvDd = clickPvDd;

    }


    public String getClickPvHistory() {
        /*  82 */
        return this.clickPvHistory;

    }


    public void setClickPvHistory(String clickPvHistory) {
        /*  79 */
        this.clickPvHistory = clickPvHistory;

    }


    public String getClickUvDd() {
        /*  89 */
        return this.clickUvDd;

    }


    public void setClickUvDd(String clickUvDd) {
        /*  86 */
        this.clickUvDd = clickUvDd;

    }


    public String getClickUvHistory() {
        /*  96 */
        return this.clickUvHistory;

    }


    public void setClickUvHistory(String clickUvHistory) {
        /*  93 */
        this.clickUvHistory = clickUvHistory;

    }


    public String getReportDate() {
        /* 103 */
        return this.reportDate;

    }


    public void setReportDate(String reportDate) {
        /* 100 */
        this.reportDate = reportDate;

    }


    public String getShowPvDd() {
        /* 110 */
        return this.showPvDd;

    }


    public void setShowPvDd(String showPvDd) {
        /* 107 */
        this.showPvDd = showPvDd;

    }


    public String getShowPvHistory() {
        /* 117 */
        return this.showPvHistory;

    }


    public void setShowPvHistory(String showPvHistory) {
        /* 114 */
        this.showPvHistory = showPvHistory;

    }


    public String getShowUvDd() {
        /* 124 */
        return this.showUvDd;

    }


    public void setShowUvDd(String showUvDd) {
        /* 121 */
        this.showUvDd = showUvDd;

    }


    public String getShowUvHistory() {
        /* 131 */
        return this.showUvHistory;

    }


    public void setShowUvHistory(String showUvHistory) {
        /* 128 */
        this.showUvHistory = showUvHistory;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCdpAdvertiseReportQueryResponse
 * JD-Core Version:    0.6.0
 */