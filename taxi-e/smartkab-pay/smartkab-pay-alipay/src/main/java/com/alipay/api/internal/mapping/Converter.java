package com.alipay.api.internal.mapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.SignItem;

public abstract interface Converter {
    public abstract <T extends AlipayResponse> T toResponse(String paramString, Class<T> paramClass)
            throws AlipayApiException;

    public abstract SignItem getSignItem(AlipayRequest<?> paramAlipayRequest, String paramString)
            throws AlipayApiException;

    public abstract String encryptSourceData(AlipayRequest<?> paramAlipayRequest, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
            throws AlipayApiException;
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.mapping.Converter
 * JD-Core Version:    0.6.0
 */