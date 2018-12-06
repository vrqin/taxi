package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class OldListListComplexMockModel extends AlipayObject {
    private static final long serialVersionUID = 5333285367238344784L;

    @ApiListField("cm_list")
    @ApiField("old_complext_mock_model")
    private List<OldComplextMockModel> cmList;

    public List<OldComplextMockModel> getCmList() {
        /* 27 */
        return this.cmList;
    }

    public void setCmList(List<OldComplextMockModel> cmList) {
        /* 30 */
        this.cmList = cmList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OldListListComplexMockModel
 * JD-Core Version:    0.6.0
 */