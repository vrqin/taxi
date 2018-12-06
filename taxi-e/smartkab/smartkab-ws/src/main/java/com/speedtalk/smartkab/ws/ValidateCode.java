package com.speedtalk.smartkab.ws;

public class ValidateCode {
    private String owner;
    private String code;
    private long time;

    public ValidateCode(String owner, String code, long time) {
        super();
        this.owner = owner;
        this.code = code;
        this.time = time;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
