package com.speedtalk.order.engine.kabs;

import com.speedtalk.order.engine.setting.Companys;
import com.speedtalk.protocol.utils.DateUtils;
import org.apache.mina.core.session.IoSession;

public class KabInfo {
    private int id;
    private String account;
    private String msId;
    private String name;
    private String kabNum;
    private byte online;
    private byte carry;
    private double lg;
    private double lt;
    private long time;
    private byte isstop;
    private String iccard;
    private String phone;
    private IoSession session;
    private int clientId;
    private int remain;
    //	private int dropmax;	//可以取消单的最大数
    private int dropCount;    //已取消单数
    //	private int waitminute;	//当达到dropmax将被禁止接单的时长
    private long startWait;    //被禁止接单的开始等待时间
    private boolean isCanAcceptOrder;

    public KabInfo() {
        super();
        this.isCanAcceptOrder = true;
    }

    public KabInfo(String account, String msId, String name, String kabNum, byte online, byte carry, double lg, double lt, long time, byte isstop, String iccard, String phone, int clientId, int remain) {
        super();
        this.account = account;
        this.msId = msId;
        this.name = name;
        this.kabNum = kabNum;
        this.online = online;
        this.carry = carry;
        this.lg = lg;
        this.lt = lt;
        this.time = time;
        this.isstop = isstop;
        this.iccard = iccard;
        this.phone = phone;
        this.clientId = clientId;
        this.remain = remain;
        this.isCanAcceptOrder = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKabNum() {
        return kabNum;
    }

    public void setKabNum(String kabNum) {
        this.kabNum = kabNum;
    }

    public byte getOnline() {
        return online;
    }

    public void setOnline(byte online) {
        this.online = online;
    }

    public byte getCarry() {
        return carry;
    }

    public void setCarry(byte carry) {
        this.carry = carry;
    }

    public double getLg() {
        return lg;
    }

    public void setLg(double lg) {
        this.lg = lg;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public byte getIsstop() {
        return isstop;
    }

    public void setIsstop(byte isstop) {
        this.isstop = isstop;
    }

    public String getIccard() {
        return iccard;
    }

    public void setIccard(String iccard) {
        this.iccard = iccard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    public String getSessionInfo() {
        return null == session ? "" : session.getId() + ":" + session.getRemoteAddress();
    }

    //	public int getDropmax()
    //	{
    //		return dropmax;
    //	}
    //	public void setDropmax(int dropmax)
    //	{
    //		this.dropmax = dropmax;
    //	}
    public int getDropcount() {
        return dropCount;
    }

    public void setDropcount(int dropcount) {
        this.dropCount = dropcount;
    }

    //	public int getWaitminute()
    //	{
    //		return waitminute;
    //	}
    //	public void setWaitminute(int waitminute)
    //	{
    //		this.waitminute = waitminute;
    //	}
    public long getStartwait() {
        return startWait;
    }

    public void clearWaitStatus() {
        dropCount = 0;
        startWait = 0;
        isCanAcceptOrder = true;
    }

    public void expandDropCount() {
        startWait = 0;
        isCanAcceptOrder = true;
    }

    public boolean isCanAcceptOrder() {
        return isCanAcceptOrder;
    }

    public void setCanAcceptOrder(boolean isCanAcceptOrder) {
        this.isCanAcceptOrder = isCanAcceptOrder;
    }

    public void dropOrder() {
        dropCount += 1;
        try {
            int dropmax = Companys.getInstance().getSetting(clientId).getDropOrder();
            if (dropCount >= dropmax) {
                if (startWait == 0)
                    startWait = System.currentTimeMillis();
                isCanAcceptOrder = false;
            }
        } catch (Exception e) {
        }
    }

    //	@Override
    //	public String toString()
    //	{
    //		return "KabInfo [id="+id+",account="+account+", msId="+msId+", name="+name+", kabNum="+kabNum+", online="+online
    //				+", carry="+carry+", lg="+lg+", lt="+lt+", time="+time+", isstop="+isstop+", iccard="+iccard
    //				+", phone="+phone+", clientId="+clientId+", remain="+remain+", session="+getSessionInfo()+"]";
    //	}
    @Override
    public String toString() {
        return "KabInfo [id=" + id + ", account=" + account + ", msId=" + msId + ", name=" + name + ", kabNum=" + kabNum + ", online=" + online + ", carry=" + carry + ", lg=" + lg + ", lt=" + lt + ", time=" + time + ", isstop=" + isstop + ", iccard=" + iccard + ", phone=" + phone + ", clientId=" + clientId + ", remain=" + remain + ", dropcount=" + dropCount + ", startwait=" + DateUtils
                .getCommonTimeFormat()
                .format(startWait) + ", isCanAcceptOrder=" + isCanAcceptOrder + ", session=" + getSessionInfo() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KabInfo other = (KabInfo) obj;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        return true;
    }

}
