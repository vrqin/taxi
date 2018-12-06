package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMessageLabelSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 1535963567317525839L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @ApiField("msg_id")
    private String msgId;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getMsg() {
        /* 46 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 43 */
        this.msg = msg;
    }

    public String getMsgId() {
        /* 53 */
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        /* 50 */
        this.msgId = msgId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicMessageLabelSendResponse
 * JD-Core Version:    0.6.0
 */