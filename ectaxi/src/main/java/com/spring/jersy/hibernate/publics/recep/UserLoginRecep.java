package com.spring.jersy.hibernate.publics.recep;

import javax.ws.rs.Consumes;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Administrator on 2016/9/12.
 */
@Consumes({"application/xml", "application/json"})
public class UserLoginRecep {
    private String username;
    private String password;
    private int cgflag;

    public UserLoginRecep() {
    }

    public UserLoginRecep(String username, String password, int cgflag) {
        this.username = username;
        this.password = password;
        this.cgflag = cgflag;
    }

    @XmlAttribute
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlAttribute
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlAttribute
    public int getCgflag() {
        return cgflag;
    }

    public void setCgflag(int cgflag) {
        this.cgflag = cgflag;
    }

    @Override
    public String toString() {
        return "UserLoginRecep{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", cgflag=" + cgflag + '}';
    }
}
