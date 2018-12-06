package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenItem extends AlipayObject {
    private static final long serialVersionUID = 2633865113367641446L;

    @ApiField("item_id")
    private String itemId;

    @ApiField("item_status")
    private String itemStatus;

    @ApiField("store_id")
    private String storeId;

    public String getItemId() {
        /* 38 */
        return this.itemId;
    }

    public void setItemId(String itemId) {
        /* 41 */
        this.itemId = itemId;
    }

    public String getItemStatus() {
        /* 45 */
        return this.itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        /* 48 */
        this.itemStatus = itemStatus;
    }

    public String getStoreId() {
        /* 52 */
        return this.storeId;
    }

    public void setStoreId(String storeId) {
        /* 55 */
        this.storeId = storeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenItem
 * JD-Core Version:    0.6.0
 */