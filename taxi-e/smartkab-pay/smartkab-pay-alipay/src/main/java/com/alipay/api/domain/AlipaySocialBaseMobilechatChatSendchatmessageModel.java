package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipaySocialBaseMobilechatChatSendchatmessageModel extends AlipayObject {
    private static final long serialVersionUID = 6286156417357729777L;


    @ApiField("biz_memo")
    private String bizMemo;


    @ApiField("client_msg_id")
    private String clientMsgId;


    @ApiField("link")
    private String link;


    @ApiField("receiver_id")
    private String receiverId;


    @ApiField("receiver_usertype")
    private String receiverUsertype;


    @ApiField("template_data")
    private String templateData;


    @ApiField("template_type")
    private String templateType;


    public String getBizMemo() {
        /*  70 */
        return this.bizMemo;

    }


    public void setBizMemo(String bizMemo) {
        /*  73 */
        this.bizMemo = bizMemo;

    }


    public String getClientMsgId() {
        /*  77 */
        return this.clientMsgId;

    }


    public void setClientMsgId(String clientMsgId) {
        /*  80 */
        this.clientMsgId = clientMsgId;

    }


    public String getLink() {
        /*  84 */
        return this.link;

    }


    public void setLink(String link) {
        /*  87 */
        this.link = link;

    }


    public String getReceiverId() {
        /*  91 */
        return this.receiverId;

    }


    public void setReceiverId(String receiverId) {
        /*  94 */
        this.receiverId = receiverId;

    }


    public String getReceiverUsertype() {
        /*  98 */
        return this.receiverUsertype;

    }


    public void setReceiverUsertype(String receiverUsertype) {
        /* 101 */
        this.receiverUsertype = receiverUsertype;

    }


    public String getTemplateData() {
        /* 105 */
        return this.templateData;

    }


    public void setTemplateData(String templateData) {
        /* 108 */
        this.templateData = templateData;

    }


    public String getTemplateType() {
        /* 112 */
        return this.templateType;

    }


    public void setTemplateType(String templateType) {
        /* 115 */
        this.templateType = templateType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseMobilechatChatSendchatmessageModel
 * JD-Core Version:    0.6.0
 */