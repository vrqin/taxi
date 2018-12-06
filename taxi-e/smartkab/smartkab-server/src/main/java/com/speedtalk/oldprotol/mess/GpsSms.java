package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class GpsSms extends EmptyMess {
    private String content;

    public GpsSms(String msId, String content) {
        this.setSrcMsID(msId);
        this.content = content;
    }

    @Override
    public String toString() {
        return "GpsSms [content=" + content + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    /**
     * gps sms
     */ public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        byte[] smsBs = content.getBytes();
        int smsLen = smsBs.length;
        ByteBuffer buffer = ByteBuffer.allocate(23 + smsLen);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.put(OptionConstants.HEAD);
            buffer.put((byte) 0);
            buffer.put(getSrcMsID().substring(9, 21).getBytes());
            buffer.putShort((short) (smsLen + 1));
            buffer.put((byte) 0);
            buffer.put((byte) 0x20);
            buffer.put(smsBs);
            buffer.put((byte) 0);
            buffer.put(OptionConstants.TAIL);

            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
