package com.speedtalk.smartkab.pay.ws.db;


/**
 * TabPhoneuser entity. @author MyEclipse Persistence Tools
 */
public class TabPhoneuser implements java.io.Serializable {
    private static final long serialVersionUID = 2397855044631302405L;
    // Fields
    private String opruser;
    //	private String name;
    //	private Integer sex;
    private String password;
    //	private String idcard;
    //	private String mobile;
    //	private Timestamp createdate;
    //	private String address;
    //	private String remark;
    //	private Timestamp curtime;
    private String openId;
    //	private Integer islock;
    //	private Integer type;

    // Constructors

    /**
     * default constructor
     */
    public TabPhoneuser() {
    }

    /**
     * full constructor
     */
    public TabPhoneuser(String opruser,/*TabEnterpriseInfo tabEnterpriseInfo,String name,Integer sex,*/
                        String password,/*String idcard,String mobile,Timestamp createdate,String address,
			String remark,Timestamp curtime,*/String openId/*,Integer islock,Integer type*/) {
        this.opruser = opruser;
        //		this.tabEnterpriseInfo = tabEnterpriseInfo;
        //		this.name = name;
        //		this.sex = sex;
        this.password = password;
        //		this.idcard = idcard;
        //		this.mobile = mobile;
        //		this.createdate = createdate;
        //		this.address = address;
        //		this.remark = remark;
        //		this.curtime = curtime;
        this.openId = openId;
        //		this.islock = islock;
        //		this.type = type;
    }

    // Property accessors
    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    //	public TabEnterpriseInfo getTabEnterpriseInfo()
    //	{
    //		return this.tabEnterpriseInfo;
    //	}
    //	public void setTabEnterpriseInfo(TabEnterpriseInfo tabEnterpriseInfo)
    //	{
    //		this.tabEnterpriseInfo = tabEnterpriseInfo;
    //	}
    //	public String getName()
    //	{
    //		return this.name;
    //	}
    //	public void setName(String name)
    //	{
    //		this.name = name;
    //	}
    //	public Integer getSex()
    //	{
    //		return this.sex;
    //	}
    //	public void setSex(Integer sex)
    //	{
    //		this.sex = sex;
    //	}
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //	public String getIdcard()
    //	{
    //		return this.idcard;
    //	}
    //	public void setIdcard(String idcard)
    //	{
    //		this.idcard = idcard;
    //	}
    //	public String getMobile()
    //	{
    //		return this.mobile;
    //	}
    //	public void setMobile(String mobile)
    //	{
    //		this.mobile = mobile;
    //	}
    //	public Timestamp getCreatedate()
    //	{
    //		return this.createdate;
    //	}
    //	public void setCreatedate(Timestamp createdate)
    //	{
    //		this.createdate = createdate;
    //	}
    //	public String getAddress()
    //	{
    //		return this.address;
    //	}
    //	public void setAddress(String address)
    //	{
    //		this.address = address;
    //	}
    //	public String getRemark()
    //	{
    //		return this.remark;
    //	}
    //	public void setRemark(String remark)
    //	{
    //		this.remark = remark;
    //	}
    //	public Timestamp getCurtime()
    //	{
    //		return this.curtime;
    //	}
    //	public void setCurtime(Timestamp curtime)
    //	{
    //		this.curtime = curtime;
    //	}
    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    //	public Integer getIslock()
    //	{
    //		return this.islock;
    //	}
    //	public void setIslock(Integer islock)
    //	{
    //		this.islock = islock;
    //	}
    //	public Integer getType()
    //	{
    //		return this.type;
    //	}
    //	public void setType(Integer type)
    //	{
    //		this.type = type;
    //	}
}
