package com.speedtalk.client;

import org.apache.mina.core.session.IoSession;

public class ClientInfo {
    private static ClientInfo instance = new ClientInfo();
    private IoSession session;
    private String serverIp;
    private int serverPort;
    private String id;
    private String name;
    private String pwd;

    private ClientInfo() {
        id = "undefine";
        name = "undefine";
        pwd = "undefine";
    }

    public static ClientInfo getInstance() {
        return instance;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public void setServerInfo(String ip, int port) {
        this.serverIp = ip;
        this.serverPort = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setClientInfo(String account, String name, String pwd) {
        this.id = account;
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "ClientInfo [serverIp=" + serverIp + ", serverPort=" + serverPort + ", id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
    }
}
