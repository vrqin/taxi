package com.speedtalk.smartkab.ws.domain;

import java.util.List;

public class OrderKabs {
    private String orderNum;
    private List<String> kabs;

    public OrderKabs() {
        // TODO Auto-generated constructor stub
    }

    public OrderKabs(String orderNum, List<String> kabs) {
        super();
        this.orderNum = orderNum;
        this.kabs = kabs;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public List<String> getKabs() {
        return kabs;
    }

    public void setKabs(List<String> kabs) {
        this.kabs = kabs;
    }
}
