package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SupportFunction;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorFunctionQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6375355115775598734L;

    @ApiListField("functions")
    @ApiField("support_function")
    private List<SupportFunction> functions;

    public List<SupportFunction> getFunctions() {
        /* 31 */
        return this.functions;
    }

    public void setFunctions(List<SupportFunction> functions) {
        /* 28 */
        this.functions = functions;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorFunctionQueryResponse
 * JD-Core Version:    0.6.0
 */