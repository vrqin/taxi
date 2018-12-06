package com.alipay.api;

public abstract interface AlipayParser<T extends AlipayResponse> {
    public abstract T parse(String paramString) throws AlipayApiException;

    public abstract Class<T> getResponseClass() throws AlipayApiException;

    public abstract SignItem getSignItem(AlipayRequest<?> paramAlipayRequest, String paramString)
            throws AlipayApiException;

    public abstract String encryptSourceData(AlipayRequest<?> paramAlipayRequest, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws AlipayApiException;
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayParser
 * JD-Core Version:    0.6.0
 */