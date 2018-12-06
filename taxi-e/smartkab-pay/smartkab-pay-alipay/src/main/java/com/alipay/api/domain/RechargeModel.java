package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class RechargeModel extends AlipayObject {
    private static final long serialVersionUID = 3515149478592742588L;

    @ApiField("mobile_no_segment")
    private String mobileNoSegment;

    @ApiField("pay_send")
    private String paySend;

    @ApiListField("sale_products")
    @ApiField("sale_product")
    private List<SaleProduct> saleProducts;

    public String getMobileNoSegment() {
        /* 39 */
        return this.mobileNoSegment;
    }

    public void setMobileNoSegment(String mobileNoSegment) {
        /* 42 */
        this.mobileNoSegment = mobileNoSegment;
    }

    public String getPaySend() {
        /* 46 */
        return this.paySend;
    }

    public void setPaySend(String paySend) {
        /* 49 */
        this.paySend = paySend;
    }

    public List<SaleProduct> getSaleProducts() {
        /* 53 */
        return this.saleProducts;
    }

    public void setSaleProducts(List<SaleProduct> saleProducts) {
        /* 56 */
        this.saleProducts = saleProducts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RechargeModel
 * JD-Core Version:    0.6.0
 */