package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class EmptyMess extends Mess {
    public EmptyMess() {
    }

    public EmptyMess(int comId, String msId) {
        setCommId(comId);
        this.setSrcMsID(msId);
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        byte[] datas = new byte[21];
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + OptionConstants.ID_LEN + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put(getSrcMsID().getBytes());
            list.add(buffer.array());

        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }

    @Override
    public String toString() {
        return "EmptyMess [commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

}
