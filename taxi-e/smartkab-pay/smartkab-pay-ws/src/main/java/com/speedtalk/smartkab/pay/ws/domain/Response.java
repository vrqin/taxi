package com.speedtalk.smartkab.pay.ws.domain;

public class Response {
    private String code;
    private String desc;

    public Response() {
    }

    public Response(String code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Response [code=" + code + ", desc=" + desc + "]";
    }
}
