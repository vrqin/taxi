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


public class Register extends TSCObject {
    private String pwd;
    private String name;
    private String grpID;


    public Register() {
        /*  64 */
        setMessID(1);

    }


    public Register(String pwd, String name, String grpID) {
        /*  68 */
        setMessID(1);
        /*  69 */
        this.pwd = pwd;
        /*  70 */
        this.name = name;
        /*  71 */
        this.grpID = grpID;

    }


    public String getPwd() {
        /*  26 */
        return this.pwd;

    }


    public void setPwd(String pwd) {
        /*  35 */
        this.pwd = pwd;

    }


    public String getName() {
        /*  39 */
        return this.name;

    }


    public void setName(String name) {
        /*  48 */
        this.name = name;

    }


    public String getGrpID() {
        /*  52 */
        return this.grpID;

    }


    public void setGrpID(String grpID) {
        /*  60 */
        this.grpID = grpID;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  76 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  77 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  80 */
            ByteBuffer buffer = MessageUtils.createHead(71,
                    /*  81 */         37, getMessID(),
                    /*  82 */         0, this);
            /*  83 */
            buffer.put(StringUtils.strToBytes(getPwd(), 6));
            /*  84 */
            buffer.put(StringUtils.strToBytes(getName(), 20));
            /*  85 */
            buffer.put(StringUtils.strToBytes(getGrpID(), 11));
            /*  86 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 37));
            /*  87 */
            buffer.put(MessIdConstants.ENDING);
            /*  88 */
            ArrayList resultList = new ArrayList();
            /*  89 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  90 */
            return resultList;

        } catch (Exception localException) {

        }
        /*  95 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 103 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 109 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 117 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 118 */
            byte[] temp = new byte[6];
            /* 119 */
            buffer.get(temp);
            /* 120 */
            setPwd(StringUtils.bytesToStr(temp));
            /* 121 */
            temp = new byte[20];
            /* 122 */
            buffer.get(temp);
            /* 123 */
            setName(StringUtils.bytesToStr(temp));
            /* 124 */
            temp = new byte[11];
            /* 125 */
            buffer.get(temp);
            /* 126 */
            setGrpID(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 130 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 134 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 139 */
        return this;

    }


    public String toString() {
        /* 144 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 145 */
        if (ParamConstants.isDetail()) {
            /* 148 */
            buffer.append(",Password:");
            /* 149 */
            buffer.append(getPwd());

            /* 151 */
            buffer.append(",Name:");
            /* 152 */
            buffer.append(getName());

            /* 154 */
            buffer.append(",Grp:");
            /* 155 */
            buffer.append(getGrpID());

        } else {
            /* 159 */
            buffer.append(",");
            /* 160 */
            buffer.append(getPwd());

            /* 162 */
            buffer.append(",");
            /* 163 */
            buffer.append(getName());

            /* 165 */
            buffer.append(",");
            /* 166 */
            buffer.append(getGrpID());

        }

        /* 169 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.Register
 * JD-Core Version:    0.6.0
 */