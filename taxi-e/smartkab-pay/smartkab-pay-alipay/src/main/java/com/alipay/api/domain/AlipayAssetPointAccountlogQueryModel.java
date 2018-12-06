package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayAssetPointAccountlogQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4276615366844576852L;


    @ApiField("account_date_begin")
    private Date accountDateBegin;


    @ApiField("account_date_end")
    private Date accountDateEnd;


    @ApiField("page_number")
    private Long pageNumber;


    @ApiField("page_size")
    private Long pageSize;


    @ApiListField("sub_trans_code")

    @ApiField("string")
    private List<String> subTransCode;


    @ApiListField("trans_code")

    @ApiField("string")
    private List<String> transCode;


    @ApiField("user_symbol")
    private String userSymbol;


    @ApiField("user_symbol_type")
    private String userSymbolType;


    public Date getAccountDateBegin() {
        /*  73 */
        return this.accountDateBegin;

    }


    public void setAccountDateBegin(Date accountDateBegin) {
        /*  76 */
        this.accountDateBegin = accountDateBegin;

    }


    public Date getAccountDateEnd() {
        /*  80 */
        return this.accountDateEnd;

    }


    public void setAccountDateEnd(Date accountDateEnd) {
        /*  83 */
        this.accountDateEnd = accountDateEnd;

    }


    public Long getPageNumber() {
        /*  87 */
        return this.pageNumber;

    }


    public void setPageNumber(Long pageNumber) {
        /*  90 */
        this.pageNumber = pageNumber;

    }


    public Long getPageSize() {
        /*  94 */
        return this.pageSize;

    }


    public void setPageSize(Long pageSize) {
        /*  97 */
        this.pageSize = pageSize;

    }


    public List<String> getSubTransCode() {
        /* 101 */
        return this.subTransCode;

    }


    public void setSubTransCode(List<String> subTransCode) {
        /* 104 */
        this.subTransCode = subTransCode;

    }


    public List<String> getTransCode() {
        /* 108 */
        return this.transCode;

    }


    public void setTransCode(List<String> transCode) {
        /* 111 */
        this.transCode = transCode;

    }


    public String getUserSymbol() {
        /* 115 */
        return this.userSymbol;

    }


    public void setUserSymbol(String userSymbol) {
        /* 118 */
        this.userSymbol = userSymbol;

    }


    public String getUserSymbolType() {
        /* 122 */
        return this.userSymbolType;

    }


    public void setUserSymbolType(String userSymbolType) {
        /* 125 */
        this.userSymbolType = userSymbolType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAssetPointAccountlogQueryModel
 * JD-Core Version:    0.6.0
 */