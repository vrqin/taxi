package com.speedtalk.order.engine.pay;

import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.pay.wechat.Constants;
import com.speedtalk.pay.wechat.Requester;
import com.speedtalk.pay.wechat.Utils;
import com.speedtalk.pay.wechat.domin.UnifiedOrder;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.Map;
import java.util.TreeMap;

public class WeChatPay {
    public static Map<String, String> unifiedOrder(PayInfo payInfo) {
        KabInfo kabInfo = KabTeam.getInstance().getKab(payInfo.getSrcMsID());
        StringBuilder subject = new StringBuilder();
        subject.append("打车:" + kabInfo.getKabNum() + "-电话:" + kabInfo.getPhone());
        UnifiedOrder order = new UnifiedOrder();
        order.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
        order.setBody(subject.toString());
        order.setMch_id(LoadXmlConfig.getConfigHash().get("mch_id"));
        order.setNonce_str(Utils.getRandomNum(11));
        order.setNotify_url(LoadXmlConfig.getConfigHash().get("wechatpay_notify_url"));
        order.setOut_trade_no(payInfo.getOrderNum());
        order.setSpbill_create_ip("127.0.0.1");
        order.setTotal_fee(payInfo.getMoney());
        order.setTrade_type(Constants.NATIVE);
        String resp = Requester.request(order, "https://api.mch.weixin.qq.com/pay/unifiedorder", LoadXmlConfig.getConfigHash()
                .get("wechat_key"));
        //		OrderLogger.getLogger().debug("WeChat resp:" + resp);
        Map<String, String> map = new TreeMap<String, String>();
        try {
            map = Utils.parseXmlStr(resp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return map;
    }

    public static void main(String[] args) {
        UnifiedOrder order = new UnifiedOrder();
        order.setAppid("wx571538e0951f01ba");
        order.setBody("打车订单");
        order.setMch_id("1372470002");
        order.setNonce_str(Utils.getRandomNum(11));
        order.setNotify_url("http://121.201.6.34:10002/taxipay/wechatpay/async");
        order.setOut_trade_no("170622102141422");
        order.setSpbill_create_ip("127.0.0.1");
        order.setTotal_fee("1");
        order.setTrade_type(Constants.NATIVE);
        String resp = Requester.request(order, "https://api.mch.weixin.qq.com/pay/unifiedorder", "01DDF329FB531BA800D96E1C6FACE09A");
        System.out.println("WeChat resp:" + resp);
        Map<String, String> map = new TreeMap<String, String>();
        try {
            map = Utils.parseXmlStr(resp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
