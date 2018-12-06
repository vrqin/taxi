package com.speedtalk.order.engine;

import com.speedtalk.order.engine.kabs.KabInfo;

public class DriverDistance {
    private KabInfo info;
    private double distance;

    public DriverDistance() {
    }

    public DriverDistance(KabInfo info, double distance) {
        super();
        this.info = info;
        this.distance = distance;
    }

    public KabInfo getInfo() {
        return info;
    }

    public void setInfo(KabInfo info) {
        this.info = info;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "DriverDistance [account=" + info.getAccount() + ", distance=" + distance + "]";
    }
}
