package com.speedtalk.protocol.tscobjs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;

import java.util.ArrayList;
import java.util.List;

public class Upgrade extends TSCObject {
    private byte[] datas;

    public Upgrade() {
        /* 20 */
        setMessID(81);
    }

    public Upgrade(byte[] datas) {
        /* 24 */
        setMessID(81);
        /* 25 */
        this.datas = datas;
    }

    public byte[] getDatas() {
        /* 33 */
        return this.datas;
    }

    public void setDatas(byte[] datas) {
        /* 41 */
        this.datas = datas;
    }

    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        try {
            /* 49 */
            ArrayList resultList = new ArrayList();
            /* 50 */
            resultList.add(MessageUtils.encryptAndDecryptMess(getDatas()));
            /* 51 */
            return resultList;
        } catch (Exception localException) {
        }

        /* 57 */
        return null;
    }

    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {
        try {
            /* 65 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));
        } catch (Exception e) {
            try {
                /* 71 */
                throw e;
            } catch (Exception localException1) {
            }
        }
        try {
            /* 79 */
            setDatas(datas);
            /* 80 */
            MessageUtils.parseHead(datas, this);
        } catch (Exception localException2) {
        }

        /* 86 */
        return this;
    }

    public String toString() {
        /* 91 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 92 */
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.Upgrade
 * JD-Core Version:    0.6.0
 */