package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ListListSmMockModel extends AlipayObject {
    private static final long serialVersionUID = 6232879658761296547L;

    @ApiListField("list_simple_model_list")
    @ApiField("simple_mock_model")
    private List<SimpleMockModel> listSimpleModelList;

    public List<SimpleMockModel> getListSimpleModelList() {
        /* 27 */
        return this.listSimpleModelList;
    }

    public void setListSimpleModelList(List<SimpleMockModel> listSimpleModelList) {
        /* 30 */
        this.listSimpleModelList = listSimpleModelList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ListListSmMockModel
 * JD-Core Version:    0.6.0
 */