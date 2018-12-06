package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassTemplateUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 7122626784675813838L;

    @ApiField("tpl_content")
    private String tplContent;

    @ApiField("tpl_id")
    private String tplId;

    public String getTplContent() {
        /* 29 */
        return this.tplContent;
    }

    public void setTplContent(String tplContent) {
        /* 32 */
        this.tplContent = tplContent;
    }

    public String getTplId() {
        /* 36 */
        return this.tplId;
    }

    public void setTplId(String tplId) {
        /* 39 */
        this.tplId = tplId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPassTemplateUpdateModel
 * JD-Core Version:    0.6.0
 */