package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantInstConfig;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEbppMerchantConfigGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 3514112697628957822L;

    @ApiListField("inst_configs")
    @ApiField("merchant_inst_config")
    private List<MerchantInstConfig> instConfigs;

    @ApiField("merchant_user_id")
    private String merchantUserId;

    public List<MerchantInstConfig> getInstConfigs() {
        /* 37 */
        return this.instConfigs;
    }

    public void setInstConfigs(List<MerchantInstConfig> instConfigs) {
        /* 34 */
        this.instConfigs = instConfigs;
    }

    public String getMerchantUserId() {
        /* 44 */
        return this.merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        /* 41 */
        this.merchantUserId = merchantUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppMerchantConfigGetResponse
 * JD-Core Version:    0.6.0
 */