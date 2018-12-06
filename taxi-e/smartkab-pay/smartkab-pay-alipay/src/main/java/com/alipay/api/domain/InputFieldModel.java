package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class InputFieldModel extends AlipayObject {
    private static final long serialVersionUID = 3695661159714832335L;


    @ApiField("default_value")
    private String defaultValue;


    @ApiField("field_name")
    private String fieldName;


    @ApiField("field_tips")
    private String fieldTips;


    @ApiField("field_title")
    private String fieldTitle;


    @ApiField("field_type")
    private String fieldType;


    @ApiField("priority")
    private String priority;


    @ApiListField("regexp_rule_list")

    @ApiField("validation_rule")
    private List<ValidationRule> regexpRuleList;


    public String getDefaultValue() {
        /*  63 */
        return this.defaultValue;

    }


    public void setDefaultValue(String defaultValue) {
        /*  66 */
        this.defaultValue = defaultValue;

    }


    public String getFieldName() {
        /*  70 */
        return this.fieldName;

    }


    public void setFieldName(String fieldName) {
        /*  73 */
        this.fieldName = fieldName;

    }


    public String getFieldTips() {
        /*  77 */
        return this.fieldTips;

    }


    public void setFieldTips(String fieldTips) {
        /*  80 */
        this.fieldTips = fieldTips;

    }


    public String getFieldTitle() {
        /*  84 */
        return this.fieldTitle;

    }


    public void setFieldTitle(String fieldTitle) {
        /*  87 */
        this.fieldTitle = fieldTitle;

    }


    public String getFieldType() {
        /*  91 */
        return this.fieldType;

    }


    public void setFieldType(String fieldType) {
        /*  94 */
        this.fieldType = fieldType;

    }


    public String getPriority() {
        /*  98 */
        return this.priority;

    }


    public void setPriority(String priority) {
        /* 101 */
        this.priority = priority;

    }


    public List<ValidationRule> getRegexpRuleList() {
        /* 105 */
        return this.regexpRuleList;

    }


    public void setRegexpRuleList(List<ValidationRule> regexpRuleList) {
        /* 108 */
        this.regexpRuleList = regexpRuleList;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.InputFieldModel
 * JD-Core Version:    0.6.0
 */