package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/8/8.
 */
public class EvaluateBean {
    private int total;       //总数
    private int nosatisfaction;//不满意
    private int satisfaction;//满意
    private int goodsatisfaction; //非常满意
    private int notrated; //不做评价

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNosatisfaction() {
        return nosatisfaction;
    }

    public void setNosatisfaction(int nosatisfaction) {
        this.nosatisfaction = nosatisfaction;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getGoodsatisfaction() {
        return goodsatisfaction;
    }

    public void setGoodsatisfaction(int goodsatisfaction) {
        this.goodsatisfaction = goodsatisfaction;
    }

    public int getNotrated() {
        return notrated;
    }

    public void setNotrated(int notrated) {
        this.notrated = notrated;
    }
}
