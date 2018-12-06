package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceCodeRecoModel extends AlipayObject {
    private static final long serialVersionUID = 6676163259226739596L;

    @ApiField("config")
    private String config;

    @ApiField("content")
    private String content;

    @ApiField("strategy")
    private String strategy;

    public String getConfig() {
        /* 35 */
        return this.config;
    }

    public void setConfig(String config) {
        /* 38 */
        this.config = config;
    }

    public String getContent() {
        /* 42 */
        return this.content;
    }

    public void setContent(String content) {
        /* 45 */
        this.content = content;
    }

    public String getStrategy() {
        /* 49 */
        return this.strategy;
    }

    public void setStrategy(String strategy) {
        /* 52 */
        this.strategy = strategy;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataDataserviceCodeRecoModel
 * JD-Core Version:    0.6.0
 */