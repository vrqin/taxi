package com.speedtalk.order.engine.setting;

public class CompanySetting {
    private int id;
    private int dropOrder;
    private int waitMinute;
    private String smsId;
    private String smsKey;
    private String smsCancelId;
    private int distance;
    private String areaCode;

    public CompanySetting(int id, int dropOrder, int waitMinute, String smsId, String smsKey, String smsCancelId, int distance, String areaCode) {
        super();
        this.id = id;
        this.dropOrder = dropOrder;
        this.waitMinute = waitMinute;
        this.smsId = smsId;
        this.smsKey = smsKey;
        this.smsCancelId = smsCancelId;
        this.distance = distance;
        this.areaCode = areaCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDropOrder() {
        return dropOrder;
    }

    public void setDropOrder(int dropOrder) {
        this.dropOrder = dropOrder;
    }

    public int getWaitMinute() {
        return waitMinute;
    }

    public void setWaitMinute(int waitMinute) {
        this.waitMinute = waitMinute;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getSmsKey() {
        return smsKey;
    }

    public void setSmsKey(String smsKey) {
        this.smsKey = smsKey;
    }

    public String getSmsCancelId() {
        return smsCancelId;
    }

    public void setSmsCancelId(String smsCancelId) {
        this.smsCancelId = smsCancelId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "CompanySetting [id=" + id + ", dropOrder=" + dropOrder + ", waitMinute=" + waitMinute + ", smsId=" + smsId + ", smsKey=" + smsKey + ", smsCancelId=" + smsCancelId + ", distance=" + distance + ", areaCode=" + areaCode + "]";
    }

}
