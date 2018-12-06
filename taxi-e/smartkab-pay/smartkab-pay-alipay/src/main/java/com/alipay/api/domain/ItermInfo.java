package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ItermInfo extends AlipayObject {
    private static final long serialVersionUID = 3621895754123249728L;

    @ApiField("error_message")
    private String errorMessage;

    @ApiField("is_for_sale")
    private String isForSale;

    @ApiField("item_code")
    private String itemCode;

    @ApiField("mark_price")
    private String markPrice;

    @ApiField("success")
    private Boolean success;

    @ApiField("supplier_price")
    private String supplierPrice;

    public String getErrorMessage() {
        /* 53 */
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        /* 56 */
        this.errorMessage = errorMessage;
    }

    public String getIsForSale() {
        /* 60 */
        return this.isForSale;
    }

    public void setIsForSale(String isForSale) {
        /* 63 */
        this.isForSale = isForSale;
    }

    public String getItemCode() {
        /* 67 */
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        /* 70 */
        this.itemCode = itemCode;
    }

    public String getMarkPrice() {
        /* 74 */
        return this.markPrice;
    }

    public void setMarkPrice(String markPrice) {
        /* 77 */
        this.markPrice = markPrice;
    }

    public Boolean getSuccess() {
        /* 81 */
        return this.success;
    }

    public void setSuccess(Boolean success) {
        /* 84 */
        this.success = success;
    }

    public String getSupplierPrice() {
        /* 88 */
        return this.supplierPrice;
    }

    public void setSupplierPrice(String supplierPrice) {
        /* 91 */
        this.supplierPrice = supplierPrice;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ItermInfo
 * JD-Core Version:    0.6.0
 */