package com.speedtalk.kabs;

public class KabInfo {
    private String Id;
    private byte online;
    private byte carry;
    private double lg;
    private double lt;
    private long time;

    public KabInfo() {
        super();
    }

    public KabInfo(String id, byte online, byte carry, double lg, double lt, long time) {
        super();
        Id = id;
        this.online = online;
        this.carry = carry;
        this.lg = lg;
        this.lt = lt;
        this.time = time;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
