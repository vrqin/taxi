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


public final class Login extends TSCObject {
    private String pwd;


    public Login() {
        /*  41 */
        setMessID(3);

    }


    public Login(String pwd) {
        /*  45 */
        setMessID(3);
        /*  46 */
        this.pwd = pwd;

    }


    public String getPwd() {
        /*  28 */
        return this.pwd;

    }


    public void setPwd(String pwd) {
        /*  36 */
        this.pwd = pwd;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  52 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  53 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  56 */
            ByteBuffer buffer = MessageUtils.createHead(40,
                    /*  57 */         6, getMessID(), 0, this);
            /*  58 */
            buffer.put(StringUtils.strToBytes(getPwd(), 6));
            /*  59 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 6));
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
            /*  90 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /*  91 */
            byte[] temp = new byte[6];
            /*  92 */
            buffer.get(temp);
            /*  93 */
            setPwd(StringUtils.bytesToStr(temp));

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
            buffer.append(",Password:");
            /* 117 */
            buffer.append(getPwd());

        } else {
            /* 121 */
            buffer.append(",");
            /* 122 */
            buffer.append(getPwd());

        }

        /* 125 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.Login
 * JD-Core Version:    0.6.0
 */