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


public class CreateGrpResp extends TSCObject {
    private byte result;
    private String grpID;
    private String remark;


    public CreateGrpResp() {
        /*  63 */
        setMessID(8);

    }


    public CreateGrpResp(byte result, String grpID, String remark) {
        /*  67 */
        setMessID(8);
        /*  68 */
        this.result = result;
        /*  69 */
        this.grpID = grpID;
        /*  70 */
        this.remark = remark;

    }


    public byte getResult() {
        /*  27 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  35 */
        this.result = result;

    }


    public String getGrpID() {
        /*  39 */
        return this.grpID;

    }


    public void setGrpID(String grpID) {
        /*  47 */
        this.grpID = grpID;

    }


    public String getRemark() {
        /*  51 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /*  59 */
        this.remark = remark;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  75 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  76 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /*  79 */
            ByteBuffer buffer = MessageUtils.createHead(66,
                    /*  80 */         20, getMessID(), 0,
                    /*  81 */         this);
            /*  82 */
            buffer.put(getResult());
            /*  83 */
            buffer.put(StringUtils.strToBytes(getGrpID(), 11));
            /*  84 */
            buffer.put(StringUtils.strToBytes(getRemark(), 20));
            /*  85 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 20));
            /*  86 */
            buffer.put(MessIdConstants.ENDING);
            /*  87 */
            ArrayList resultList = new ArrayList();
            /*  88 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  89 */
            return resultList;

        } catch (Exception localException) {

        }
        /*  93 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 101 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 107 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 114 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 115 */
            setResult(buffer.get());
            /* 116 */
            byte[] temp = new byte[11];
            /* 117 */
            buffer.get(temp);
            /* 118 */
            setGrpID(StringUtils.bytesToStr(temp));
            /* 119 */
            temp = new byte[20];
            /* 120 */
            buffer.get(temp);
            /* 121 */
            setRemark(StringUtils.bytesToStr(temp));

        } catch (BufferUnderflowException bue) {
            /* 125 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 129 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 133 */
        return this;

    }


    public String toString() {
        /* 137 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 138 */
        if (ParamConstants.isDetail()) {
            /* 141 */
            buffer.append(",Result:");
            /* 142 */
            buffer.append(getResult());

            /* 144 */
            buffer.append(",Grp:");
            /* 145 */
            buffer.append(getGrpID());

            /* 147 */
            buffer.append(",Remark:");
            /* 148 */
            buffer.append(getRemark());

        } else {
            /* 152 */
            buffer.append(",");
            /* 153 */
            buffer.append(getResult());
            /* 154 */
            buffer.append(",");
            /* 155 */
            buffer.append(getGrpID());
            /* 156 */
            buffer.append(",");
            /* 157 */
            buffer.append(getRemark());

        }

        /* 160 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.CreateGrpResp
 * JD-Core Version:    0.6.0
 */