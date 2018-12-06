package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class Sms extends Mess {
    private short msCount;
    private List<String> msList;
    private String content;

    public Sms() {
        setCommId(MessComIdConstants.SSMS);
    }

    public Sms(String msId, short msCount, List<String> msList, String content) {
        this();
        this.setSrcMsID(msId);
        this.msCount = msCount;
        this.msList = msList;
        this.content = content;
    }

    public short getMsCount() {
        return msCount;
    }

    public void setMsCount(short msCount) {
        this.msCount = msCount;
    }

    public List<String> getMsList() {
        return msList;
    }

    public void setMsList(List<String> msList) {
        this.msList = msList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sms [msCount=" + msCount + ", msList=" + msList + ", content=" + content + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        byte[] sms = null;
        try {
            sms = getContent().getBytes();
        } catch (Exception e) {
            ExcepPrinter.print(e);
            return list;
        }
        int len = OptionConstants.HEAD_LEN + 1 + OptionConstants.ID_LEN + 2 + getMsCount() * OptionConstants.ID_LEN + 1 + OptionConstants.RESERVE_LEN + 1 + 1 + 2 + sms.length;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put((byte) 0);
            buffer.put(getSrcMsID().getBytes());
            buffer.putShort(getMsCount());
            for (String msId : getMsList())
                buffer.put(msId.getBytes());
            buffer.position(buffer.position() + 11);
            buffer.putShort((short) sms.length);
            buffer.put(sms);

            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
