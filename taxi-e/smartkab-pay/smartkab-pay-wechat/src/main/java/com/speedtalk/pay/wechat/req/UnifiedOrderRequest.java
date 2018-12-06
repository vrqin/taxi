package com.speedtalk.pay.wechat.req;

import com.speedtalk.pay.wechat.IRequest;
import com.speedtalk.pay.wechat.Requester;
import com.speedtalk.pay.wechat.Utils;
import com.speedtalk.pay.wechat.domin.WeChatPay;

import java.util.Map;
import java.util.TreeMap;

public class UnifiedOrderRequest implements IRequest {
    public Map<String, String> request(WeChatPay pay, String key) {
        String respStr = Requester.request(pay, "https://api.mch.weixin.qq.com/pay/unifiedorder", key);
        Map<String, String> map = new TreeMap<>();
        try {
            map = Utils.parseXmlStr(respStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
