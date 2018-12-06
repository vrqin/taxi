package com.alipay.api;

import java.io.Serializable;

public class ResponseEncryptItem implements Serializable {
    private static final long serialVersionUID = 6680775791485372169L;
    private String respContent;
    private String realContent;

    public ResponseEncryptItem(String respContent, String realContent) {
        /* 36 */
        this.respContent = respContent;
        /* 37 */
        this.realContent = realContent;
    }

    public String getRespContent() {
        /* 46 */
        return this.respContent;
    }

    public String getRealContent() {
        /* 55 */
        return this.realContent;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.ResponseEncryptItem
 * JD-Core Version:    0.6.0
 */