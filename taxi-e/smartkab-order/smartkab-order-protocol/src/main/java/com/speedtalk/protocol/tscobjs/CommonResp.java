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


public class CommonResp extends TSCObject {
    private byte result;


    public CommonResp(byte messID) {
        /*  35 */
        setMessID(messID);

    }


    public CommonResp(byte messID, byte result) {
        /*  39 */
        setMessID(messID);
        /*  40 */
        this.result = result;

    }


    public byte getResult() {
        /*  23 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  31 */
        this.result = result;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  45 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  46 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  47 */
        if ((getMessID() == 24) && (
                /*  48 */       (getDstMsID() == null) || (getDstMsID().trim().equals(""))))
            /*  49 */
            throw new NullPointerException("Dst ms id is NULL!");

        try {
            /*  52 */
            ByteBuffer buffer = MessageUtils.createHead(35,
                    /*  53 */         1, getMessID(),
                    /*  54 */         0, this);
            /*  55 */
            buffer.put(getResult());
            /*  56 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 1));
            /*  57 */
            buffer.put(MessIdConstants.ENDING);
            /*  58 */
            ArrayList resultList = new ArrayList();
            /*  59 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  60 */
            return resultList;

        } catch (Exception localException) {

        }

        /*  66 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  74 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  80 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  87 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  88 */
            setResult(buffer.get());

        } catch (BufferUnderflowException bue) {
            /*  92 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /*  96 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 102 */
        return this;

    }


    public String toString() {
        /* 107 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 108 */
        if (ParamConstants.isDetail()) {
            /* 111 */
            buffer.append(",Result:");
            /* 112 */
            buffer.append(getResult());

        } else {
            /* 116 */
            buffer.append(",");
            /* 117 */
            buffer.append(getResult());

        }

        /* 120 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.CommonResp
 * JD-Core Version:    0.6.0
 */