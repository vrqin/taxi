package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransDishonorQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4314471637772297189L;

    @ApiField("dishonor_begin")
    private String dishonorBegin;

    @ApiField("dishonor_end")
    private String dishonorEnd;

    @ApiField("page")
    private String page;

    public String getDishonorBegin() {
        /* 41 */
        return this.dishonorBegin;
    }

    public void setDishonorBegin(String dishonorBegin) {
        /* 44 */
        this.dishonorBegin = dishonorBegin;
    }

    public String getDishonorEnd() {
        /* 48 */
        return this.dishonorEnd;
    }

    public void setDishonorEnd(String dishonorEnd) {
        /* 51 */
        this.dishonorEnd = dishonorEnd;
    }

    public String getPage() {
        /* 55 */
        return this.page;
    }

    public void setPage(String page) {
        /* 58 */
        this.page = page;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransDishonorQueryModel
 * JD-Core Version:    0.6.0
 */