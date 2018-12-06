package com.speedtalk;

import org.apache.mina.core.session.IoSession;

import java.util.concurrent.atomic.AtomicInteger;

public class ClientInfo {
    private final static ClientInfo instance = new ClientInfo();
    private String msId;
    private String pwd;
    private int hbInterval;
    private boolean isLogin;
    private AtomicInteger messNo;
    private IoSession session;

    private ClientInfo() {
        this.hbInterval = 120;
        this.isLogin = false;
        this.messNo = new AtomicInteger(1);
    }

    public static ClientInfo getInstance() {
        return instance;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getHbInterval() {
        return hbInterval;
    }

    public void setHbInterval(int hbInterval) {
        this.hbInterval = hbInterval;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    /**
     * 指令流水号
     *
     * @return
     */
    public short getMessNo() {
        if (messNo.get() > Short.MAX_VALUE)
            messNo.set(1);
        return (short) messNo.getAndIncrement();
    }

    /**
     * 重新计算流水号
     *
     * @return
     */
    public short getFirstMessNo() {
        messNo.set(1);
        return (short) messNo.getAndIncrement();
    }
}
