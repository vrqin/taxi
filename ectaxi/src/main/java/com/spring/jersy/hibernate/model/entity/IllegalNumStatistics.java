package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 171.tab_illegal_num_statistics违章数量统计
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_illegal_num_statistics")
public class IllegalNumStatistics implements Serializable {
    private int id;
    private int illegaltype;//	int(4)			违章类型
    private int illegalnum;//	int(11)			违章次数
    private String illtime;//

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "illegaltype", length = 4)
    public int getIllegaltype() {
        return illegaltype;
    }

    public void setIllegaltype(int illegaltype) {
        this.illegaltype = illegaltype;
    }

    @Column(name = "illegalnum", length = 20)
    public int getIllegalnum() {
        return illegalnum;
    }

    public void setIllegalnum(int illegalnum) {
        this.illegalnum = illegalnum;
    }


    @Column(name = "getIlltime", length = 50)
    public String getIlltime() {
        return illtime;
    }

    public void setIlltime(String illtime) {
        this.illtime = illtime;
    }
}
