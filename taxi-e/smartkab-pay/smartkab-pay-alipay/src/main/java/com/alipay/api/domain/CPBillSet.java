package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class CPBillSet extends AlipayObject {
    private static final long serialVersionUID = 8339796374352617271L;


    @ApiField("acct_period")
    private String acctPeriod;


    @ApiField("bill_entry_amount")
    private String billEntryAmount;


    @ApiField("bill_entry_id")
    private String billEntryId;


    @ApiField("cost_type")
    private String costType;


    @ApiField("deadline")
    private String deadline;


    @ApiField("out_room_id")
    private String outRoomId;


    @ApiField("release_day")
    private String releaseDay;


    @ApiField("room_address")
    private String roomAddress;


    public String getAcctPeriod() {
        /*  65 */
        return this.acctPeriod;

    }


    public void setAcctPeriod(String acctPeriod) {
        /*  68 */
        this.acctPeriod = acctPeriod;

    }


    public String getBillEntryAmount() {
        /*  72 */
        return this.billEntryAmount;

    }


    public void setBillEntryAmount(String billEntryAmount) {
        /*  75 */
        this.billEntryAmount = billEntryAmount;

    }


    public String getBillEntryId() {
        /*  79 */
        return this.billEntryId;

    }


    public void setBillEntryId(String billEntryId) {
        /*  82 */
        this.billEntryId = billEntryId;

    }


    public String getCostType() {
        /*  86 */
        return this.costType;

    }


    public void setCostType(String costType) {
        /*  89 */
        this.costType = costType;

    }


    public String getDeadline() {
        /*  93 */
        return this.deadline;

    }


    public void setDeadline(String deadline) {
        /*  96 */
        this.deadline = deadline;

    }


    public String getOutRoomId() {
        /* 100 */
        return this.outRoomId;

    }


    public void setOutRoomId(String outRoomId) {
        /* 103 */
        this.outRoomId = outRoomId;

    }


    public String getReleaseDay() {
        /* 107 */
        return this.releaseDay;

    }


    public void setReleaseDay(String releaseDay) {
        /* 110 */
        this.releaseDay = releaseDay;

    }


    public String getRoomAddress() {
        /* 114 */
        return this.roomAddress;

    }


    public void setRoomAddress(String roomAddress) {
        /* 117 */
        this.roomAddress = roomAddress;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CPBillSet
 * JD-Core Version:    0.6.0
 */