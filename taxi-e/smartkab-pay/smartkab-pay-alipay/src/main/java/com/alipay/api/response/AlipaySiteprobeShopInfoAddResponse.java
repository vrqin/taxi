package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySiteprobeShopInfoAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 3152686282425137743L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @ApiField("shop_id")
    private String shopId;

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

    public String getShopId() {
        /* 53 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 50 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeShopInfoAddResponse
 * JD-Core Version:    0.6.0
 */