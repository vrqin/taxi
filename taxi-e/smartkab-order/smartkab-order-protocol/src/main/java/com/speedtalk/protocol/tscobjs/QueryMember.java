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


public class QueryMember extends TSCObject {
    protected byte type;
    protected String grpId;


    public QueryMember() {
        /*  29 */
        setMessID(83);

    }


    public QueryMember(byte type, String grpId) {
        /*  33 */
        setMessID(83);
        /*  34 */
        this.type = type;
        /*  35 */
        this.grpId = grpId;

    }


    public byte getType() {
        /*  46 */
        return this.type;

    }


    public void setType(byte type) {
        /*  50 */
        this.type = type;

    }


    public String getGrpId() {
        /*  62 */
        return this.grpId;

    }


    public void setGrpId(String grpId) {
        /*  74 */
        this.grpId = grpId;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  79 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  80 */
            throw new NullPointerException("Src msid is NULL!");
        /*  81 */
        if ((getType() == 0) && (
                /*  82 */       (getGrpId() == null) || (getGrpId().trim().equals(""))))
            /*  83 */
            throw new NullPointerException("GrpId is NULL!");

        try {
            /*  86 */
            ByteBuffer buffer = MessageUtils.createHead(46,
                    /*  87 */         12, getMessID(), 0, this);
            /*  88 */
            buffer.put(getType());
            /*  89 */
            buffer.put(StringUtils.strToBytes(getGrpId(), 11));
            /*  90 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 12));
            /*  91 */
            buffer.put(MessIdConstants.ENDING);
            /*  92 */
            ArrayList resultList = new ArrayList();
            /*  93 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  94 */
            return resultList;

        } catch (Exception localException) {

        }

        /* 100 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 108 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 114 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 122 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 123 */
            setType(buffer.get());
            /* 124 */
            byte[] temp = new byte[11];
            /* 125 */
            buffer.get(temp);
            /* 126 */
            setGrpId(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 130 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 134 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 140 */
        return this;

    }


    public String toString() {
        /* 145 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 146 */
        if (ParamConstants.isDetail()) {
            /* 148 */
            buffer.append(",Type:");
            /* 149 */
            buffer.append(getType());
            /* 150 */
            buffer.append(",Grp:");
            /* 151 */
            buffer.append(getGrpId());

        } else {
            /* 155 */
            buffer.append(",");
            /* 156 */
            buffer.append(getType());
            /* 157 */
            buffer.append(",");
            /* 158 */
            buffer.append(getGrpId());

        }

        /* 161 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.QueryMember
 * JD-Core Version:    0.6.0
 */