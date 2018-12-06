package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class CreateGrp extends TSCObject {
    private String grpName;


    public CreateGrp() {
        /*  36 */
        setMessID(7);

    }


    public CreateGrp(String grpName) {
        /*  40 */
        setMessID(7);
        /*  41 */
        this.grpName = grpName;

    }


    public String getGrpName() {
        /*  23 */
        return this.grpName;

    }


    public void setGrpName(String grpName) {
        /*  32 */
        this.grpName = grpName;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  46 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  47 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  50 */
            ByteBuffer buffer = MessageUtils.createHead(54,
                    /*  51 */         20, getMessID(), 0, this);
            /*  52 */
            buffer.put(StringUtils.strToBytes(getGrpName(), 20));
            /*  53 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 20));
            /*  54 */
            buffer.put(MessIdConstants.ENDING);
            /*  55 */
            ArrayList resultList = new ArrayList();
            /*  56 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  57 */
            return resultList;

        } catch (Exception localException) {

        }
        /*  62 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  70 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /*  76 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /*  84 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  85 */
            byte[] temp = new byte[20];
            /*  86 */
            buffer.get(temp);
            /*  87 */
            setGrpName(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /*  91 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /*  95 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 100 */
        return this;

    }


    public String toString() {
        /* 105 */
        StringBuilder buffer = new StringBuilder(super.toString());

        /* 107 */
        buffer.append(",Grp's name:");
        /* 108 */
        buffer.append(getGrpName());
        /* 109 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.CreateGrp
 * JD-Core Version:    0.6.0
 */