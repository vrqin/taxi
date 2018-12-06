package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarDataserviceViolationinfoShareResponse extends AlipayResponse {
    private static final long serialVersionUID = 5416388628922429231L;

    @ApiField("body_num")
    private String bodyNum;

    @ApiField("engine_num")
    private String engineNum;

    @ApiField("vehicle_id")
    private String vehicleId;

    @ApiField("vi_number")
    private String viNumber;

    public String getBodyNum() {
        /* 45 */
        return this.bodyNum;
    }

    public void setBodyNum(String bodyNum) {
        /* 42 */
        this.bodyNum = bodyNum;
    }

    public String getEngineNum() {
        /* 52 */
        return this.engineNum;
    }

    public void setEngineNum(String engineNum) {
        /* 49 */
        this.engineNum = engineNum;
    }

    public String getVehicleId() {
        /* 59 */
        return this.vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        /* 56 */
        this.vehicleId = vehicleId;
    }

    public String getViNumber() {
        /* 66 */
        return this.viNumber;
    }

    public void setViNumber(String viNumber) {
        /* 63 */
        this.viNumber = viNumber;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarDataserviceViolationinfoShareResponse
 * JD-Core Version:    0.6.0
 */