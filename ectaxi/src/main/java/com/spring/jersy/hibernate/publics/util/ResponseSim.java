package com.spring.jersy.hibernate.publics.util;


public class ResponseSim {
    private byte code;
    private String desc;

    public ResponseSim() {
        super();
    }

    public ResponseSim(byte code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
