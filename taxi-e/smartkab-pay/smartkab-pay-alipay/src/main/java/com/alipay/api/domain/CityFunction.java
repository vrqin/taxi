package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class CityFunction extends AlipayObject {
    private static final long serialVersionUID = 8753983851828425512L;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("city_name")
    private String cityName;

    @ApiListField("function_type")
    @ApiField("string")
    private List<String> functionType;

    public String getCityCode() {
        /* 39 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 42 */
        this.cityCode = cityCode;
    }

    public String getCityName() {
        /* 46 */
        return this.cityName;
    }

    public void setCityName(String cityName) {
        /* 49 */
        this.cityName = cityName;
    }

    public List<String> getFunctionType() {
        /* 53 */
        return this.functionType;
    }

    public void setFunctionType(List<String> functionType) {
        /* 56 */
        this.functionType = functionType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CityFunction
 * JD-Core Version:    0.6.0
 */