package com.speedtalk.smartkab.ws.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resp")
public class UserResp {
    private byte code;
    private String desc;
    private String name;
    private byte gender;
    private String phone;

    public UserResp() {
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @XmlAttribute
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
