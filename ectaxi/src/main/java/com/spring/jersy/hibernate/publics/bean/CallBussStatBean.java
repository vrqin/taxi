package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/7/28.
 */
public class CallBussStatBean {

    private int neworder;
    private int processingorder;
    private int finishorder;
    private int cancelorder;
    private int outtimeorder;
    private int allorder;
    private int neatnotcar;

    public int getNeworder() {
        return neworder;
    }

    public void setNeworder(int neworder) {
        this.neworder = neworder;
    }

    public int getProcessingorder() {
        return processingorder;
    }

    public void setProcessingorder(int processingorder) {
        this.processingorder = processingorder;
    }

    public int getFinishorder() {
        return finishorder;
    }

    public void setFinishorder(int finishorder) {
        this.finishorder = finishorder;
    }

    public int getCancelorder() {
        return cancelorder;
    }

    public void setCancelorder(int cancelorder) {
        this.cancelorder = cancelorder;
    }

    public int getOuttimeorder() {
        return outtimeorder;
    }

    public void setOuttimeorder(int outtimeorder) {
        this.outtimeorder = outtimeorder;
    }

    public int getAllorder() {
        return allorder;
    }

    public void setAllorder(int allorder) {
        this.allorder = allorder;
    }

    public int getNeatnotcar() {
        return neatnotcar;
    }

    public void setNeatnotcar(int neatnotcar) {
        this.neatnotcar = neatnotcar;
    }
}
