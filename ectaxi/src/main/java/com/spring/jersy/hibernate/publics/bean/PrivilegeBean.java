package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/12/1.
 */
public class PrivilegeBean {
    private int clientid;
    private int callingss;
    private int enterprisebs;
    private int monitoringss;
    private int seatscc;
    private int servicees;
    private int comprehensiveas;
    private int dynamicis;
    private int operationsc;
    private String token;

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getCallingss() {
        return callingss;
    }

    public void setCallingss(int callingss) {
        this.callingss = callingss;
    }

    public int getEnterprisebs() {
        return enterprisebs;
    }

    public void setEnterprisebs(int enterprisebs) {
        this.enterprisebs = enterprisebs;
    }

    public int getMonitoringss() {
        return monitoringss;
    }

    public void setMonitoringss(int monitoringss) {
        this.monitoringss = monitoringss;
    }

    public int getSeatscc() {
        return seatscc;
    }

    public void setSeatscc(int seatscc) {
        this.seatscc = seatscc;
    }

    public int getServicees() {
        return servicees;
    }

    public void setServicees(int servicees) {
        this.servicees = servicees;
    }

    public int getComprehensiveas() {
        return comprehensiveas;
    }

    public void setComprehensiveas(int comprehensiveas) {
        this.comprehensiveas = comprehensiveas;
    }

    public int getDynamicis() {
        return dynamicis;
    }

    public void setDynamicis(int dynamicis) {
        this.dynamicis = dynamicis;
    }

    public int getOperationsc() {
        return operationsc;
    }

    public void setOperationsc(int operationsc) {
        this.operationsc = operationsc;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PrivilegeBean{" + "clientid=" + clientid + ", callingss=" + callingss + ", enterprisebs=" + enterprisebs + ", monitoringss=" + monitoringss + ", seatscc=" + seatscc + ", servicees=" + servicees + ", comprehensiveas=" + comprehensiveas + ", dynamicis=" + dynamicis + ", operationsc=" + operationsc + ", token='" + token + '\'' + '}';
    }
}
