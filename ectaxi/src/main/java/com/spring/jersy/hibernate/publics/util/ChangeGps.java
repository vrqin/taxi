package com.spring.jersy.hibernate.publics.util;

public class ChangeGps {
    public static double pi = 3.1415926535897932384626;
    public static double a = 6378245.0;
    public static double ee = 0.00669342162296594323;

    /**
     * WGS-84 转 GCJ-02
     *
     * @param lat 纬度
     * @param lon 经度
     * @return
     */
    public static GpsEntity wgs84Togcj02(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new GpsEntity(lat, lon);
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new GpsEntity(mgLat, mgLon);
    }

    /**
     * GCJ-02 转 WGS-84
     *
     * @param lat
     * @param lon
     * @return
     */
    public static GpsEntity gcj02Towgs84(double lat, double lon) {
        GpsEntity gps = transform(lat, lon);
        double lontitude = lon * 2 - gps.getLongitude();
        double latitude = lat * 2 - gps.getLatitude();
        return new GpsEntity(latitude, lontitude);
    }

    /**
     * GCJ-02 转 bd09ll
     *
     * @param gg_lat
     * @param gg_lon
     * @return
     */
    public static GpsEntity gcj02Tobd09(double gg_lat, double gg_lon) {
        double x = gg_lon, y = gg_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
        double bd_lon = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        return new GpsEntity(bd_lat, bd_lon);
    }

    /**
     * bd9ll 转 GCJ-02
     *
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static GpsEntity bd09Togcj02(double bd_lat, double bd_lon) {
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
        double gg_lon = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        return new GpsEntity(gg_lat, gg_lon);
    }

    /**
     * bd09ll 转 WGS-84
     *
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static GpsEntity bd09Towgs84(double bd_lat, double bd_lon) {
        GpsEntity gcj02 = ChangeGps.bd09Togcj02(bd_lat, bd_lon);
        GpsEntity map84 = ChangeGps.gcj02Towgs84(gcj02.getLatitude(), gcj02.getLongitude());
        return map84;
    }

    /**
     * WGS-84 转 bd09ll
     *
     * @param wgs_lt
     * @param wgs_lg
     * @return
     */
    public static GpsEntity wgs84Tobd09(double wgs_lt, double wgs_lg) {
        GpsEntity gcj02 = ChangeGps.wgs84Togcj02(wgs_lt, wgs_lg);
        GpsEntity bd09 = ChangeGps.gcj02Tobd09(gcj02.getLatitude(), gcj02.getLongitude());
        return bd09;
    }

    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347)
            return true;
        if (lat < 0.8293 || lat > 55.8271)
            return true;
        return false;
    }

    public static GpsEntity transform(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new GpsEntity(lat, lon);
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new GpsEntity(mgLat, mgLon);
    }

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
        return ret;
    }

}
