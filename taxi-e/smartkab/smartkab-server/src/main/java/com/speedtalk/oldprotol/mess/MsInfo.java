package com.speedtalk.oldprotol.mess;

public class MsInfo {
    private String msId;
    private String msName;
    private byte msType;
    private byte onlineStatus;
    private String curGrpId;

    public MsInfo() {
    }

    public MsInfo(String msId, String msName, byte msType, byte onlineStatus, String curGrpId) {
        super();
        this.msId = msId;
        this.msName = msName;
        this.msType = msType;
        this.onlineStatus = onlineStatus;
        this.curGrpId = curGrpId;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public byte getMsType() {
        return msType;
    }

    public void setMsType(byte msType) {
        this.msType = msType;
    }

    public byte getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(byte onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getCurGrpId() {
        return curGrpId;
    }

    public void setCurGrpId(String curGrpId) {
        this.curGrpId = curGrpId;
    }

    @Override
    public String toString() {
        return "MsInfo [msId=" + msId + ", onlineStatus=" + onlineStatus + "]";
    }
}
