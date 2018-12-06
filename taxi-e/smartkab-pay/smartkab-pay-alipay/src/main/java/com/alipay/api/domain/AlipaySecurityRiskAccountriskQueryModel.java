package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskAccountriskQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4423578285536693386L;

    @ApiField("card_no")
    private String cardNo;

    @ApiField("card_type")
    private String cardType;

    @ApiField("mobile")
    private String mobile;

    @ApiField("scene_id")
    private String sceneId;

    @ApiField("user_id")
    private String userId;

    public String getCardNo() {
        /* 47 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 50 */
        this.cardNo = cardNo;
    }

    public String getCardType() {
        /* 54 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 57 */
        this.cardType = cardType;
    }

    public String getMobile() {
        /* 61 */
        return this.mobile;
    }

    public void setMobile(String mobile) {
        /* 64 */
        this.mobile = mobile;
    }

    public String getSceneId() {
        /* 68 */
        return this.sceneId;
    }

    public void setSceneId(String sceneId) {
        /* 71 */
        this.sceneId = sceneId;
    }

    public String getUserId() {
        /* 75 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 78 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySecurityRiskAccountriskQueryModel
 * JD-Core Version:    0.6.0
 */