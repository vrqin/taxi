package com.speedtalk.smartkab.score.ws.domain;

public class ScoreHis {
    private String ordernum;
    private int score;
    private String time;
    private String remark;

    public ScoreHis() {
        super();
    }

    public ScoreHis(String ordernum, int score, String time, String remark) {
        super();
        this.ordernum = ordernum;
        this.score = score;
        this.time = time;
        this.remark = remark;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
