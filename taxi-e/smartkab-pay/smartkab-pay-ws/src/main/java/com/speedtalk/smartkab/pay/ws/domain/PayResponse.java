package com.speedtalk.smartkab.pay.ws.domain;

public class PayResponse extends Response {
    private String paytype;
    private String amount;

    public PayResponse() {
        super();
    }

    public PayResponse(String code, String desc, String payType, String amount) {
        super(code, desc);
        this.paytype = payType;
        this.amount = amount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String payType) {
        this.paytype = payType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayResponse [paytype=" + paytype + ", amount=" + amount + ", getCode()=" + getCode() + ", getDesc()=" + getDesc() + "]";
    }
}
