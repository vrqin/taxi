package com.speedtalk.order.engine.pay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.speedtalk.utils.LoadXmlConfig;

public class AliClient {
    private static AliClient instance = new AliClient();
    private static AlipayClient client;

    private AliClient() {
        client = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                //				"2016080901723758",
                LoadXmlConfig.getConfigHash().get("app_id"),
                //				"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM2kD5t6W3g3smHiilmTzAN3v/HIL5JZlaPrBXJWxytJWRL4jKY7XzQbd4z/HnNmWIkLucT30ZvH9M5L32q4lBHF717ceSEbkIncXcPbKU+v3/oey6aqoIpWevamkMeiLM79jTv6xx8z4u8QRPr4iTC9FMLizI38MHdKOSrIUDvDAgMBAAECgYASs4DX2uDGpgoK7Nc4HkDHb/R8wH/TB2KcbZspMssaHKmFGCVyWKPn0TemEu1qATy7+d0DFKZzTFPvDudahT6x1Vo02F9BfMcK5Hsy5pmzZHQJ1l0yh5gQWMrfaPebZ9AsHqwQ6gyXapQF4d8n6s4EGTW78iShr1eZ34qBIheFwQJBAOgU+jQ0ePDGHAJ7zLBq/OgbFHRrhMtM1HRfrgVgqVG/1HpCLHAUpP3QJMUWWtAW+xOMC9eQZ0LThcljATwWuNcCQQDi1XzxoKsWJojYlxT8KBLyDzGA1qTuVcZXJOWAPgTpL00IRIyzshIg9u/W0h0nKRCVhm6LYckWbhKHLWnzoJr1AkBrIDu52zq0EQ4ey1xZVpk03kMb1gFvAiDTMtMV4l9lv8FpSaBPgAgErI48dywl/2WXyT4yG5K+kvqfUdbhEK/zAkEAtZDBI//BMkfB/exg5b2F/K9gpoopFoUd758e/NmnwKcV9+o23ZdJn41JSSCCKVhbZ/RlA7hP515QAle9mT8TCQJAIMgt785LUxB2rigxj3XjJIbJCWG1pXpRa9QAHl2o6hzfjhVEp7d8miNjCyZK/OKP3P1dAMtzcaO1WvzeX0faNQ==",
                LoadXmlConfig.getConfigHash().get("ali_key"), "json", "utf-8", LoadXmlConfig.getConfigHash()
                .get("ali_pkey")
                //				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB"
        );
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
