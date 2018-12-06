package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class MoGps extends MediaMess {

    @Override
    public String toString() {
        return "MoGps [toString()=" + super.toString() + "]";
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

            buffer.get();
            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            int gpsLen = getTotalLen() - 1 - OptionConstants.ID_LEN - OptionConstants.RESERVE_LEN;

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
        int len = OptionConstants.HEAD_LEN + 1 + OptionConstants.ID_LEN + getData().length + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put((byte) 0);
            buffer.put(getSrcMsID().getBytes());
            buffer.put(getData());
            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
