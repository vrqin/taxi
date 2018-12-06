package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class UseRule extends AlipayObject {
    private static final long serialVersionUID = 3688633875423438324L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("forbidden_time")
    private ForbbidenTime forbiddenTime;

    @ApiField("min_consume")
    private String minConsume;

    @ApiListField("suit_shops")
    @ApiField("string")
    private List<String> suitShops;

    @ApiListField("use_time")
    @ApiField("use_time")
    private List<UseTime> useTime;

    public String getExtInfo() {
        /* 55 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 58 */
        this.extInfo = extInfo;
    }

    public ForbbidenTime getForbiddenTime() {
        /* 62 */
        return this.forbiddenTime;
    }

    public void setForbiddenTime(ForbbidenTime forbiddenTime) {
        /* 65 */
        this.forbiddenTime = forbiddenTime;
    }

    public String getMinConsume() {
        /* 69 */
        return this.minConsume;
    }

    public void setMinConsume(String minConsume) {
        /* 72 */
        this.minConsume = minConsume;
    }

    public List<String> getSuitShops() {
        /* 76 */
        return this.suitShops;
    }

    public void setSuitShops(List<String> suitShops) {
        /* 79 */
        this.suitShops = suitShops;
    }

    public List<UseTime> getUseTime() {
        /* 83 */
        return this.useTime;
    }

    public void setUseTime(List<UseTime> useTime) {
        /* 86 */
        this.useTime = useTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.UseRule
 * JD-Core Version:    0.6.0
 */