package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPassInstanceAddModel extends AlipayObject {
    private static final long serialVersionUID = 1393816777225733624L;

    @ApiField("recognition_info")
    private String recognitionInfo;

    @ApiField("recognition_type")
    private String recognitionType;

    @ApiField("tpl_id")
    private String tplId;

    @ApiField("tpl_params")
    private String tplParams;

    public String getRecognitionInfo() {
        /* 42 */
        return this.recognitionInfo;
    }

    public void setRecognitionInfo(String recognitionInfo) {
        /* 45 */
        this.recognitionInfo = recognitionInfo;
    }

    public String getRecognitionType() {
        /* 49 */
        return this.recognitionType;
    }

    public void setRecognitionType(String recognitionType) {
        /* 52 */
        this.recognitionType = recognitionType;
    }

    public String getTplId() {
        /* 56 */
        return this.tplId;
    }

    public void setTplId(String tplId) {
        /* 59 */
        this.tplId = tplId;
    }

    public String getTplParams() {
        /* 63 */
        return this.tplParams;
    }

    public void setTplParams(String tplParams) {
        /* 66 */
        this.tplParams = tplParams;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPassInstanceAddModel
 * JD-Core Version:    0.6.0
 */