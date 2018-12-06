package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class PidShopInfo extends AlipayObject {
    private static final long serialVersionUID = 7764894522166451617L;

    @ApiField("pid")
    private String pid;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    public String getPid() {
        /* 33 */
        return this.pid;
    }

    public void setPid(String pid) {
        /* 36 */
        this.pid = pid;
    }

    public List<String> getShopIds() {
        /* 40 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 43 */
        this.shopIds = shopIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PidShopInfo
 * JD-Core Version:    0.6.0
 */