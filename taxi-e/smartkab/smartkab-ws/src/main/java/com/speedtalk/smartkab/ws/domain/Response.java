package com.speedtalk.smartkab.ws.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resp")
public class Response {
    private byte code;
    private String desc;

    public Response() {
        super();
    }

    public Response(byte code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
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
}
