package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.EquipmentAuthRemoveQueryBypageDTO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineProviderEquipmentAuthQuerybypageResponse extends AlipayResponse {
    private static final long serialVersionUID = 1456928543545254913L;

    @ApiListField("equipmentauthremovequerybypagelist")
    @ApiField("equipment_auth_remove_query_bypage_d_t_o")
    private List<EquipmentAuthRemoveQueryBypageDTO> equipmentauthremovequerybypagelist;

    @ApiField("total")
    private Long total;

    public List<EquipmentAuthRemoveQueryBypageDTO> getEquipmentauthremovequerybypagelist() {
        /* 37 */
        return this.equipmentauthremovequerybypagelist;
    }

    public void setEquipmentauthremovequerybypagelist(List<EquipmentAuthRemoveQueryBypageDTO> equipmentauthremovequerybypagelist) {
        /* 34 */
        this.equipmentauthremovequerybypagelist = equipmentauthremovequerybypagelist;
    }

    public Long getTotal() {
        /* 44 */
        return this.total;
    }

    public void setTotal(Long total) {
        /* 41 */
        this.total = total;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineProviderEquipmentAuthQuerybypageResponse
 * JD-Core Version:    0.6.0
 */