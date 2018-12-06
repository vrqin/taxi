package com.alipay.api;


import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.util.StringUtils;

import java.io.Serializable;
import java.util.Map;


public abstract class AlipayResponse implements Serializable {
    private static final long serialVersionUID = 5014379068811962022L;


    @ApiField("code")
    private String code;


    @ApiField("msg")
    private String msg;


    @ApiField("sub_code")
    private String subCode;


    @ApiField("sub_msg")
    private String subMsg;
    private String body;
    private Map<String, String> params;


    @Deprecated
    public String getErrorCode() {
        /*  40 */
        return getCode();

    }


    @Deprecated
    public void setErrorCode(String errorCode) {
        /*  50 */
        setCode(errorCode);

    }


    public String getCode() {
        /*  59 */
        return this.code;

    }


    public void setCode(String code) {
        /*  68 */
        this.code = code;

    }


    public String getMsg() {
        /*  72 */
        return this.msg;

    }


    public void setMsg(String msg) {
        /*  76 */
        this.msg = msg;

    }


    public String getSubCode() {
        /*  80 */
        return this.subCode;

    }


    public void setSubCode(String subCode) {
        /*  84 */
        this.subCode = subCode;

    }


    public String getSubMsg() {
        /*  88 */
        return this.subMsg;

    }


    public void setSubMsg(String subMsg) {
        /*  92 */
        this.subMsg = subMsg;

    }


    public String getBody() {
        /*  96 */
        return this.body;

    }


    public void setBody(String body) {
        /* 100 */
        this.body = body;

    }


    public Map<String, String> getParams() {
        /* 104 */
        return this.params;

    }


    public void setParams(Map<String, String> params) {
        /* 108 */
        this.params = params;

    }


    public boolean isSuccess() {
        /* 112 */
        return StringUtils.isEmpty(this.subCode);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayResponse
 * JD-Core Version:    0.6.0
 */