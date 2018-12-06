package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class GpsHB extends EmptyMess {
    public GpsHB(String msId) {
        this.setSrcMsID(msId);
    }

    @Override
    public String toString() {
        return "GpsHB [commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    /**
     * GPM hb
     */ public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        ByteBuffer buffer = ByteBuffer.allocate(27);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.put(OptionConstants.HEAD);
            buffer.put((byte) 0);
            buffer.put(getSrcMsID().getBytes());
            buffer.putShort((short) 5);
            buffer.put((byte) 0);
            buffer.put((byte) 8);
            buffer.putInt(110);
            buffer.put((byte) 0);
            buffer.put(OptionConstants.TAIL);

            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
