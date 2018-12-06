package com.speedtalk.smartkab.ws.domain;

public class OrderStatus {
    private String orderNum;
    private String status;
    private String remark;

    public OrderStatus() {
        // TODO Auto-generated constructor stub
    }

    public OrderStatus(String orderNum, String status, String remark) {
        super();
        this.orderNum = orderNum;
        this.status = status;
        this.remark = remark;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
