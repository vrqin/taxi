package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransRewordorderQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3196185444361524275L;

    @ApiField("scene")
    private String scene;

    @ApiField("sender_user_id")
    private String senderUserId;

    @ApiField("transfer_no")
    private String transferNo;

    public String getScene() {
        /* 35 */
        return this.scene;
    }

    public void setScene(String scene) {
        /* 38 */
        this.scene = scene;
    }

    public String getSenderUserId() {
        /* 42 */
        return this.senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        /* 45 */
        this.senderUserId = senderUserId;
    }

    public String getTransferNo() {
        /* 49 */
        return this.transferNo;
    }

    public void setTransferNo(String transferNo) {
        /* 52 */
        this.transferNo = transferNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransRewordorderQueryModel
 * JD-Core Version:    0.6.0
 */