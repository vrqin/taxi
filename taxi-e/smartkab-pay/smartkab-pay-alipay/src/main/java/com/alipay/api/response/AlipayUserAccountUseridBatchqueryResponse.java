package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayUserAccountUseridBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7459774871643613648L;

    @ApiListField("user_id_list")
    @ApiField("string")
    private List<String> userIdList;

    public List<String> getUserIdList() {
        /* 30 */
        return this.userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        /* 27 */
        this.userIdList = userIdList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserAccountUseridBatchqueryResponse
 * JD-Core Version:    0.6.0
 */