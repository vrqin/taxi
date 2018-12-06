package com.speedtalk.order.engine.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.speedtalk.order.engine.OrderNumUtils;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.order.objs.PayInfo;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

public class AlipayPrecreate {
    public static AlipayTradePrecreateResponse precreate(PayInfo payInfo) {
        KabInfo kabInfo = KabTeam.getInstance().getKab(payInfo.getSrcMsID());
        String money = "";
        try {
            money = OrderNumUtils.format(Float.parseFloat(payInfo.getMoney()) / 100f, 2);
        } catch (Exception e) {
        }
        StringBuilder subject = new StringBuilder();
        subject.append("打车:" + kabInfo.getKabNum() + "-电话:" + kabInfo.getPhone());
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizContent("{" + "\"out_trade_no\":\"" + payInfo.getOrderNum() + "\"," + "\"total_amount\":" + money + ",\"subject\":\"" + subject
                .toString() + "\"," + "\"timeout_express\":\"30m\"}");
        request.setNotifyUrl(LoadXmlConfig.getConfigHash().get("alipay_notify_url"));
        try {
            AlipayTradePrecreateResponse response = AliClient.getInstance().getAlipayClient().execute(request);
            return response;
        } catch (AlipayApiException e) {
            ExcepPrinter.print(e);
        }
        return null;
    }
}
