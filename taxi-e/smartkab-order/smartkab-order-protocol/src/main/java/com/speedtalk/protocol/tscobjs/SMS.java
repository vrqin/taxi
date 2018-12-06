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


public class SMS extends TSCObject {
    private static final int TIME_LENGTH = 15;
    private String msName;
    private String time;
    private String content;


    public SMS() {
        /*  30 */
        setMessID(23);

    }


    public SMS(String msName, String time, String content) {
        /*  34 */
        setMessID(23);
        /*  35 */
        this.msName = msName;
        /*  36 */
        this.time = time;
        /*  37 */
        this.content = content;

    }


    public String getMsName() {
        /*  45 */
        return this.msName;

    }


    public void setMsName(String msName) {
        /*  53 */
        this.msName = msName;

    }


    public String getTime() {
        /*  61 */
        return this.time;

    }


    public void setTime(String time) {
        /*  70 */
        this.time = time;

    }


    public String getContent() {
        /*  78 */
        return this.content;

    }


    public void setContent(String content) {
        /*  86 */
        this.content = content;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  91 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals(""))) {
            /*  92 */
            throw new NullPointerException("Src ms id is NULL!");

        }

        /*  95 */
        if (getContent() == null)
            /*  96 */
            throw new NullPointerException("SMS content is NULL!");

        try {
            /*  99 */
            int smsLen = 0;
            /* 100 */
            smsLen = getContent().getBytes(StringUtils.getEncoding()).length;
            /* 101 */
            if (smsLen > 400)
                /* 102 */
                smsLen = 400;
            /* 103 */
            int contentLen = 35 + smsLen;
            /* 104 */
            ByteBuffer buffer = MessageUtils.createHead(34 + contentLen,
                    /* 105 */         (short) contentLen, getMessID(), 0, this);
            /* 106 */
            buffer.put(StringUtils.strToBytes(getMsName(), 20));
            /* 107 */
            buffer.put(StringUtils.strToBytes(getTime(), 15));
            /* 108 */
            buffer.put(StringUtils.strToBytes(getContent(), smsLen));
            /* 109 */
            buffer.putShort(MessageUtils.getCRC16(buffer, contentLen));
            /* 110 */
            buffer.put(MessIdConstants.ENDING);
            /* 111 */
            ArrayList resultList = new ArrayList();
            /* 112 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 113 */
            return resultList;

        } catch (Exception localException) {

        }

        /* 119 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 127 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 133 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 140 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 141 */
            byte[] temp = new byte[20];
            /* 142 */
            buffer.get(temp);
            /* 143 */
            setMsName(StringUtils.bytesToStr(temp));
            /* 144 */
            temp = new byte[15];
            /* 145 */
            buffer.get(temp);
            /* 146 */
            setTime(StringUtils.bytesToStr(temp));
            /* 147 */
            temp = new byte[getLength() - 20 - 15];
            /* 148 */
            buffer.get(temp);
            /* 149 */
            setContent(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 153 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 157 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 163 */
        return this;

    }


    public String toString() {
        /* 167 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 168 */
        if (ParamConstants.isDetail()) {
            /* 171 */
            buffer.append(",Sender's name:");
            /* 172 */
            buffer.append(getMsName());

            /* 174 */
            buffer.append(",time:");
            /* 175 */
            buffer.append(getTime());

            /* 177 */
            buffer.append(",content:");
            /* 178 */
            buffer.append(getContent());

        } else {
            /* 182 */
            buffer.append(",");
            /* 183 */
            buffer.append(getMsName());
            /* 184 */
            buffer.append(",");
            /* 185 */
            buffer.append(getContent());

        }

        /* 188 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.SMS
 * JD-Core Version:    0.6.0
 */