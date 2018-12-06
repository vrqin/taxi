package com.speedtalk.smartkab.pay.ws.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.speedtalk.utils.LoadXmlConfig;

public class AliClient {
    private static AliClient instance = new AliClient();
    private static AlipayClient client;

    private AliClient() {
        client = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", LoadXmlConfig.getConfigHash()
                .get("app_id"), LoadXmlConfig.getConfigHash()
                .get("ali_key"), "json", "utf-8", LoadXmlConfig.getConfigHash().get("ali_pkey"));
    }

    public static AliClient getInstance() {
        if (null == instance)
            instance = new AliClient();
        return instance;
    }

    public AlipayClient getAlipayClient() {
        return client;
    }
}
