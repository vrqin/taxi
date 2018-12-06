package com.spring.jersy.hibernate.publics.util;

import java.io.Serializable;

public class GpsEntity implements Serializable {
    private double latitude = 0;
    private double longitude = 0;

    public GpsEntity(double latitude, double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GpsEntity [latitude=" + latitude + ", longitude=" + longitude + "]";
    }

}
