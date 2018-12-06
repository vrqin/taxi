package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ListListSmMockModel;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayMobilePublicStdMockListsmlistApiResponse extends AlipayResponse {
    private static final long serialVersionUID = 7354471652745344387L;

    @ApiListField("list_sm_model_list")
    @ApiField("list_list_sm_mock_model")
    private List<ListListSmMockModel> listSmModelList;

    public List<ListListSmMockModel> getListSmModelList() {
        /* 31 */
        return this.listSmModelList;
    }

    public void setListSmModelList(List<ListListSmMockModel> listSmModelList) {
        /* 28 */
        this.listSmModelList = listSmModelList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicStdMockListsmlistApiResponse
 * JD-Core Version:    0.6.0
 */