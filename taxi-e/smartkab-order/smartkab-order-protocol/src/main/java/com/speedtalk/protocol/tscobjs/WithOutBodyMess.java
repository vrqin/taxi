package com.speedtalk.protocol.tscobjs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class WithOutBodyMess extends TSCObject {
    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 21 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /* 22 */
            throw new NullPointerException("Src ms id is NULL!");
        try {
            /* 25 */
            ByteBuffer buffer = MessageUtils.createHead(34,
                    /* 26 */         0, getMessID(), 0, this);
            /* 27 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 0));
            /* 28 */
            buffer.put(MessIdConstants.ENDING);
            /* 29 */
            ArrayList resultList = new ArrayList();
            /* 30 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 31 */
            return resultList;
        } catch (Exception localException) {
        }

        /* 37 */
        return null;
    }

    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            /* 45 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));
        } catch (Exception e) {
            try {
                /* 51 */
                throw e;
            } catch (Exception localException1) {
            }
        }
        try {
            /* 59 */
            MessageUtils.parseHead(datas, this);
        } catch (NullPointerException e) {
            /* 63 */
            throw e;
        } catch (Exception localException2) {
        }

        /* 69 */
        return this;
    }

    public String toString() {
        /* 74 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.WithOutBodyMess
 * JD-Core Version:    0.6.0
 */