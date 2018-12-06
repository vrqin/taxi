package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class GroupSetting extends AlipayObject {
    private static final long serialVersionUID = 4489742613956973421L;

    @ApiField("group_name")
    private String groupName;

    @ApiField("is_openinv")
    private Boolean isOpeninv;

    @ApiField("public_notice")
    private String publicNotice;

    public String getGroupName() {
        /* 35 */
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        /* 38 */
        this.groupName = groupName;
    }

    public Boolean getIsOpeninv() {
        /* 42 */
        return this.isOpeninv;
    }

    public void setIsOpeninv(Boolean isOpeninv) {
        /* 45 */
        this.isOpeninv = isOpeninv;
    }

    public String getPublicNotice() {
        /* 49 */
        return this.publicNotice;
    }

    public void setPublicNotice(String publicNotice) {
        /* 52 */
        this.publicNotice = publicNotice;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.GroupSetting
 * JD-Core Version:    0.6.0
 */