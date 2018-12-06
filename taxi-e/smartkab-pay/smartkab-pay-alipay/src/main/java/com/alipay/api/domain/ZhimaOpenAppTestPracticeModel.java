package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ZhimaOpenAppTestPracticeModel extends AlipayObject {
    private static final long serialVersionUID = 6192951367869677344L;

    @ApiListField("add")
    @ApiField("string")
    private List<String> add;

    @ApiField("xxxx")
    private XXXXsdasdasd xxxx;

    public List<String> getAdd() {
        /* 33 */
        return this.add;
    }

    public void setAdd(List<String> add) {
        /* 36 */
        this.add = add;
    }

    public XXXXsdasdasd getXxxx() {
        /* 40 */
        return this.xxxx;
    }

    public void setXxxx(XXXXsdasdasd xxxx) {
        /* 43 */
        this.xxxx = xxxx;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ZhimaOpenAppTestPracticeModel
 * JD-Core Version:    0.6.0
 */