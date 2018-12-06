package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class MyselfQueryResp extends QueryResp {
    private String msName;
    private byte msType;
    private byte onlineStatus;

    public MyselfQueryResp() {
    }

    public MyselfQueryResp(short result, byte option, String msName, byte msType, byte onlineStatus) {
        super(result, option);
        this.msName = msName;
        this.msType = msType;
        this.onlineStatus = onlineStatus;
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

    @Override
    public String toString() {
        return "MyselfQueryResp [msName=" + msName + ", msType=" + msType + ", onlineStatus=" + onlineStatus + ", option=" + option + ", result=" + result + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            this.setResult(buffer.getShort());
            this.setOption(buffer.get());

            buffer.position(buffer.position() + 8);

            if (OptionConstants.SUCCESS_RESULT == this.getResult()) {
                byte[] names = new byte[30];
                buffer.get(names);
                this.setMsName(Assistant.bytesToStr(names, null));
                this.setMsType(buffer.get());
                this.setOnlineStatus(buffer.get());
            }

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        return null;
    }
}
