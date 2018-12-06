package com.spring.jersy.hibernate.publics.resp;

/**
 * Created by Administrator on 2016/9/11.
 */
public class BaseResp {
    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
