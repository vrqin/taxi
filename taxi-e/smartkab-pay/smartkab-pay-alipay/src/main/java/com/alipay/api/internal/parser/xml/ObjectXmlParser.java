package com.alipay.api.internal.parser.xml;

import com.alipay.api.*;
import com.alipay.api.internal.mapping.Converter;

public class ObjectXmlParser<T extends AlipayResponse> implements AlipayParser<T> {
    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        /* 21 */
        this.clazz = clazz;
    }

    public T parse(String rsp) throws AlipayApiException {
        /* 25 */
        Converter converter = new XmlConverter();
        /* 26 */
        return converter.toResponse(rsp, this.clazz);
    }

    public Class<T> getResponseClass() {
        /* 30 */
        return this.clazz;
    }

    public SignItem getSignItem(AlipayRequest<?> request, String responseBody) throws AlipayApiException {
        /* 39 */
        Converter converter = new XmlConverter();

        /* 41 */
        return converter.getSignItem(request, responseBody);
    }

    public String encryptSourceData(AlipayRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset)
            throws AlipayApiException {
        /* 51 */
        Converter converter = new XmlConverter();

        /* 53 */
        return converter.encryptSourceData(request, body, format, encryptType, encryptKey, charset);
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.parser.xml.ObjectXmlParser
 * JD-Core Version:    0.6.0
 */