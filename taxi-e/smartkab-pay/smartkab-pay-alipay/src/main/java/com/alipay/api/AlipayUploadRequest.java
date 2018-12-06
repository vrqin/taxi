package com.alipay.api;

import java.util.Map;

public abstract interface AlipayUploadRequest<T extends AlipayResponse> extends AlipayRequest<T> {
    public abstract Map<String, FileItem> getFileParams();
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayUploadRequest
 * JD-Core Version:    0.6.0
 */