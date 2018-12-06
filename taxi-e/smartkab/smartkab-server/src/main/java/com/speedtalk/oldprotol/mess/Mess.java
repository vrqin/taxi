package com.speedtalk.oldprotol.mess;

import java.util.List;

public abstract class Mess {
    protected int totalLen;
    protected int commId;
    protected int serialNo;
    protected String srcMsID;

    public int getTotalLen() {
        return totalLen;
    }

    public void setTotalLen(int totalLen) {
        this.totalLen = totalLen;
    }

    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getSrcMsID() {
        return srcMsID;
    }

    public void setSrcMsID(String srcMsID) {
        this.srcMsID = srcMsID;
    }

    public abstract Mess bytesToObj(byte[] arg0) throws NullPointerException;

    public abstract List<byte[]> objToBytes() throws NullPointerException;
}
