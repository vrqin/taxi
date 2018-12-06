package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class Notify extends Mess {
    private byte option;
    private String grpId;
    private String msId;
    private String msName;
    private byte onLineStatus;

    public Notify() {
        setCommId(MessComIdConstants.NOTIFY);
    }

    public Notify(byte option, String msId, String grpId) {
        this();
        this.option = option;
        this.msId = msId;
        this.grpId = grpId;
    }

    public byte getOption() {
        return option;
    }

    public void setOption(byte option) {
        this.option = option;
    }

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
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

    public byte getOnLineStatus() {
        return onLineStatus;
    }

    public void setOnLineStatus(byte onLineStatus) {
        this.onLineStatus = onLineStatus;
    }

    @Override
    public String toString() {
        return "Notify [option=" + option + ", grpId=" + grpId + ", msId=" + msId + ", msName=" + msName + ", onLineStatus=" + onLineStatus + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        byte[] datas = new byte[OptionConstants.ID_LEN];
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            buffer.position(buffer.position() + 7);

            this.setOption(buffer.get());

            if (OptionConstants.MS_STATUS_NOTIFY != this.getOption())
                return null;

            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            buffer.get(datas);
            this.setGrpId(new String(datas));

            buffer.position(buffer.position() + 8);

            if (OptionConstants.MS_STATUS_NOTIFY == this.getOption()) {
                buffer.get(datas);
                this.setMsId(new String(datas));

                datas = new byte[30];
                buffer.get(datas);
                this.setMsName(Assistant.bytesToStr(datas, null));
                this.setOnLineStatus(buffer.get());
            }

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }
}
