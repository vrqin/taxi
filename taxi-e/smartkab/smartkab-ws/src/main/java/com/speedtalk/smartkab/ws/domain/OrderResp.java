package com.speedtalk.smartkab.ws.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resp")
public class OrderResp {
    private byte code;
    private String desc;
    private String orderId;

    public OrderResp() {
        super();
    }

    @XmlAttribute
    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    @XmlAttribute
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlAttribute
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String OrderId) {
        this.orderId = OrderId;
    }

}
