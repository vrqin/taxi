package com.speedtalk.smartkab.ws.test;

import com.speedtalk.smartkab.ws.domain.PwdInfo;
import com.speedtalk.smartkab.ws.domain.Response;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class UpdatePwd {
    public static void main(String[] args) {
        PwdInfo pwd = new PwdInfo();
        pwd.setAccount("111");
        pwd.setOldPwd("1");
        pwd.setNewPwd("2");
        Entity<PwdInfo> entity = Entity.entity(pwd, MediaType.APPLICATION_JSON_TYPE);
        Response resp = ClientTarget.getInstance()
                .getTarget()
                .path("user")
                .path("updatepwd")
                .request()
                .post(entity, Response.class);
        System.out.println(resp.getCode() + "," + resp.getDesc());

    }
}
