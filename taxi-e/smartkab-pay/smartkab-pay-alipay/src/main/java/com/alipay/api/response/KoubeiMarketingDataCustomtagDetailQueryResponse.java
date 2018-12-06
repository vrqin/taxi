package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.DataEnumValue;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomtagDetailQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8435627618811946345L;

    @ApiListField("enum_values")
    @ApiField("data_enum_value")
    private List<DataEnumValue> enumValues;

    @ApiField("memo")
    private String memo;

    @ApiField("name")
    private String name;

    @ApiField("tag_code")
    private String tagCode;

    public List<DataEnumValue> getEnumValues() {
        /* 49 */
        return this.enumValues;
    }

    public void setEnumValues(List<DataEnumValue> enumValues) {
        /* 46 */
        this.enumValues = enumValues;
    }

    public String getMemo() {
        /* 56 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 53 */
        this.memo = memo;
    }

    public String getName() {
        /* 63 */
        return this.name;
    }

    public void setName(String name) {
        /* 60 */
        this.name = name;
    }

    public String getTagCode() {
        /* 70 */
        return this.tagCode;
    }

    public void setTagCode(String tagCode) {
        /* 67 */
        this.tagCode = tagCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomtagDetailQueryResponse
 * JD-Core Version:    0.6.0
 */