package com.speedtalk.smartkab.ws.domain;

public class Paramter {
    private byte code;
    private String desc;
    private String night;
    private String nightend;
    private String inimeter;
    private String dayiniprice;
    private String nightiniprice;
    private String dayincmeter;
    private String dayincprice;
    private String nightincmeter;
    private String nightincprice;
    private String highpricemeter;
    private String dayhighprice;
    private String nighthighprice;

    public Paramter() {
        super();
    }

    public Paramter(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Paramter(byte code, String desc, String night, String nightend, String inimeter, String dayiniprice, String nightiniprice, String dayincmeter, String dayincprice, String nightincmeter, String nightincprice, String highpricemeter, String dayhighprice, String nighthighprice) {
        this.code = code;
        this.desc = desc;
        this.night = night;
        this.nightend = nightend;
        this.inimeter = inimeter;
        this.dayiniprice = dayiniprice;
        this.nightiniprice = nightiniprice;
        this.dayincmeter = dayincmeter;
        this.dayincprice = dayincprice;
        this.nightincmeter = nightincmeter;
        this.nightincprice = nightincprice;
        this.highpricemeter = highpricemeter;
        this.dayhighprice = dayhighprice;
        this.nighthighprice = nighthighprice;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getNightend() {
        return nightend;
    }

    public void setNightend(String nightend) {
        this.nightend = nightend;
    }

    public String getInimeter() {
        return inimeter;
    }

    public void setInimeter(String inimeter) {
        this.inimeter = inimeter;
    }

    public String getDayiniprice() {
        return dayiniprice;
    }

    public void setDayiniprice(String dayiniprice) {
        this.dayiniprice = dayiniprice;
    }

    public String getNightiniprice() {
        return nightiniprice;
    }

    public void setNightiniprice(String nightiniprice) {
        this.nightiniprice = nightiniprice;
    }

    public String getDayincmeter() {
        return dayincmeter;
    }

    public void setDayincmeter(String dayincmeter) {
        this.dayincmeter = dayincmeter;
    }

    public String getDayincprice() {
        return dayincprice;
    }

    public void setDayincprice(String dayincprice) {
        this.dayincprice = dayincprice;
    }

    public String getNightincmeter() {
        return nightincmeter;
    }

    public void setNightincmeter(String nightincmeter) {
        this.nightincmeter = nightincmeter;
    }

    public String getNightincprice() {
        return nightincprice;
    }

    public void setNightincprice(String nightincprice) {
        this.nightincprice = nightincprice;
    }

    public String getHighpricemeter() {
        return highpricemeter;
    }

    public void setHighpricemeter(String highpricemeter) {
        this.highpricemeter = highpricemeter;
    }

    public String getDayhighprice() {
        return dayhighprice;
    }

    public void setDayhighprice(String dayhighprice) {
        this.dayhighprice = dayhighprice;
    }

    public String getNighthighprice() {
        return nighthighprice;
    }

    public void setNighthighprice(String nighthighprice) {
        this.nighthighprice = nighthighprice;
    }

    @Override
    public String toString() {
        return "Paramter [night=" + night + ", nightend=" + nightend + ", inimeter=" + inimeter + ", dayiniprice=" + dayiniprice + ", nightiniprice=" + nightiniprice + ", dayincmeter=" + dayincmeter + ", dayincprice=" + dayincprice + ", nightincmeter=" + nightincmeter + ", nightincprice=" + nightincprice + ", highpricemeter=" + highpricemeter + ", dayhighprice=" + dayhighprice + ", nighthighprice=" + nighthighprice + ", code=" + code + ", desc=" + desc + "]";
    }
}
