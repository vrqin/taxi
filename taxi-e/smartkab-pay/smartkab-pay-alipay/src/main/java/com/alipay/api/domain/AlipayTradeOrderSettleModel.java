package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayTradeOrderSettleModel extends AlipayObject {
    private static final long serialVersionUID = 6196984578454914735L;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("out_request_no")
    private String outRequestNo;

    @ApiListField("royalty_parameters")
    @ApiField("open_api_royalty_detail_info_pojo")
    private List<OpenApiRoyaltyDetailInfoPojo> royaltyParameters;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOperatorId() {
        /* 45 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 48 */
        this.operatorId = operatorId;
    }

    public String getOutRequestNo() {
        /* 52 */
        return this.outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        /* 55 */
        this.outRequestNo = outRequestNo;
    }

    public List<OpenApiRoyaltyDetailInfoPojo> getRoyaltyParameters() {
        /* 59 */
        return this.royaltyParameters;
    }

    public void setRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> royaltyParameters) {
        /* 62 */
        this.royaltyParameters = royaltyParameters;
    }

    public String getTradeNo() {
        /* 66 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 69 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeOrderSettleModel
 * JD-Core Version:    0.6.0
 */