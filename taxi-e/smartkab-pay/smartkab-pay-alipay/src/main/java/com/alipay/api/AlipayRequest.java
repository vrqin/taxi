package com.alipay.api;

import java.util.Map;

public abstract interface AlipayRequest<T extends AlipayResponse> {
    public abstract String getApiMethodName();

    public abstract Map<String, String> getTextParams();

    public abstract String getApiVersion();

    public abstract void setApiVersion(String paramString);

    public abstract String getTerminalType();

    public abstract void setTerminalType(String paramString);

    public abstract String getTerminalInfo();

    public abstract void setTerminalInfo(String paramString);

    public abstract String getProdCode();

    public abstract void setProdCode(String paramString);

    public abstract String getNotifyUrl();

    public abstract void setNotifyUrl(String paramString);

    public abstract String getReturnUrl();

    public abstract void setReturnUrl(String paramString);

    public abstract Class<T> getResponseClass();

    public abstract boolean isNeedEncrypt();

    public abstract void setNeedEncrypt(boolean paramBoolean);
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayRequest
 * JD-Core Version:    0.6.0
 */