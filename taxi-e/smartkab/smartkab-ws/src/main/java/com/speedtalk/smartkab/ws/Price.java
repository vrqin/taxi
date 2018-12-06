package com.speedtalk.smartkab.ws;

public class Price {
    private String status;
    private String type;
    private String night;
    private String nightPrice;
    private String day;
    private String dayPrice;

    public Price() {
        super();
        this.status = "0";
        this.type = "2";
    }

    public Price(String night, String nightPrice, String day, String dayPrice) {
        super();
        this.status = "0";
        this.type = "2";
        this.night = night;
        this.nightPrice = nightPrice;
        this.day = day;
        this.dayPrice = dayPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(String nightPrice) {
        this.nightPrice = nightPrice;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(String dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Price [status=" + status + ", type=" + type + ", night=" + night + ", nightPrice=" + nightPrice + ", day=" + day + ", dayPrice=" + dayPrice + "]";
    }
}
