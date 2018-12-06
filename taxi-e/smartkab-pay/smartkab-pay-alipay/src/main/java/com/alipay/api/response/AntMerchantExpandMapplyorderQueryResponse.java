package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantApplyResultRecord;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AntMerchantExpandMapplyorderQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7426181295572341655L;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("order_status")
    private String orderStatus;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiListField("result_info")
    @ApiField("merchant_apply_result_record")
    private List<MerchantApplyResultRecord> resultInfo;

    public String getOrderNo() {
        /* 49 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 46 */
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        /* 56 */
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        /* 53 */
        this.orderStatus = orderStatus;
    }

    public String getOutBizNo() {
        /* 63 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 60 */
        this.outBizNo = outBizNo;
    }

    public List<MerchantApplyResultRecord> getResultInfo() {
        /* 70 */
        return this.resultInfo;
    }

    public void setResultInfo(List<MerchantApplyResultRecord> resultInfo) {
        /* 67 */
        this.resultInfo = resultInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AntMerchantExpandMapplyorderQueryResponse
 * JD-Core Version:    0.6.0
 */