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


public final class LoginResp extends TSCObject {
    private byte result;
    private String msName;
    private String grpID;
    private String grpName;
    private String remark;


    public LoginResp() {
        /* 109 */
        setMessID(4);

    }


    public LoginResp(byte result, String msName, String grpID, String grpName, String remark) {
        /* 113 */
        setMessID(4);
        /* 114 */
        this.result = result;
        /* 115 */
        this.msName = msName;
        /* 116 */
        this.grpID = grpID;
        /* 117 */
        this.grpName = grpName;
        /* 118 */
        this.remark = remark;

    }


    public byte getResult() {
        /*  47 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  57 */
        this.result = result;

    }


    public String getMsName() {
        /*  61 */
        return this.msName;

    }


    public void setMsName(String msName) {
        /*  69 */
        this.msName = msName;

    }


    public String getGrpID() {
        /*  73 */
        return this.grpID;

    }


    public void setGrpID(String grpID) {
        /*  81 */
        this.grpID = grpID;

    }


    public String getGrpName() {
        /*  85 */
        return this.grpName;

    }


    public void setGrpName(String grpName) {
        /*  93 */
        this.grpName = grpName;

    }


    public String getRemark() {
        /*  97 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 105 */
        this.remark = remark;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 123 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /* 124 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /* 127 */
            ByteBuffer buffer = MessageUtils.createHead(106,
                    /* 128 */         72, getMessID(), 0,
                    /* 129 */         this);
            /* 130 */
            buffer.put(getResult());
            /* 131 */
            if (getResult() != 0) {
                /* 136 */
                buffer.put(new byte[51]);

            } else {
                /* 140 */
                buffer.put(StringUtils.strToBytes(getMsName(), 20));
                /* 141 */
                buffer.put(StringUtils.strToBytes(getGrpID(), 11));
                /* 142 */
                buffer.put(StringUtils.strToBytes(getGrpName(), 20));

            }
            /* 144 */
            buffer.put(StringUtils.strToBytes(getRemark(), 20));
            /* 145 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 72));
            /* 146 */
            buffer.put(MessIdConstants.ENDING);
            /* 147 */
            ArrayList resultList = new ArrayList();
            /* 148 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 149 */
            return resultList;

        } catch (Exception e) {
            /* 153 */
            e.printStackTrace();

        }
        /* 155 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 163 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 169 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 176 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 177 */
            setResult(buffer.get());
            /* 178 */
            byte[] temp2 = new byte[20];
            /* 179 */
            buffer.get(temp2);
            /* 180 */
            setMsName(StringUtils.bytesToStr(temp2));
            /* 181 */
            byte[] temp = new byte[11];
            /* 182 */
            buffer.get(temp);
            /* 183 */
            setGrpID(StringUtils.bytesToStr(temp));
            /* 184 */
            buffer.get(temp2);
            /* 185 */
            setGrpName(StringUtils.bytesToStr(temp2));
            /* 186 */
            buffer.get(temp2);
            /* 187 */
            setRemark(StringUtils.bytesToStr(temp2));

        } catch (BufferUnderflowException bue) {
            /* 191 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 195 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 201 */
        return this;

    }


    public String toString() {
        /* 205 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 206 */
        if (ParamConstants.isDetail()) {
            /* 209 */
            buffer.append(",Result:");
            /* 210 */
            buffer.append(getResult());

            /* 212 */
            buffer.append(",Name:");
            /* 213 */
            buffer.append(getMsName());

            /* 215 */
            buffer.append(",Grp:");
            /* 216 */
            buffer.append(getGrpID());

            /* 218 */
            buffer.append(",Grp's name:");
            /* 219 */
            buffer.append(getGrpName());

            /* 221 */
            buffer.append(",Remark:");
            /* 222 */
            buffer.append(getRemark());

        } else {
            /* 226 */
            buffer.append(",");
            /* 227 */
            buffer.append(getMsName());
            /* 228 */
            buffer.append(",");
            /* 229 */
            buffer.append(getGrpID());
            /* 230 */
            buffer.append(",");
            /* 231 */
            buffer.append(getGrpName());
            /* 232 */
            buffer.append(",");
            /* 233 */
            buffer.append(getRemark());

        }

        /* 236 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.LoginResp
 * JD-Core Version:    0.6.0
 */