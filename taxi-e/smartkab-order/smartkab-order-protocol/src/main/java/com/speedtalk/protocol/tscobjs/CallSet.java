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


public class CallSet extends TSCObject {
    private String grpID;
    private byte callType;
    private short keepMinutes;


    public CallSet() {
        /*  77 */
        setMessID(85);

    }


    public CallSet(String grpID, byte callType) {
        /*  81 */
        setMessID(85);
        /*  82 */
        this.grpID = grpID;
        /*  83 */
        this.callType = callType;

    }


    public String getGrpID() {
        /*  26 */
        return this.grpID;

    }


    public void setGrpID(String grpID) {
        /*  34 */
        this.grpID = grpID;

    }


    public byte getCallType() {
        /*  41 */
        return this.callType;

    }


    public void setCallType(byte callType) {
        /*  53 */
        this.callType = callType;

    }


    public short getKeepMinutes() {
        /*  60 */
        return this.keepMinutes;

    }


    public void setKeepMinutes(short keepMinutes) {
        /*  72 */
        this.keepMinutes = keepMinutes;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  88 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  89 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  90 */
        if ((getDstMsID() == null) || (getDstMsID().trim().equals("")))
            /*  91 */
            throw new NullPointerException("Dst ms id is NULL!");
        /*  92 */
        if ((getGrpID() == null) || (getGrpID().trim().equals("")))
            /*  93 */
            throw new NullPointerException("Grp id is NULL!");

        try {
            /*  96 */
            ByteBuffer buffer = MessageUtils.createHead(48,
                    /*  97 */         14, getMessID(), 0, this);
            /*  98 */
            buffer.put(StringUtils.strToBytes(getGrpID(), 11));
            /*  99 */
            buffer.put(getCallType());
            /* 100 */
            buffer.putShort(getKeepMinutes());
            /* 101 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 14));
            /* 102 */
            buffer.put(MessIdConstants.ENDING);
            /* 103 */
            ArrayList resultList = new ArrayList();
            /* 104 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 105 */
            return resultList;

        } catch (Exception localException) {

        }
        /* 109 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 117 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 123 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 131 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 132 */
            byte[] temp = new byte[11];
            /* 133 */
            buffer.get(temp);
            /* 134 */
            setGrpID(StringUtils.bytesToStr(temp));
            /* 135 */
            setCallType(buffer.get());
            /* 136 */
            setKeepMinutes(buffer.getShort());

        } catch (BufferUnderflowException bue) {
            /* 140 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 144 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 150 */
        return this;

    }


    public String toString() {
        /* 155 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 156 */
        if (ParamConstants.isDetail()) {
            /* 158 */
            buffer.append(",GrpID:");
            /* 159 */
            buffer.append(getGrpID());
            /* 160 */
            buffer.append(",CallType:");
            /* 161 */
            buffer.append(getCallType());
            /* 162 */
            buffer.append(",KeepMinutes:");
            /* 163 */
            buffer.append(getKeepMinutes());

        } else {
            /* 167 */
            buffer.append(",");
            /* 168 */
            buffer.append(getGrpID());
            /* 169 */
            buffer.append(",");
            /* 170 */
            buffer.append(getCallType());
            /* 171 */
            buffer.append(",");
            /* 172 */
            buffer.append(getKeepMinutes());

        }

        /* 175 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.CallSet
 * JD-Core Version:    0.6.0
 */