package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class Query extends Mess {
    private byte option;
    private String param;

    public Query() {
        setCommId(MessComIdConstants.QUERY);
    }

    public Query(String msId, byte option) {
        this();
        this.setSrcMsID(msId);
        this.option = option;
    }

    public byte getOption() {
        return option;
    }

    public void setOption(byte option) {
        this.option = option;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Query [option=" + option + ", param=" + param + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + 1 + OptionConstants.ID_LEN + 1 + 2 + 2 + OptionConstants.ID_LEN + OptionConstants.ID_LEN + 1 + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put((byte) 0);
            buffer.put(getSrcMsID().getBytes());
            buffer.put(getOption());
            buffer.position(buffer.position() + 4);
            buffer.put(Assistant.strToBytes(getParam(), null, OptionConstants.ID_LEN));
            list.add(buffer.array());

        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
