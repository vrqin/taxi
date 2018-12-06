package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayDataItemGoodsList extends AlipayObject {
    private static final long serialVersionUID = 5168532187481688527L;

    @ApiField("desc")
    private String desc;

    @ApiListField("goods_list")
    @ApiField("string")
    private List<String> goodsList;

    public String getDesc() {
        /* 33 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 36 */
        this.desc = desc;
    }

    public List<String> getGoodsList() {
        /* 40 */
        return this.goodsList;
    }

    public void setGoodsList(List<String> goodsList) {
        /* 43 */
        this.goodsList = goodsList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataItemGoodsList
 * JD-Core Version:    0.6.0
 */