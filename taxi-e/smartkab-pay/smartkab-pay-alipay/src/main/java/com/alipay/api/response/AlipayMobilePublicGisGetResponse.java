package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMobilePublicGisGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 1259385669252454347L;


    @ApiField("accuracy")
    private String accuracy;


    @ApiField("city")
    private String city;


    @ApiField("code")
    private String code;


    @ApiField("latitude")
    private String latitude;


    @ApiField("longitude")
    private String longitude;


    @ApiField("msg")
    private String msg;


    @ApiField("province")
    private String province;


    public String getAccuracy() {
        /*  63 */
        return this.accuracy;

    }


    public void setAccuracy(String accuracy) {
        /*  60 */
        this.accuracy = accuracy;

    }


    public String getCity() {
        /*  70 */
        return this.city;

    }


    public void setCity(String city) {
        /*  67 */
        this.city = city;

    }


    public String getCode() {
        /*  77 */
        return this.code;

    }


    public void setCode(String code) {
        /*  74 */
        this.code = code;

    }


    public String getLatitude() {
        /*  84 */
        return this.latitude;

    }


    public void setLatitude(String latitude) {
        /*  81 */
        this.latitude = latitude;

    }


    public String getLongitude() {
        /*  91 */
        return this.longitude;

    }


    public void setLongitude(String longitude) {
        /*  88 */
        this.longitude = longitude;

    }


    public String getMsg() {
        /*  98 */
        return this.msg;

    }


    public void setMsg(String msg) {
        /*  95 */
        this.msg = msg;

    }


    public String getProvince() {
        /* 105 */
        return this.province;

    }


    public void setProvince(String province) {
        /* 102 */
        this.province = province;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicGisGetResponse
 * JD-Core Version:    0.6.0
 */