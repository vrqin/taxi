package com.speedtalk.order.engine.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.speedtalk.utils.ExcepPrinter;

public class AliQuery {
    public static AlipayTradeQueryResponse query(String orderNum) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" + "\"out_trade_no\":\"" + orderNum + "\"}");
        try {
            AlipayTradeQueryResponse response = AliClient.getInstance().getAlipayClient().execute(request);
            // System.out.println("Body:" + response.getBody());
            // System.out.println("Code:" + response.getCode());
            // System.out.println("Sub_msg:" + response.getSubMsg());
            // System.out.println("Msg:" + response.getMsg());
            // System.out.println("Out_trade_no:" + response.getOutTradeNo());
            // System.out.println("Trade_no:" + response.getTradeNo());
            // System.out.println("Buyer_pay_amount:" + response.getBuyerPayAmount());
            // System.out.println("Invoice_amount:" + response.getInvoiceAmount());
            // System.out.println("Point_amount:" + response.getPointAmount());
            // System.out.println("Receipt_amount:" + response.getReceiptAmount());
            // System.out.println("Buyer_logon_id:" + response.getBuyerLogonId());
            // System.out.println("Trade_status:" + response.getTradeStatus());
            return response;
        } catch (AlipayApiException e) {
            ExcepPrinter.print(e);
        }
        return null;
    }
}
