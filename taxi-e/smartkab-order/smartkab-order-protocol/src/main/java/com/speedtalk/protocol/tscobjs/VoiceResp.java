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


public class VoiceResp extends TSCObject {
    private byte result;
    private String remark;


    public VoiceResp() {
        /*  52 */
        setMessID(52);

    }


    public VoiceResp(byte result, String remark) {
        /*  56 */
        setMessID(52);
        /*  57 */
        this.result = result;
        /*  58 */
        this.remark = remark;

    }


    public byte getResult() {
        /*  26 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  36 */
        this.result = result;

    }


    public String getRemark() {
        /*  40 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /*  48 */
        this.remark = remark;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  63 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  64 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  67 */
            ByteBuffer buffer = MessageUtils.createHead(55,
                    /*  68 */         21, getMessID(),
                    /*  69 */         0, this);
            /*  70 */
            buffer.put(getResult());
            /*  71 */
            buffer.put(StringUtils.strToBytes(getRemark(), 20));
            /*  72 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 21));
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
            setResult(buffer.get());
            /* 106 */
            byte[] temp = new byte[20];
            /* 107 */
            buffer.get(temp);
            /* 108 */
            setRemark(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 112 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 116 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 122 */
        return this;

    }


    public String toString() {
        /* 127 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 128 */
        if (ParamConstants.isDetail()) {
            /* 131 */
            buffer.append(",Request call:");
            /* 132 */
            buffer.append(getResult());

            /* 134 */
            buffer.append(",Call result:");
            /* 135 */
            buffer.append(getRemark());

        } else {
            /* 139 */
            buffer.append(",");
            /* 140 */
            buffer.append(getRemark());

        }

        /* 143 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.VoiceResp
 * JD-Core Version:    0.6.0
 */