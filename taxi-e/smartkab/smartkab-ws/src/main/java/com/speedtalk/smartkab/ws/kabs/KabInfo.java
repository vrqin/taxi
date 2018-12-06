package com.speedtalk.smartkab.ws.kabs;

public class KabInfo {
    private String account;
    private String msId;
    private String name;
    private byte online;
    private byte carry;
    private double lg;
    private double lt;
    private int direction;
    private long time;
    private byte isApp;

    public KabInfo() {
        super();
    }

    public KabInfo(String account, String msId, String name, byte online, byte carry, double lg, double lt, int direction, long time, byte isApp) {
        super();
        this.account = account;
        this.msId = msId;
        this.name = name;
        this.online = online;
        this.carry = carry;
        this.lg = lg;
        this.lt = lt;
        this.direction = direction;
        this.time = time;
        this.isApp = isApp;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getOnline() {
        return online;
    }

    public void setOnline(byte online) {
        this.online = online;
    }

    public byte getCarry() {
        return carry;
    }

    public void setCarry(byte carry) {
        this.carry = carry;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public byte getIsApp() {
        return isApp;
    }

    public void setIsApp(byte isApp) {
        this.isApp = isApp;
    }

    @Override
    public String toString() {
        return "KabInfo [account=" + account + ", msId=" + msId + ", name=" + name + ", online=" + online + ", carry=" + carry + ", lg=" + lg + ", lt=" + lt + ", direction=" + direction + ", time=" + time + ", isApp=" + isApp + "]";
    }

}
