package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class EquipmentBindInfo extends AlipayObject {
    private static final long serialVersionUID = 4338973253726773486L;

    @ApiField("equipment_id")
    private String equipmentId;

    @ApiField("is_bind_shop")
    private String isBindShop;

    public String getEquipmentId() {
        /* 29 */
        return this.equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        /* 32 */
        this.equipmentId = equipmentId;
    }

    public String getIsBindShop() {
        /* 36 */
        return this.isBindShop;
    }

    public void setIsBindShop(String isBindShop) {
        /* 39 */
        this.isBindShop = isBindShop;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.EquipmentBindInfo
 * JD-Core Version:    0.6.0
 */