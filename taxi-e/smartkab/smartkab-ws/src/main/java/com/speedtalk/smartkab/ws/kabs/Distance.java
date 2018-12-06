package com.speedtalk.smartkab.ws.kabs;

public class Distance {
    private KabInfo kab;
    private Double distance;

    public Distance(KabInfo kab, Double distance) {
        super();
        this.kab = kab;
        this.distance = distance;
    }

    public KabInfo getKab() {
        return kab;
    }

    public void setKab(KabInfo kab) {
        this.kab = kab;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
