package com.speedtalk.protocol;

import com.speedtalk.protocol.constants.MessIdDesc;
import com.speedtalk.protocol.constants.ParamConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;

import java.io.Serializable;
import java.util.List;

public abstract class TSCObject implements Serializable {
    private short length;
    private byte messID;
    private short messNo;
    private byte isSplit;
    private short totalPack = 1;
    private short packNo = 1;
    private String srcMsID;
    private String dstMsID;
    private short check;
    private byte[] rawData;

    public TSCObject() {
    }

    public short getLength() {
        return this.length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public byte getMessID() {
        return this.messID;
    }

    public void setMessID(byte messID) {
        this.messID = messID;
    }

    public short getMessNo() {
        return this.messNo;
    }

    public void setMessNo(short messNo) {
        this.messNo = messNo;
    }

    public byte getIsSplit() {
        return this.isSplit;
    }

    public void setIsSplit(byte isSplit) {
        this.isSplit = isSplit;
    }

    public short getTotalPack() {
        return this.totalPack;
    }

    public void setTotalPack(short totalPack) {
        this.totalPack = totalPack;
    }

    public short getPackNo() {
        return this.packNo;
    }

    public void setPackNo(short packNo) {
        this.packNo = packNo;
    }

    public String getSrcMsID() {
        return this.srcMsID;
    }

    public void setSrcMsID(String srcMsID) {
        this.srcMsID = srcMsID;
    }

    public String getDstMsID() {
        return this.dstMsID;
    }

    public void setDstMsID(String dstMsID) {
        this.dstMsID = dstMsID;
    }

    protected short getCheck() {
        return this.check;
    }

    protected void setCheck(short check) {
        this.check = check;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    public abstract List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException;

    public abstract TSCObject bytesToObj(byte[] var1)
            throws NullPointerException, CheckMistakenException, MessageMistakenException;

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        if (ParamConstants.isDetail()) {
            buffer.append((String) MessIdDesc.messIDDescMap.get(this.getMessID()));
            buffer.append("--Message No.:");
            buffer.append(this.getMessNo());
            buffer.append(",Source ms:");
            buffer.append(this.getSrcMsID());
            buffer.append(",Target ms:");
            buffer.append(this.getDstMsID());
            buffer.append(",Split data(0:NO;1:YES):");
            buffer.append(this.getIsSplit());
            buffer.append(",TotalPack:");
            buffer.append(this.getTotalPack());
            buffer.append(",PackNo:");
            buffer.append(this.getPackNo());
        } else {
            buffer.append(MessIdDesc.messIDDescMap.get(this.getMessID()));
            buffer.append("--Source ms:");
            buffer.append(this.getSrcMsID());
            buffer.append(",Target ms:");
            buffer.append(this.getDstMsID());
        }

        return buffer.toString();
    }
}
