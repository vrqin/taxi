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


public class Voice extends TSCObject {
    private String pttName;
    private byte[] voiceData;


    public Voice() {
        /*  49 */
        setMessID(51);

    }


    public Voice(String pttName, byte[] voiceData) {
        /*  53 */
        setMessID(51);
        /*  54 */
        this.pttName = pttName;
        /*  55 */
        this.voiceData = voiceData;

    }


    public String getPttName() {
        /*  25 */
        return this.pttName;

    }


    public void setPttName(String pttName) {
        /*  33 */
        this.pttName = pttName;

    }


    public byte[] getVoiceData() {
        /*  37 */
        return this.voiceData;

    }


    public void setVoiceData(byte[] voiceData) {
        /*  45 */
        this.voiceData = voiceData;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  60 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  61 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  62 */
        if (getVoiceData() == null)
            /*  63 */
            throw new NullPointerException("Voice data is NULL!");

        try {
            /*  66 */
            int voiceDataLength = getVoiceData().length;
            /*  67 */
            ByteBuffer buffer = MessageUtils.createHead(34 + voiceDataLength + 20,
                    /*  68 */         (short) (20 + voiceDataLength), getMessID(),
                    /*  69 */         0, this);
            /*  70 */
            buffer.put(StringUtils.strToBytes(getPttName(), 20));
            /*  71 */
            buffer.put(getVoiceData());
            /*  72 */
            buffer.putShort(MessageUtils.getCRC16(buffer, voiceDataLength + 20));
            /*  73 */
            buffer.put(MessIdConstants.ENDING);
            /*  74 */
            ArrayList resultList = new ArrayList();
            /*  75 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  76 */
            return resultList;

        } catch (Exception localException) {

        }

        /*  82 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  90 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  96 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 104 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 105 */
            byte[] temp = new byte[20];
            /* 106 */
            buffer.get(temp);
            /* 107 */
            setPttName(StringUtils.bytesToStr(temp));
            /* 108 */
            int voiceDataLength = getLength() - 20;
            /* 109 */
            if (voiceDataLength > 0) {
                /* 111 */
                byte[] voiceData = new byte[voiceDataLength];
                /* 112 */
                buffer.get(voiceData);
                /* 113 */
                setVoiceData(voiceData);

            }

        } catch (BufferUnderflowException bue) {
            /* 118 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 122 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 128 */
        return this;

    }


    public String toString() {
        /* 147 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 148 */
        if (ParamConstants.isDetail()) {
            /* 151 */
            buffer.append(",Caller:");
            /* 152 */
            buffer.append(getPttName());

            /* 154 */
            buffer.append(",Voice length:");
            /* 155 */
            buffer.append(getVoiceData() == null ? 0 : getVoiceData().length);

            /* 157 */
            buffer.append(",Voice data:...");

        } else {
            /* 162 */
            buffer.append(",");
            /* 163 */
            buffer.append(getPttName());

        }

        /* 166 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.Voice
 * JD-Core Version:    0.6.0
 */