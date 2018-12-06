package com.speedtalk.smartkab.ws.domain;

public class AcceptOrder {
    private String account;
    private String orderNum;
    private String msId;
    private String kabNum;
    private String acceptTime;

    public AcceptOrder() {
        // TODO Auto-generated constructor stub
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getKabNum() {
        return kabNum;
    }

    public void setKabNum(String kabNum) {
        this.kabNum = kabNum;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }
}
