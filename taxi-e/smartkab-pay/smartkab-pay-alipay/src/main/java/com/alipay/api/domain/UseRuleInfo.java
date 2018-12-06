package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class UseRuleInfo extends AlipayObject {
    private static final long serialVersionUID = 7234642326411785245L;

    @ApiListField("suitable_shops")
    @ApiField("string")
    private List<String> suitableShops;

    @ApiListField("use_mode")
    @ApiField("string")
    private List<String> useMode;

    public List<String> getSuitableShops() {
        /* 34 */
        return this.suitableShops;
    }

    public void setSuitableShops(List<String> suitableShops) {
        /* 37 */
        this.suitableShops = suitableShops;
    }

    public List<String> getUseMode() {
        /* 41 */
        return this.useMode;
    }

    public void setUseMode(List<String> useMode) {
        /* 44 */
        this.useMode = useMode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.UseRuleInfo
 * JD-Core Version:    0.6.0
 */