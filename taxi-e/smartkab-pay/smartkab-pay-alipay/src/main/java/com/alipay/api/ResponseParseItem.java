package com.alipay.api;

import java.io.Serializable;

public class ResponseParseItem implements Serializable {
    private static final long serialVersionUID = -27707404159419651L;
    /* 20 */   private int startIndex = -1;

    /* 23 */   private int endIndex = -1;

    /* 26 */   private String encryptContent = null;

    public ResponseParseItem(int startIndex, int endIndex, String encryptContent) {
        /* 35 */
        this.startIndex = startIndex;
        /* 36 */
        this.endIndex = endIndex;
        /* 37 */
        this.encryptContent = encryptContent;
    }

    public int getStartIndex() {
        /* 46 */
        return this.startIndex;
    }

    public int getEndIndex() {
        /* 55 */
        return this.endIndex;
    }

    public String getEncryptContent() {
        /* 64 */
        return this.encryptContent;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.ResponseParseItem
 * JD-Core Version:    0.6.0
 */