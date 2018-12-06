package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class NewsfeedLocationInfo extends AlipayObject {
    private static final long serialVersionUID = 8279329528333775693L;

    @ApiField("ad_code")
    private String adCode;

    @ApiField("lat")
    private String lat;

    @ApiField("lon")
    private String lon;

    public String getAdCode() {
        /* 35 */
        return this.adCode;
    }

    public void setAdCode(String adCode) {
        /* 38 */
        this.adCode = adCode;
    }

    public String getLat() {
        /* 42 */
        return this.lat;
    }

    public void setLat(String lat) {
        /* 45 */
        this.lat = lat;
    }

    public String getLon() {
        /* 49 */
        return this.lon;
    }

    public void setLon(String lon) {
        /* 52 */
        this.lon = lon;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.NewsfeedLocationInfo
 * JD-Core Version:    0.6.0
 */