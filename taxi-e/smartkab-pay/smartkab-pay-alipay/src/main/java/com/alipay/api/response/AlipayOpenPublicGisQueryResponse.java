package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicGisQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8894698627218145337L;

    @ApiField("accuracy")
    private String accuracy;

    @ApiField("city")
    private String city;

    @ApiField("latitude")
    private String latitude;

    @ApiField("longitude")
    private String longitude;

    @ApiField("province")
    private String province;

    public String getAccuracy() {
        /* 51 */
        return this.accuracy;
    }

    public void setAccuracy(String accuracy) {
        /* 48 */
        this.accuracy = accuracy;
    }

    public String getCity() {
        /* 58 */
        return this.city;
    }

    public void setCity(String city) {
        /* 55 */
        this.city = city;
    }

    public String getLatitude() {
        /* 65 */
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        /* 62 */
        this.latitude = latitude;
    }

    public String getLongitude() {
        /* 72 */
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        /* 69 */
        this.longitude = longitude;
    }

    public String getProvince() {
        /* 79 */
        return this.province;
    }

    public void setProvince(String province) {
        /* 76 */
        this.province = province;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicGisQueryResponse
 * JD-Core Version:    0.6.0
 */