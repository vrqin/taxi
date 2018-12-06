package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipaySiteprobeUserInfoGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5265712151186472424L;


    @ApiField("adv_key")
    private String advKey;


    @ApiField("code")
    private String code;


    @ApiField("id_card")
    private String idCard;


    @ApiField("msg")
    private String msg;


    @ApiField("open_id_1")
    private String openId1;


    @ApiField("open_id_2")
    private String openId2;


    @ApiField("phone")
    private String phone;


    public String getAdvKey() {
        /*  63 */
        return this.advKey;

    }


    public void setAdvKey(String advKey) {
        /*  60 */
        this.advKey = advKey;

    }


    public String getCode() {
        /*  70 */
        return this.code;

    }


    public void setCode(String code) {
        /*  67 */
        this.code = code;

    }


    public String getIdCard() {
        /*  77 */
        return this.idCard;

    }


    public void setIdCard(String idCard) {
        /*  74 */
        this.idCard = idCard;

    }


    public String getMsg() {
        /*  84 */
        return this.msg;

    }


    public void setMsg(String msg) {
        /*  81 */
        this.msg = msg;

    }


    public String getOpenId1() {
        /*  91 */
        return this.openId1;

    }


    public void setOpenId1(String openId1) {
        /*  88 */
        this.openId1 = openId1;

    }


    public String getOpenId2() {
        /*  98 */
        return this.openId2;

    }


    public void setOpenId2(String openId2) {
        /*  95 */
        this.openId2 = openId2;

    }


    public String getPhone() {
        /* 105 */
        return this.phone;

    }


    public void setPhone(String phone) {
        /* 102 */
        this.phone = phone;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeUserInfoGetResponse
 * JD-Core Version:    0.6.0
 */