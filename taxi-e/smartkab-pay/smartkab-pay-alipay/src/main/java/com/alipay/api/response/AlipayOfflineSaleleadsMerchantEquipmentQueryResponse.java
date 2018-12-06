package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ShopEquipmentBindInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineSaleleadsMerchantEquipmentQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4664311817478712416L;

    @ApiField("merchant_name")
    private String merchantName;

    @ApiField("merchant_pid")
    private String merchantPid;

    @ApiListField("shopinfos")
    @ApiField("shop_equipment_bind_info")
    private List<ShopEquipmentBindInfo> shopinfos;

    public String getMerchantName() {
        /* 43 */
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        /* 40 */
        this.merchantName = merchantName;
    }

    public String getMerchantPid() {
        /* 50 */
        return this.merchantPid;
    }

    public void setMerchantPid(String merchantPid) {
        /* 47 */
        this.merchantPid = merchantPid;
    }

    public List<ShopEquipmentBindInfo> getShopinfos() {
        /* 57 */
        return this.shopinfos;
    }

    public void setShopinfos(List<ShopEquipmentBindInfo> shopinfos) {
        /* 54 */
        this.shopinfos = shopinfos;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsMerchantEquipmentQueryResponse
 * JD-Core Version:    0.6.0
 */