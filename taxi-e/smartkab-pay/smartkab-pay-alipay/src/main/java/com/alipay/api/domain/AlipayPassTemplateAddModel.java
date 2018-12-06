package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassTemplateAddModel extends AlipayObject {
    private static final long serialVersionUID = 8347623867532293368L;

    @ApiField("tpl_content")
    private String tplContent;

    @ApiField("unique_id")
    private String uniqueId;

    public String getTplContent() {
        /* 29 */
        return this.tplContent;
    }

    public void setTplContent(String tplContent) {
        /* 32 */
        this.tplContent = tplContent;
    }

    public String getUniqueId() {
        /* 36 */
        return this.uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        /* 39 */
        this.uniqueId = uniqueId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPassTemplateAddModel
 * JD-Core Version:    0.6.0
 */