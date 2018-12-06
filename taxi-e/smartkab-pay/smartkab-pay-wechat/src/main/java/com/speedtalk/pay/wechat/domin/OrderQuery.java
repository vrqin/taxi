package com.speedtalk.pay.wechat.domin;

public class OrderQuery extends WeChatPay {
    private String out_trade_no;

    public OrderQuery() {
        // TODO Auto-generated constructor stub
    }

    public OrderQuery(String out_trade_no) {
        super();
        this.out_trade_no = out_trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
