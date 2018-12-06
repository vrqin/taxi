package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/19.
 */
@Entity
@Table(name = "tab_callbuss_stat")
public class CallBussStat implements Serializable {
    private int id;
    private int neworder;//新电召单数
    private int processingorder;//正在处理电召单数
    private int finishorder;//完成电召单数
    private int cancelorder;//取消电召单数
    private int outtimeorder;//超时电召单数
    private int allorder;    //所有电召单数
    private int neatnotcar; //附近没车数
    private int onlinecar;     //在线车辆
    private int offlinecar;   //离线车辆
    private Date time;   //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "neworder", length = 20)
    public int getNeworder() {
        return neworder;
    }

    public void setNeworder(int neworder) {
        this.neworder = neworder;
    }

    @Column(name = "processingorder", length = 20)
    public int getProcessingorder() {
        return processingorder;
    }

    public void setProcessingorder(int processingorder) {
        this.processingorder = processingorder;
    }

    @Column(name = "finishorder", length = 20)
    public int getFinishorder() {
        return finishorder;
    }

    public void setFinishorder(int finishorder) {
        this.finishorder = finishorder;
    }

    @Column(name = "cancelorder", length = 20)
    public int getCancelorder() {
        return cancelorder;
    }

    public void setCancelorder(int cancelorder) {
        this.cancelorder = cancelorder;
    }

    @Column(name = "outtimeorder", length = 20)
    public int getOuttimeorder() {
        return outtimeorder;
    }

    public void setOuttimeorder(int outtimeorder) {
        this.outtimeorder = outtimeorder;
    }

    @Column(name = "allorder", length = 20)
    public int getAllorder() {
        return allorder;
    }

    public void setAllorder(int allorder) {
        this.allorder = allorder;
    }

    @Column(name = "neatnotcar", length = 20)
    public int getNeatnotcar() {
        return neatnotcar;
    }

    public void setNeatnotcar(int neatnotcar) {
        this.neatnotcar = neatnotcar;
    }


    @Column(name = "onlinecar", length = 20)
    public int getOnlinecar() {
        return onlinecar;
    }

    public void setOnlinecar(int onlinecar) {
        this.onlinecar = onlinecar;
    }

    @Column(name = "offlinecar", length = 20)
    public int getOfflinecar() {
        return offlinecar;
    }

    public void setOfflinecar(int offlinecar) {
        this.offlinecar = offlinecar;
    }


    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", length = 50)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CallBussStat{" + "id=" + id + ", neworder=" + neworder + ", processingorder=" + processingorder + ", finishorder=" + finishorder + ", cancelorder=" + cancelorder + ", outtimeorder=" + outtimeorder + ", allorder=" + allorder + ", neatnotcar=" + neatnotcar + ", onlinecar=" + onlinecar + ", offlinecar=" + offlinecar + ", time=" + time + '}';
    }
}
