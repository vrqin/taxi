package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicMessageLabelSendModel extends AlipayObject {
    private static final long serialVersionUID = 4615464278691213514L;

    @ApiField("filter")
    private Filter filter;

    @ApiField("material")
    private Material material;

    public Filter getFilter() {
        /* 29 */
        return this.filter;
    }

    public void setFilter(Filter filter) {
        /* 32 */
        this.filter = filter;
    }

    public Material getMaterial() {
        /* 36 */
        return this.material;
    }

    public void setMaterial(Material material) {
        /* 39 */
        this.material = material;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicMessageLabelSendModel
 * JD-Core Version:    0.6.0
 */