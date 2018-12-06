package com.speedtalk.smartkab.ws.test;

import com.speedtalk.smartkab.ws.domain.Response;
import com.speedtalk.smartkab.ws.domain.UserInfo;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RegisterUser {
    public static void main(String[] args) {
        UserInfo user = new UserInfo();
        user.setAccount("7");
        user.setPhone("");
        user.setName("李志兵");
        user.setGender(0);
        user.setPwd("1");

        MediaType mediaType = new MediaType("application", "json", "UTF-8");
        //							= MediaType.APPLICATION_JSON_TYPE;
        //		Entity<UserInfo> entity = Entity.entity(user,MediaType.APPLICATION_JSON_TYPE);
        System.out.println(mediaType.getSubtype() + "," + mediaType.getType() + "," + mediaType.toString());
        Entity<UserInfo> entity = Entity.entity(user, mediaType);
        System.out.println(entity.toString());
        Response resp = ClientTarget.getInstance()
                .getTarget()
                .path("user")
                .path("register")
                .request()
                .put(entity, Response.class);

        //		UserInfo info = new UserInfo();
        //		info.setAccount("111");
        //		info.setPhone("123");
        //		info.setName("11");
        //		info.setGender(1);
        //		Entity<UserInfo> entity = Entity.entity(info,MediaType.APPLICATION_JSON_TYPE);
        //		Response resp = ClientTarget.getInstance().getTarget().path("user").path("updateuser")
        //				.request().post(entity,Response.class);
        System.out.println(resp.getCode() + "," + resp.getDesc());
    }
}
