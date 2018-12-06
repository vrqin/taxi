package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberDataOauthQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 5468628962542871612L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("operator_partner_id")
    private String operatorPartnerId;

    @ApiField("operator_type")
    private String operatorType;

    public String getExtInfo() {
        /* 45 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 42 */
        this.extInfo = extInfo;
    }

    public String getOperatorId() {
        /* 52 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 49 */
        this.operatorId = operatorId;
    }

    public String getOperatorPartnerId() {
        /* 59 */
        return this.operatorPartnerId;
    }

    public void setOperatorPartnerId(String operatorPartnerId) {
        /* 56 */
        this.operatorPartnerId = operatorPartnerId;
    }

    public String getOperatorType() {
        /* 66 */
        return this.operatorType;
    }

    public void setOperatorType(String operatorType) {
        /* 63 */
        this.operatorType = operatorType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMemberDataOauthQueryResponse
 * JD-Core Version:    0.6.0
 */