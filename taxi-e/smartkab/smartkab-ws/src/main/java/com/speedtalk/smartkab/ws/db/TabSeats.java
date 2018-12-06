package com.speedtalk.smartkab.ws.db;

/**
 * TabSeats entity. @author MyEclipse Persistence Tools
 */
public class TabSeats implements java.io.Serializable {
    // Fields
    private Integer id;
    private String account;
    private String extensionnum;
    private String name;
    private String seatsnum;
    private String password;
    private Integer sex;
    private String opruser;
    private Integer clientid;

    // Constructors

    /**
     * default constructor
     */
    public TabSeats() {
    }

    /**
     * full constructor
     */
    public TabSeats(String account, String extensionnum, String name, String seatsnum, String password, Integer sex, String opruser, Integer clientid) {
        this.account = account;
        this.extensionnum = extensionnum;
        this.name = name;
        this.seatsnum = seatsnum;
        this.password = password;
        this.sex = sex;
        this.opruser = opruser;
        this.clientid = clientid;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getExtensionnum() {
        return this.extensionnum;
    }

    public void setExtensionnum(String extensionnum) {
        this.extensionnum = extensionnum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeatsnum() {
        return this.seatsnum;
    }

    public void setSeatsnum(String seatsnum) {
        this.seatsnum = seatsnum;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public Integer getClientid() {
        return this.clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
