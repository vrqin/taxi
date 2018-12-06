package com.speedtalk.smartkab.ws.domain;

public class Position {
    private String msId;
    private String kabName;
    private double lg;
    private double lt;
    private float speed;
    private float direction;
    private String pTime;
    private byte isCarry; //0:No,1:yes
    private byte isApp; //0:没装APP，1：装APP

    public Position() {
        // TODO Auto-generated constructor stub
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getKabName() {
        return kabName;
    }

    public void setKabName(String kabName) {
        this.kabName = kabName;
    }

    public double getLg() {
        return lg;
    }

    public void setLg(double lg) {
        this.lg = lg;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public byte getIsCarry() {
        return isCarry;
    }

    public void setIsCarry(byte isCarry) {
        this.isCarry = isCarry;
    }

    public byte getIsApp() {
        return isApp;
    }

    public void setIsApp(byte isApp) {
        this.isApp = isApp;
    }
}
