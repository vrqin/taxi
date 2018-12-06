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


public class OperateGrp extends TSCObject {
    private String grpID;


    public OperateGrp(byte messID) {
        /*  37 */
        setMessID(messID);

    }


    public OperateGrp(byte messID, String grpID) {
        /*  41 */
        setMessID(messID);
        /*  42 */
        this.grpID = grpID;

    }


    public String getGrpID() {
        /*  25 */
        return this.grpID;

    }


    public void setGrpID(String grpID) {
        /*  33 */
        this.grpID = grpID;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  47 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  48 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  49 */
        if ((getMessID() == 9) && (
                /*  50 */       (getDstMsID() == null) || (getDstMsID().trim().equals("")))) {
            /*  52 */
            throw new NullPointerException("Dst ms id is NULL!");

        }

        try {
            /*  56 */
            ByteBuffer buffer = MessageUtils.createHead(45,
                    /*  57 */         11, getMessID(), 0,
                    /*  58 */         this);
            /*  59 */
            buffer.put(StringUtils.strToBytes(getGrpID(), 11));
            /*  60 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 11));
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
        /*  68 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  76 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  82 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  89 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  90 */
            byte[] temp = new byte[11];
            /*  91 */
            buffer.get(temp);
            /*  92 */
            setGrpID(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /*  96 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 100 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 104 */
        return this;

    }


    public String toString() {
        /* 108 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 109 */
        if (ParamConstants.isDetail()) {
            /* 112 */
            buffer.append(",Target grp:");
            /* 113 */
            buffer.append(getGrpID());

        } else {
            /* 117 */
            buffer.append(",");
            /* 118 */
            buffer.append(getGrpID());

        }

        /* 121 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.OperateGrp
 * JD-Core Version:    0.6.0
 */