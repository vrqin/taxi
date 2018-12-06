package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class Data extends AlipayObject {
    private static final long serialVersionUID = 8652522571448814355L;

    @ApiListField("user_id_list")
    @ApiField("string")
    private List<String> userIdList;

    public List<String> getUserIdList() {
        /* 27 */
        return this.userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        /* 30 */
        this.userIdList = userIdList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Data
 * JD-Core Version:    0.6.0
 */