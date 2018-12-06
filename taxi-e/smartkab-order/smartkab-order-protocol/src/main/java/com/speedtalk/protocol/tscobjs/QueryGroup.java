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


public class QueryGroup extends TSCObject {
    private byte type;


    public QueryGroup() {
        /*  43 */
        setMessID(55);

    }


    public QueryGroup(byte type) {
        /*  47 */
        setMessID(55);
        /*  48 */
        this.type = type;

    }


    public byte getType() {
        /*  35 */
        return this.type;

    }


    public void setType(byte type) {
        /*  39 */
        this.type = type;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  53 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  54 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  57 */
            ByteBuffer buffer = MessageUtils.createHead(35,
                    /*  58 */         1, getMessID(), 0, this);
            /*  59 */
            buffer.put(getType());
            /*  60 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 1));
            /*  61 */
            buffer.put(MessIdConstants.ENDING);
            /*  62 */
            ArrayList resultList = new ArrayList();
            /*  63 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  64 */
            return resultList;

        } catch (Exception localException) {

        }

        /*  70 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  78 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  84 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  92 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  93 */
            setType(buffer.get());

        } catch (BufferUnderflowException bue) {
            /*  97 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 101 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 107 */
        return this;

    }


    public String toString() {
        /* 112 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 113 */
        if (ParamConstants.isDetail()) {
            /* 116 */
            buffer.append(",Operation: ");
            /* 117 */
            buffer.append(getType());

        } else {
            /* 121 */
            buffer.append(",");
            /* 122 */
            buffer.append(getType());

        }

        /* 125 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.QueryGroup
 * JD-Core Version:    0.6.0
 */