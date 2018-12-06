package com.speedtalk.pay.wechat;

import com.speedtalk.pay.wechat.domin.WeChatPay;

import java.util.Map;

public interface IRequest {
    Map<String, String> request(WeChatPay pay, String key);
}
