package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMarketingCampaignDrawcampTriggerResponse extends AlipayResponse {
    private static final long serialVersionUID = 1143294344968836474L;


    @ApiField("camp_id")
    private String campId;


    @ApiField("camp_log_id")
    private String campLogId;


    @ApiField("extend_field")
    private String extendField;


    @ApiField("prize_flag")
    private String prizeFlag;


    @ApiField("prize_id")
    private String prizeId;


    @ApiField("prize_name")
    private String prizeName;


    @ApiField("trigger_result")
    private Boolean triggerResult;


    public String getCampId() {
        /*  63 */
        return this.campId;

    }


    public void setCampId(String campId) {
        /*  60 */
        this.campId = campId;

    }


    public String getCampLogId() {
        /*  70 */
        return this.campLogId;

    }


    public void setCampLogId(String campLogId) {
        /*  67 */
        this.campLogId = campLogId;

    }


    public String getExtendField() {
        /*  77 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /*  74 */
        this.extendField = extendField;

    }


    public String getPrizeFlag() {
        /*  84 */
        return this.prizeFlag;

    }


    public void setPrizeFlag(String prizeFlag) {
        /*  81 */
        this.prizeFlag = prizeFlag;

    }


    public String getPrizeId() {
        /*  91 */
        return this.prizeId;

    }


    public void setPrizeId(String prizeId) {
        /*  88 */
        this.prizeId = prizeId;

    }


    public String getPrizeName() {
        /*  98 */
        return this.prizeName;

    }


    public void setPrizeName(String prizeName) {
        /*  95 */
        this.prizeName = prizeName;

    }


    public Boolean getTriggerResult() {
        /* 105 */
        return this.triggerResult;

    }


    public void setTriggerResult(Boolean triggerResult) {
        /* 102 */
        this.triggerResult = triggerResult;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDrawcampTriggerResponse
 * JD-Core Version:    0.6.0
 */