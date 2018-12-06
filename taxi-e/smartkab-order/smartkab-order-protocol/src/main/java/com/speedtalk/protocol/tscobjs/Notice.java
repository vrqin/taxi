package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.constants.ParamConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class Notice extends TSCObject {
    private byte type;
    private String msID;
    private String name;


    public Notice() {
        /*  98 */
        setMessID(41);

    }


    public Notice(byte type, String msID, String name) {
        /* 102 */
        setMessID(41);
        /* 103 */
        this.type = type;
        /* 104 */
        this.msID = msID;
        /* 105 */
        this.name = name;

    }


    public byte getType() {
        /*  37 */
        return this.type;

    }


    public void setType(byte type) {
        /*  41 */
        this.type = type;

    }


    public String getMsID() {
        /*  59 */
        return this.msID;

    }


    public void setMsID(String msID) {
        /*  63 */
        this.msID = msID;

    }


    public String getName() {
        /*  71 */
        return this.name;

    }

    public void setName(String name) {
        /*  85 */
        this.name = name;

    }

    public void setName(byte callType) {
        /*  94 */
        this.name = String.valueOf(callType);

    }

    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 110 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /* 111 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /* 114 */
            ByteBuffer buffer = MessageUtils.createHead(66,
                    /* 115 */         32, getMessID(), 0, this);
            /* 116 */
            buffer.put(getType());
            /* 117 */
            buffer.put(StringUtils.strToBytes(getMsID(), 11));
            /* 118 */
            buffer.put(StringUtils.strToBytes(getName(), 20));
            /* 119 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 32));
            /* 120 */
            buffer.put(MessIdConstants.ENDING);
            /* 121 */
            ArrayList resultList = new ArrayList();
            /* 122 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 123 */
            return resultList;

        } catch (Exception localException) {

        }
        /* 128 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 136 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 142 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 150 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 151 */
            setType(buffer.get());
            /* 152 */
            byte[] temp = new byte[11];
            /* 153 */
            buffer.get(temp);
            /* 154 */
            setMsID(StringUtils.bytesToStr(temp));
            /* 155 */
            temp = new byte[20];
            /* 156 */
            buffer.get(temp);
            /* 157 */
            setName(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 161 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 165 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 170 */
        return this;

    }


    public String toString() {
        /* 174 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 175 */
        if (ParamConstants.isDetail()) {
            /* 178 */
            buffer.append(",Type:");
            /* 179 */
            buffer.append(getType());
            /* 180 */
            buffer.append(",Msid:");
            /* 181 */
            buffer.append(getMsID());
            /* 182 */
            buffer.append(",Name:");
            /* 183 */
            buffer.append(getName());

        } else {
            /* 187 */
            buffer.append(",");
            /* 188 */
            buffer.append(getType());
            /* 189 */
            buffer.append(",Msid:");
            /* 190 */
            buffer.append(getMsID());

        }

        /* 193 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.Notice
 * JD-Core Version:    0.6.0
 */