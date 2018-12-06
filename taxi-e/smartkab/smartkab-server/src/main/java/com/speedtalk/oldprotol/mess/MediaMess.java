package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class MediaMess extends Mess {
    private byte[] data;

    public MediaMess() {
    }

    public MediaMess(int comId, String msId, byte[] data) {
        setCommId(comId);
        this.setSrcMsID(msId);
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MediaMess [commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
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

            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            int gpsLen = getTotalLen() - OptionConstants.ID_LEN - OptionConstants.RESERVE_LEN;

            datas = new byte[gpsLen];
            buffer.get(datas);
            this.setData(datas);

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + OptionConstants.ID_LEN + getData().length + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put(getSrcMsID().getBytes());
            buffer.put(getData());
            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
