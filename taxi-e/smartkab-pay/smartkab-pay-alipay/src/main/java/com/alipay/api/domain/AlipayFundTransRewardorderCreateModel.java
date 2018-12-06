package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayFundTransRewardorderCreateModel extends AlipayObject {
    private static final long serialVersionUID = 8457348912417212793L;


    @ApiField("amount")
    private String amount;


    @ApiField("ext_param")
    private String extParam;


    @ApiField("out_no")
    private String outNo;


    @ApiField("receiver_user_id")
    private String receiverUserId;


    @ApiField("scene")
    private String scene;


    @ApiField("sender_user_id")
    private String senderUserId;


    @ApiField("title")
    private String title;


    public String getAmount() {
        /*  59 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  62 */
        this.amount = amount;

    }


    public String getExtParam() {
        /*  66 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /*  69 */
        this.extParam = extParam;

    }


    public String getOutNo() {
        /*  73 */
        return this.outNo;

    }


    public void setOutNo(String outNo) {
        /*  76 */
        this.outNo = outNo;

    }


    public String getReceiverUserId() {
        /*  80 */
        return this.receiverUserId;

    }


    public void setReceiverUserId(String receiverUserId) {
        /*  83 */
        this.receiverUserId = receiverUserId;

    }


    public String getScene() {
        /*  87 */
        return this.scene;

    }


    public void setScene(String scene) {
        /*  90 */
        this.scene = scene;

    }


    public String getSenderUserId() {
        /*  94 */
        return this.senderUserId;

    }


    public void setSenderUserId(String senderUserId) {
        /*  97 */
        this.senderUserId = senderUserId;

    }


    public String getTitle() {
        /* 101 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 104 */
        this.title = title;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransRewardorderCreateModel
 * JD-Core Version:    0.6.0
 */