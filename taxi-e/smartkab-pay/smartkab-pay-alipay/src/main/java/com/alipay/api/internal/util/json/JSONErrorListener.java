package com.alipay.api.internal.util.json;

public abstract interface JSONErrorListener {
    public abstract void start(String paramString);

    public abstract void error(String paramString, int paramInt);

    public abstract void end();
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.JSONErrorListener
 * JD-Core Version:    0.6.0
 */