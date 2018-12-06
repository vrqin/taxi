package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiItemExtitemExistedQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7165473885489289568L;

    @ApiListField("existed_list")
    @ApiField("string")
    private List<String> existedList;

    public List<String> getExistedList() {
        /* 30 */
        return this.existedList;
    }

    public void setExistedList(List<String> existedList) {
        /* 27 */
        this.existedList = existedList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiItemExtitemExistedQueryResponse
 * JD-Core Version:    0.6.0
 */