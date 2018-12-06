package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.constants.ParamConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class HBResp extends TSCObject {
    private byte hbInterval;


    public HBResp() {
        /*  39 */
        setMessID(66);

    }


    public HBResp(byte hbInterval) {
        /*  43 */
        setMessID(66);
        /*  44 */
        this.hbInterval = hbInterval;

    }


    public byte getHbInterval() {
        /*  27 */
        return this.hbInterval;

    }


    public void setHbInterval(byte hbInterval) {
        /*  35 */
        this.hbInterval = hbInterval;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  50 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  51 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  52 */
        if (getHbInterval() < 1)
            /*  53 */
            throw new MessageMistakenException("Hb interval error!" + getHbInterval());

        try {
            /*  56 */
            ByteBuffer buffer = MessageUtils.createHead(35,
                    /*  57 */         1, getMessID(), 0, this);
            /*  58 */
            buffer.put(getHbInterval());
            /*  59 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 1));
            /*  60 */
            buffer.put(MessIdConstants.ENDING);
            /*  61 */
            ArrayList resultList = new ArrayList();
            /*  62 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  63 */
            return resultList;

        } catch (Exception localException) {

        }

        /*  69 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  77 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  83 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  91 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  92 */
            setHbInterval(buffer.get());

        } catch (BufferUnderflowException bue) {
            /*  96 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 100 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 106 */
        return this;

    }


    public String toString() {
        /* 111 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 112 */
        if (ParamConstants.isDetail()) {
            /* 115 */
            buffer.append(",Hb interval:");
            /* 116 */
            buffer.append(getHbInterval());

        } else {
            /* 120 */
            buffer.append(",");
            /* 121 */
            buffer.append(getHbInterval());

        }

        /* 124 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.HBResp
 * JD-Core Version:    0.6.0
 */