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


public class CreateTempGrp extends TSCObject {
    private byte idCount;
    private List<String> targetList;


    public CreateTempGrp() {
        /*  50 */
        setMessID(37);

    }


    public CreateTempGrp(byte idCount, List<String> idList) {
        /*  54 */
        setMessID(37);
        /*  55 */
        this.idCount = idCount;
        /*  56 */
        this.targetList = idList;

    }


    public byte getIdCount() {
        /*  26 */
        return this.idCount;

    }


    public void setIdCount(byte idCount) {
        /*  34 */
        this.idCount = idCount;

    }


    public List<String> getTargetList() {
        /*  38 */
        return this.targetList;

    }


    public void setTargetList(List<String> targetList) {
        /*  46 */
        this.targetList = targetList;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  61 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  62 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  63 */
        if ((getTargetList() == null) || (getTargetList().isEmpty())) {
            /*  64 */
            throw new NullPointerException("ID list is NULL!");

        }


        try {
            /*  69 */
            int totalLength = 35 + getTargetList().size() * 11;
            /*  70 */
            short contentLength = (short) (totalLength - 34);
            /*  71 */
            ByteBuffer buffer = MessageUtils.createHead(totalLength, contentLength, getMessID(),
                    /*  72 */         0, this);
            /*  73 */
            buffer.put(this.idCount);
            /*  74 */
            for (String str : getTargetList()) {
                /*  76 */
                buffer.put(StringUtils.strToBytes(str, 11));

            }
            /*  78 */
            buffer.putShort(MessageUtils.getCRC16(buffer, contentLength));
            /*  79 */
            buffer.put(MessIdConstants.ENDING);
            /*  80 */
            ArrayList resultList = new ArrayList();
            /*  81 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  82 */
            return resultList;

        } catch (Exception localException) {

        }
        /*  86 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /*  94 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 100 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 108 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 109 */
            setIdCount(buffer.get());
            /* 110 */
            byte[] temp = new byte[11];
            /* 111 */
            List tempList = new ArrayList();
            /* 112 */
            int idCount = getIdCount();
            /* 113 */
            if (idCount > 0) {
                /* 115 */
                while (idCount > 0) {
                    /* 117 */
                    buffer.get(temp);
                    /* 118 */
                    tempList.add(StringUtils.bytesToStr(temp));
                    /* 119 */
                    idCount--;

                }

            } else {

                do {
                    /* 126 */
                    buffer.get(temp);
                    /* 127 */
                    tempList.add(StringUtils.bytesToStr(temp));

                }
                /* 124 */         while (buffer.remaining() >= 11);

            }

            /* 131 */
            setTargetList(tempList);

        } catch (BufferUnderflowException bue) {
            /* 135 */
            bue.printStackTrace();
            /* 136 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 140 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 144 */
        return this;

    }


    public String toString() {
        /* 148 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 149 */
        if (ParamConstants.isDetail()) {
            /* 152 */
            buffer.append(",Grp's ms count:");
            /* 153 */
            buffer.append(getIdCount());

            /* 155 */
            buffer.append(",Ms:");

            try {
                /* 158 */
                for (String str : getTargetList()) {

                    try {
                        /* 162 */
                        buffer.append(str);
                        /* 163 */
                        buffer.append(";");

                    } catch (Exception localException) {

                    }

                }

            } catch (Exception localException1) {

            }

        } else {
            /* 174 */
            buffer.append(",");
            /* 175 */
            buffer.append(getIdCount());
            /* 176 */
            buffer.append(",Ms:");

            try {
                /* 179 */
                for (String str : getTargetList()) {

                    try {
                        /* 183 */
                        buffer.append(str);
                        /* 184 */
                        buffer.append(";");

                    } catch (Exception localException2) {

                    }

                }

            } catch (Exception localException3) {

            }

        }
        /* 194 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.CreateTempGrp
 * JD-Core Version:    0.6.0
 */