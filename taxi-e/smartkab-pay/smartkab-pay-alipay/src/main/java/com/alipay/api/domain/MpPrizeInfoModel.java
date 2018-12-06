package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class MpPrizeInfoModel extends AlipayObject {
    private static final long serialVersionUID = 4198512978385957394L;


    @ApiField("certlot_number")
    private String certlotNumber;


    @ApiField("frequency_count")
    private String frequencyCount;


    @ApiField("frequency_type")
    private String frequencyType;


    @ApiField("prize_end_time")
    private String prizeEndTime;


    @ApiField("prize_id")
    private String prizeId;


    @ApiField("prize_max_award_limit")
    private String prizeMaxAwardLimit;


    @ApiField("prize_name")
    private String prizeName;


    @ApiField("prize_start_time")
    private String prizeStartTime;


    @ApiField("prize_total")
    private String prizeTotal;


    @ApiField("prize_type")
    private String prizeType;


    public String getCertlotNumber() {
        /*  77 */
        return this.certlotNumber;

    }


    public void setCertlotNumber(String certlotNumber) {
        /*  80 */
        this.certlotNumber = certlotNumber;

    }


    public String getFrequencyCount() {
        /*  84 */
        return this.frequencyCount;

    }


    public void setFrequencyCount(String frequencyCount) {
        /*  87 */
        this.frequencyCount = frequencyCount;

    }


    public String getFrequencyType() {
        /*  91 */
        return this.frequencyType;

    }


    public void setFrequencyType(String frequencyType) {
        /*  94 */
        this.frequencyType = frequencyType;

    }


    public String getPrizeEndTime() {
        /*  98 */
        return this.prizeEndTime;

    }


    public void setPrizeEndTime(String prizeEndTime) {
        /* 101 */
        this.prizeEndTime = prizeEndTime;

    }


    public String getPrizeId() {
        /* 105 */
        return this.prizeId;

    }


    public void setPrizeId(String prizeId) {
        /* 108 */
        this.prizeId = prizeId;

    }


    public String getPrizeMaxAwardLimit() {
        /* 112 */
        return this.prizeMaxAwardLimit;

    }


    public void setPrizeMaxAwardLimit(String prizeMaxAwardLimit) {
        /* 115 */
        this.prizeMaxAwardLimit = prizeMaxAwardLimit;

    }


    public String getPrizeName() {
        /* 119 */
        return this.prizeName;

    }


    public void setPrizeName(String prizeName) {
        /* 122 */
        this.prizeName = prizeName;

    }


    public String getPrizeStartTime() {
        /* 126 */
        return this.prizeStartTime;

    }


    public void setPrizeStartTime(String prizeStartTime) {
        /* 129 */
        this.prizeStartTime = prizeStartTime;

    }


    public String getPrizeTotal() {
        /* 133 */
        return this.prizeTotal;

    }


    public void setPrizeTotal(String prizeTotal) {
        /* 136 */
        this.prizeTotal = prizeTotal;

    }


    public String getPrizeType() {
        /* 140 */
        return this.prizeType;

    }


    public void setPrizeType(String prizeType) {
        /* 143 */
        this.prizeType = prizeType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MpPrizeInfoModel
 * JD-Core Version:    0.6.0
 */