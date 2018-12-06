package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayAssetPointOrderCreateModel extends AlipayObject {
    private static final long serialVersionUID = 5888827138317583913L;

    @ApiField("memo")
    private String memo;

    @ApiField("merchant_order_no")
    private String merchantOrderNo;

    @ApiField("order_time")
    private Date orderTime;

    @ApiField("point_count")
    private Long pointCount;

    @ApiField("user_symbol")
    private String userSymbol;

    @ApiField("user_symbol_type")
    private String userSymbolType;

    public String getMemo() {
        /* 58 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 61 */
        this.memo = memo;
    }

    public String getMerchantOrderNo() {
        /* 65 */
        return this.merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 68 */
        this.merchantOrderNo = merchantOrderNo;
    }

    public Date getOrderTime() {
        /* 72 */
        return this.orderTime;
    }

    public void setOrderTime(Date orderTime) {
        /* 75 */
        this.orderTime = orderTime;
    }

    public Long getPointCount() {
        /* 79 */
        return this.pointCount;
    }

    public void setPointCount(Long pointCount) {
        /* 82 */
        this.pointCount = pointCount;
    }

    public String getUserSymbol() {
        /* 86 */
        return this.userSymbol;
    }

    public void setUserSymbol(String userSymbol) {
        /* 89 */
        this.userSymbol = userSymbol;
    }

    public String getUserSymbolType() {
        /* 93 */
        return this.userSymbolType;
    }

    public void setUserSymbolType(String userSymbolType) {
        /* 96 */
        this.userSymbolType = userSymbolType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAssetPointOrderCreateModel
 * JD-Core Version:    0.6.0
 */