package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/7/14.
 */
public class CallBussReport {

    private int total;       //总数
    private int unfinish;    //未完成
    private int cancellation;//取消
    private int finish;      //完成

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUnfinish() {
        return unfinish;
    }

    public void setUnfinish(int unfinish) {
        this.unfinish = unfinish;
    }

    public int getCancellation() {
        return cancellation;
    }

    public void setCancellation(int cancellation) {
        this.cancellation = cancellation;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
