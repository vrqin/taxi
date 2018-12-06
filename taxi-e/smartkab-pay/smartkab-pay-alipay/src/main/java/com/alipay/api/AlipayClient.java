package com.alipay.api;

public interface AlipayClient {
    <T extends AlipayResponse> T execute(AlipayRequest<T> paramAlipayRequest) throws AlipayApiException;

    <T extends AlipayResponse> T execute(AlipayRequest<T> paramAlipayRequest, String paramString)
            throws AlipayApiException;

    <T extends AlipayResponse> T execute(AlipayRequest<T> paramAlipayRequest, String paramString1, String paramString2)
            throws AlipayApiException;

    <T extends AlipayResponse> T pageExecute(AlipayRequest<T> paramAlipayRequest) throws AlipayApiException;

    <T extends AlipayResponse> T pageExecute(AlipayRequest<T> paramAlipayRequest, String paramString)
            throws AlipayApiException;
}

