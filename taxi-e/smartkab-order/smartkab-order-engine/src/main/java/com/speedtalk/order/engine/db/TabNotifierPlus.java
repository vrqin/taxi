package com.speedtalk.order.engine.db;

import java.util.Date;

/**
 * TabNotifierPlus entity. @author MyEclipse Persistence Tools
 */
public class TabNotifierPlus implements java.io.Serializable {
    // Fields
    private Integer id;
    private String content;
    private Date expired;
    //	private Set<TabNotifierHistory> his;

    // Constructors

    /**
     * default constructor
     */
    public TabNotifierPlus() {
    }

    /**
     * minimal constructor
     */
    public TabNotifierPlus(Date expired) {
        this.expired = expired;
    }

    /**
     * full constructor
     */
    public TabNotifierPlus(Integer id, String content, Date expired) {
        super();
        this.id = id;
        this.content = content;
        this.expired = expired;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getExpired() {
        return this.expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }
    //	public Set<TabNotifierHistory> getHis()
    //	{
    //		return his;
    //	}
    //	public void setHis(Set<TabNotifierHistory> his)
    //	{
    //		this.his = his;
    //	}
}