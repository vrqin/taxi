package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingCardqrcodeCreateModel extends AlipayObject {
    private static final long serialVersionUID = 4287129732468498717L;

    @ApiField("equipment_id")
    private String equipmentId;

    @ApiField("parking_id")
    private String parkingId;

    public String getEquipmentId() {
        /* 29 */
        return this.equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        /* 32 */
        this.equipmentId = equipmentId;
    }

    public String getParkingId() {
        /* 36 */
        return this.parkingId;
    }

    public void setParkingId(String parkingId) {
        /* 39 */
        this.parkingId = parkingId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarParkingCardqrcodeCreateModel
 * JD-Core Version:    0.6.0
 */