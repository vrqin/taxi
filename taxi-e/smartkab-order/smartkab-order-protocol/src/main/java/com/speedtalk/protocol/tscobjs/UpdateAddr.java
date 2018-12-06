package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class UpdateAddr extends TSCObject {
    private int timeSpent;


    public UpdateAddr() {
        /*  34 */
        setMessID(73);

    }


    public UpdateAddr(int timeSpent) {
        /*  38 */
        setMessID(73);
        /*  39 */
        this.timeSpent = timeSpent;

    }


    public int getTimeSpent() {
        /*  22 */
        return this.timeSpent;

    }


    public void setTimeSpent(int timeSpent) {
        /*  30 */
        this.timeSpent = timeSpent;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  44 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  45 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  48 */
            ByteBuffer buffer = MessageUtils.createHead(38,
                    /*  49 */         4, getMessID(),
                    /*  50 */         0, this);
            /*  51 */
            buffer.putInt(getTimeSpent());
            /*  52 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 4));
            /*  53 */
            buffer.put(MessIdConstants.ENDING);
            /*  54 */
            ArrayList resultList = new ArrayList();
            /*  55 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  56 */
            return resultList;

        } catch (Exception localException) {

        }
        /*  61 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  69 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  75 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  83 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  84 */
            setTimeSpent(buffer.getInt());

        } catch (BufferUnderflowException bue) {
            /*  88 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /*  92 */
            throw e;

        } catch (Exception localException2) {

        }
        /*  97 */
        return this;

    }


    public String toString() {
        /* 101 */
        StringBuilder buffer = new StringBuilder(super.toString());

        /* 103 */
        buffer.append(",the time of make a round trip:");
        /* 104 */
        buffer.append(getTimeSpent());
        /* 105 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.UpdateAddr
 * JD-Core Version:    0.6.0
 */