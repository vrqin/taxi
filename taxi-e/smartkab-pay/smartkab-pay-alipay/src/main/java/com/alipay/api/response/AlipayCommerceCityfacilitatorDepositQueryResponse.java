package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.RechargeBill;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorDepositQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2411546529883131583L;

    @ApiListField("recharge_bills")
    @ApiField("recharge_bill")
    private List<RechargeBill> rechargeBills;

    public List<RechargeBill> getRechargeBills() {
        /* 31 */
        return this.rechargeBills;
    }

    public void setRechargeBills(List<RechargeBill> rechargeBills) {
        /* 28 */
        this.rechargeBills = rechargeBills;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorDepositQueryResponse
 * JD-Core Version:    0.6.0
 */