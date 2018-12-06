package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomtagSaveModel extends AlipayObject {
    private static final long serialVersionUID = 5656184191726835896L;

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
        /* 45 */
        return this.enumValues;
    }

    public void setEnumValues(List<DataEnumValue> enumValues) {
        /* 48 */
        this.enumValues = enumValues;
    }

    public String getMemo() {
        /* 52 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 55 */
        this.memo = memo;
    }

    public String getName() {
        /* 59 */
        return this.name;
    }

    public void setName(String name) {
        /* 62 */
        this.name = name;
    }

    public String getTagCode() {
        /* 66 */
        return this.tagCode;
    }

    public void setTagCode(String tagCode) {
        /* 69 */
        this.tagCode = tagCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomtagSaveModel
 * JD-Core Version:    0.6.0
 */