package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class MaintainVehicleInfo extends AlipayObject {
    private static final long serialVersionUID = 6735668377298841196L;


    @ApiField("bg_url")
    private String bgUrl;


    @ApiField("engine_no")
    private String engineNo;


    @ApiField("engine_type")
    private String engineType;


    @ApiField("manufacturer")
    private String manufacturer;


    @ApiField("production_year")
    private String productionYear;


    @ApiListField("swept_volume")

    @ApiField("string")
    private List<String> sweptVolume;


    @ApiField("vi_brand_logo")
    private String viBrandLogo;


    @ApiField("vi_brand_name")
    private String viBrandName;


    @ApiField("vi_city_id")
    private String viCityId;


    @ApiField("vi_city_name")
    private String viCityName;


    @ApiField("vi_logo_url")
    private String viLogoUrl;


    @ApiField("vi_mileage")
    private String viMileage;


    @ApiField("vi_model_name")
    private String viModelName;


    @ApiField("vi_number")
    private String viNumber;


    @ApiField("vi_series_name")
    private String viSeriesName;


    @ApiField("vi_start_time")
    private Date viStartTime;


    @ApiField("vi_style_name")
    private String viStyleName;


    @ApiListField("vi_vin")

    @ApiField("string")
    private List<String> viVin;


    public String getBgUrl() {
        /* 131 */
        return this.bgUrl;

    }


    public void setBgUrl(String bgUrl) {
        /* 134 */
        this.bgUrl = bgUrl;

    }


    public String getEngineNo() {
        /* 138 */
        return this.engineNo;

    }


    public void setEngineNo(String engineNo) {
        /* 141 */
        this.engineNo = engineNo;

    }


    public String getEngineType() {
        /* 145 */
        return this.engineType;

    }


    public void setEngineType(String engineType) {
        /* 148 */
        this.engineType = engineType;

    }


    public String getManufacturer() {
        /* 152 */
        return this.manufacturer;

    }


    public void setManufacturer(String manufacturer) {
        /* 155 */
        this.manufacturer = manufacturer;

    }


    public String getProductionYear() {
        /* 159 */
        return this.productionYear;

    }


    public void setProductionYear(String productionYear) {
        /* 162 */
        this.productionYear = productionYear;

    }


    public List<String> getSweptVolume() {
        /* 166 */
        return this.sweptVolume;

    }


    public void setSweptVolume(List<String> sweptVolume) {
        /* 169 */
        this.sweptVolume = sweptVolume;

    }


    public String getViBrandLogo() {
        /* 173 */
        return this.viBrandLogo;

    }


    public void setViBrandLogo(String viBrandLogo) {
        /* 176 */
        this.viBrandLogo = viBrandLogo;

    }


    public String getViBrandName() {
        /* 180 */
        return this.viBrandName;

    }


    public void setViBrandName(String viBrandName) {
        /* 183 */
        this.viBrandName = viBrandName;

    }


    public String getViCityId() {
        /* 187 */
        return this.viCityId;

    }


    public void setViCityId(String viCityId) {
        /* 190 */
        this.viCityId = viCityId;

    }


    public String getViCityName() {
        /* 194 */
        return this.viCityName;

    }


    public void setViCityName(String viCityName) {
        /* 197 */
        this.viCityName = viCityName;

    }


    public String getViLogoUrl() {
        /* 201 */
        return this.viLogoUrl;

    }


    public void setViLogoUrl(String viLogoUrl) {
        /* 204 */
        this.viLogoUrl = viLogoUrl;

    }


    public String getViMileage() {
        /* 208 */
        return this.viMileage;

    }


    public void setViMileage(String viMileage) {
        /* 211 */
        this.viMileage = viMileage;

    }


    public String getViModelName() {
        /* 215 */
        return this.viModelName;

    }


    public void setViModelName(String viModelName) {
        /* 218 */
        this.viModelName = viModelName;

    }


    public String getViNumber() {
        /* 222 */
        return this.viNumber;

    }


    public void setViNumber(String viNumber) {
        /* 225 */
        this.viNumber = viNumber;

    }


    public String getViSeriesName() {
        /* 229 */
        return this.viSeriesName;

    }


    public void setViSeriesName(String viSeriesName) {
        /* 232 */
        this.viSeriesName = viSeriesName;

    }


    public Date getViStartTime() {
        /* 236 */
        return this.viStartTime;

    }


    public void setViStartTime(Date viStartTime) {
        /* 239 */
        this.viStartTime = viStartTime;

    }


    public String getViStyleName() {
        /* 243 */
        return this.viStyleName;

    }


    public void setViStyleName(String viStyleName) {
        /* 246 */
        this.viStyleName = viStyleName;

    }


    public List<String> getViVin() {
        /* 250 */
        return this.viVin;

    }


    public void setViVin(List<String> viVin) {
        /* 253 */
        this.viVin = viVin;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MaintainVehicleInfo
 * JD-Core Version:    0.6.0
 */