package com.speedtalk.smartkab.ws.kabs;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Distance> {
    @Override
    public int compare(Distance o1, Distance o2) {
        int isApp = o1.getKab().getIsApp() - o2.getKab().getIsApp();
        if (0 == isApp)
            return o1.getDistance().compareTo(o2.getDistance());
        return isApp;
    }
}
