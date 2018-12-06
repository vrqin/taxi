package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ShopEquipmentBindInfo extends AlipayObject {
    private static final long serialVersionUID = 3322327331114843812L;

    @ApiListField("equipments")
    @ApiField("equipment_bind_info")
    private List<EquipmentBindInfo> equipments;

    @ApiField("shop_id")
    private String shopId;

    @ApiField("shop_name")
    private String shopName;

    public List<EquipmentBindInfo> getEquipments() {
        /* 39 */
        return this.equipments;
    }

    public void setEquipments(List<EquipmentBindInfo> equipments) {
        /* 42 */
        this.equipments = equipments;
    }

    public String getShopId() {
        /* 46 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 49 */
        this.shopId = shopId;
    }

    public String getShopName() {
        /* 53 */
        return this.shopName;
    }

    public void setShopName(String shopName) {
        /* 56 */
        this.shopName = shopName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ShopEquipmentBindInfo
 * JD-Core Version:    0.6.0
 */