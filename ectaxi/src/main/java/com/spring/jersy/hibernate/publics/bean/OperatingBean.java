package com.spring.jersy.hibernate.publics.bean;

/**
 * 营运统计
 * Created by Administrator on 2016/8/11.
 */
public class OperatingBean {

    private String datetime; //    日期
    private int operatnum; //    总营运次数
    private Double operatmileage; //    总营运里程（公里）
    private Double operatduration; //    总营运时长（小时）
    private Double operatmoney; //    总营运金额（元）
    private Double singleoperatnum; //    单车日均营运次数
    private Double singleoperatmileage; //   单车日均营运里程
    private Double singleoperatduration; //   单车日均营运时长
    private Double singleoperatmoney; //    单车日均营运金额
    private int carnum;//接单车辆

    public int getCarnum() {
        return carnum;
    }

    public void setCarnum(int carnum) {
        this.carnum = carnum;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getOperatnum() {
        return operatnum;
    }

    public void setOperatnum(int operatnum) {
        this.operatnum = operatnum;
    }

    public Double getOperatmileage() {
        return operatmileage;
    }

    public void setOperatmileage(Double operatmileage) {
        this.operatmileage = operatmileage;
    }

    public Double getOperatduration() {
        return operatduration;
    }

    public void setOperatduration(Double operatduration) {
        this.operatduration = operatduration;
    }

    public Double getOperatmoney() {
        return operatmoney;
    }

    public void setOperatmoney(Double operatmoney) {
        this.operatmoney = operatmoney;
    }

    public Double getSingleoperatnum() {
        return singleoperatnum;
    }

    public void setSingleoperatnum(Double singleoperatnum) {
        this.singleoperatnum = singleoperatnum;
    }

    public Double getSingleoperatmileage() {
        return singleoperatmileage;
    }

    public void setSingleoperatmileage(Double singleoperatmileage) {
        this.singleoperatmileage = singleoperatmileage;
    }

    public Double getSingleoperatduration() {
        return singleoperatduration;
    }

    public void setSingleoperatduration(Double singleoperatduration) {
        this.singleoperatduration = singleoperatduration;
    }

    public Double getSingleoperatmoney() {
        return singleoperatmoney;
    }

    public void setSingleoperatmoney(Double singleoperatmoney) {
        this.singleoperatmoney = singleoperatmoney;
    }
}
