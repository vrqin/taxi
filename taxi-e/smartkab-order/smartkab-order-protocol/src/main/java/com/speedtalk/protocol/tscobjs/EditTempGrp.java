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


public class EditTempGrp extends TSCObject {
    private byte type;
    private byte msCount;
    private List<String> targetList;


    public EditTempGrp() {
        /*  64 */
        setMessID(57);

    }


    public EditTempGrp(byte type, byte msCount, List<String> targetList) {
        /*  68 */
        setMessID(57);
        /*  69 */
        this.type = type;
        /*  70 */
        this.msCount = msCount;
        /*  71 */
        this.targetList = targetList;

    }


    public byte getType() {
        /*  27 */
        return this.type;

    }


    public void setType(byte type) {
        /*  36 */
        this.type = type;

    }


    public byte getMsCount() {
        /*  40 */
        return this.msCount;

    }


    public void setMsCount(byte msCount) {
        /*  48 */
        this.msCount = msCount;

    }


    public List<String> getTargetList() {
        /*  52 */
        return this.targetList;

    }


    public void setTargetList(List<String> targetList) {
        /*  60 */
        this.targetList = targetList;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  76 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  77 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  78 */
        if ((getTargetList() == null) || (getTargetList().isEmpty()))
            /*  79 */
            throw new NullPointerException("ID list is NULL!");
        /*  80 */
        if (this.msCount != getTargetList().size())
            /*  81 */
            throw new MessageMistakenException("Count and list size unmatch!");

        try {
            /*  84 */
            int totalLength = 36 + getTargetList().size() * 11;
            /*  85 */
            short contentLength = (short) (totalLength - 34);
            /*  86 */
            ByteBuffer buffer = MessageUtils.createHead(totalLength, contentLength, getMessID(),
                    /*  87 */         0, this);
            /*  88 */
            buffer.put(getType());
            /*  89 */
            buffer.put(getMsCount());
            /*  90 */
            for (String str : getTargetList()) {
                /*  92 */
                buffer.put(StringUtils.strToBytes(str, 11));

            }
            /*  94 */
            buffer.putShort(MessageUtils.getCRC16(buffer, contentLength));
            /*  95 */
            buffer.put(MessIdConstants.ENDING);
            /*  96 */
            ArrayList resultList = new ArrayList();
            /*  97 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /*  98 */
            return resultList;

        } catch (Exception localException) {

        }
        /* 102 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 110 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 116 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 123 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 124 */
            setType(buffer.get());
            /* 125 */
            setMsCount(buffer.get());
            /* 126 */
            byte[] temp = new byte[11];
            /* 127 */
            List tempList = new ArrayList();
            /* 128 */
            int msCount = getMsCount();
            /* 129 */
            if (msCount > 0) {
                /* 131 */
                while (msCount > 0) {
                    /* 133 */
                    buffer.get(temp);
                    /* 134 */
                    tempList.add(StringUtils.bytesToStr(temp));
                    /* 135 */
                    msCount--;

                }

            } else {

                do {
                    /* 142 */
                    buffer.get(temp);
                    /* 143 */
                    tempList.add(StringUtils.bytesToStr(temp));

                }
                /* 140 */         while (buffer.remaining() >= 11);

            }

            /* 146 */
            setTargetList(tempList);

        } catch (BufferUnderflowException bue) {
            /* 150 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 154 */
            throw e;

        } catch (Exception localException2) {

        }
        /* 158 */
        return this;

    }


    public String toString() {
        /* 162 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 163 */
        if (ParamConstants.isDetail()) {
            /* 166 */
            buffer.append(",Type:");
            /* 167 */
            buffer.append(getType());

            /* 169 */
            buffer.append(",Ms count:");
            /* 170 */
            buffer.append(getMsCount());

            /* 172 */
            buffer.append(",Target msList:");

            try {
                /* 175 */
                for (String str : getTargetList()) {

                    try {
                        /* 179 */
                        buffer.append(str);
                        /* 180 */
                        buffer.append(";");

                    } catch (Exception localException) {

                    }

                }

            } catch (Exception localException1) {

            }

        } else {
            /* 191 */
            buffer.append(",");
            /* 192 */
            buffer.append(getType());

            /* 194 */
            buffer.append(",");
            /* 195 */
            buffer.append(getMsCount());

            /* 197 */
            buffer.append(",msList:");

            try {
                /* 200 */
                for (String str : getTargetList()) {

                    try {
                        /* 204 */
                        buffer.append(str);
                        /* 205 */
                        buffer.append(";");

                    } catch (Exception localException2) {

                    }

                }

            } catch (Exception localException3) {

            }

        }
        /* 215 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.EditTempGrp
 * JD-Core Version:    0.6.0
 */