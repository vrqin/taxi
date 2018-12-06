package com.speedtalk.protocol.utils;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageUtils {
    private static byte[] key = new byte[]{83, 112, 101, 101, 84, 97, 108, 107};
    private static AtomicInteger messNo = new AtomicInteger(1);

    public MessageUtils() {
    }

    public static byte getMessID(byte[] datas) throws NullPointerException, MessageMistakenException {
        if (datas == null) {
            throw new NullPointerException("Data is Null!");
        } else {
            return datas[4];
        }
    }

    public static void isComplete(byte[] datas)
            throws NullPointerException, MessageMistakenException, CheckMistakenException {
        try {
            isNull(datas);
            checkHeadAndEnding(datas);
            matchCheck(datas);
        } catch (NullPointerException var2) {
            throw var2;
        } catch (MessageMistakenException var3) {
            throw var3;
        } catch (CheckMistakenException var4) {
            throw var4;
        } catch (Exception var5) {
            ;
        }

    }

    public static void isNull(byte[] datas) throws NullPointerException {
        if (datas == null) {
            throw new NullPointerException("Data is Null!");
        }
    }

    public static void checkHeadAndEnding(byte[] datas) throws MessageMistakenException {
        if (datas != null && datas.length >= 2) {
            int length;
            for (length = 0; length < 2; ++length) {
                if (datas[length] != MessIdConstants.HEAD[length]) {
                    throw new MessageMistakenException("Data head error!" + StringUtils.bytesToHexStr(datas));
                }
            }

            length = datas.length;
            int i = length - 2;

            for (int j = 0; i < length; ++j) {
                if (datas[i] != MessIdConstants.ENDING[j]) {
                    throw new MessageMistakenException("Data head error!" + StringUtils.bytesToHexStr(datas));
                }

                ++i;
            }

        } else {
            throw new MessageMistakenException("Data head error!" + StringUtils.bytesToHexStr(datas));
        }
    }

    public static void checkLength(byte[] datas) throws MessageMistakenException {
        int dataLen = datas.length;
        if (dataLen < 34) {
            throw new MessageMistakenException("Data incomplete!Length:" + dataLen);
        } else {
            short contentLen = (short) ((datas[3] << 8) + datas[2]);
            if (contentLen != dataLen - 34) {
                throw new MessageMistakenException("Param length and content length unmatch!Param length:" + contentLen);
            }
        }
    }

    public static void matchCheck(byte[] datas) throws CheckMistakenException {
        int dataLen = datas.length - 6;
        byte[] temp = new byte[dataLen];
        System.arraycopy(datas, 2, temp, 0, dataLen);
        short calCrc = CRC16.crcTable(temp);
        temp = new byte[2];
        System.arraycopy(datas, dataLen - 3, temp, 0, 2);
        short srcCrc = CRC16.getShort(temp, false);
        if (calCrc != srcCrc) {
            throw new CheckMistakenException("CRC error!");
        }
    }

    public static ByteBuffer createHead(int messLen, short contentLen, byte messID, byte split, TSCObject obj)
            throws Exception {
        if (obj == null) {
            throw new NullPointerException("Tsc object is NULL!");
        } else if (obj.getSrcMsID() == null) {
            throw new NullPointerException("Src ms ID is NULL!");
        } else {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(messLen);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.put(MessIdConstants.HEAD);
                buffer.putShort(contentLen);
                buffer.put(messID);
                buffer.putShort(obj.getMessNo());
                buffer.put(split);
                buffer.put(StringUtils.strToBytes(obj.getSrcMsID(), 11));
                buffer.put(obj.getDstMsID() == null ? MessIdConstants.DEFAULT_ID : StringUtils.strToBytes(obj.getDstMsID(), 11));
                if (1 == split) {
                    buffer.putShort(obj.getTotalPack());
                    buffer.putShort(obj.getPackNo());
                }

                return buffer;
            } catch (Exception var6) {
                throw var6;
            }
        }
    }

    public static ByteBuffer parseHead(byte[] datas, TSCObject obj) throws Exception {
        if (datas == null) {
            throw new NullPointerException("Message is NULL!");
        } else {
            try {
                ByteBuffer buffer = ByteBuffer.wrap(datas);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.position(2);
                obj.setLength(buffer.getShort());
                obj.setMessID(buffer.get());
                obj.setMessNo(buffer.getShort());
                obj.setIsSplit(buffer.get());
                byte[] temp = new byte[11];
                buffer.get(temp);
                obj.setSrcMsID(StringUtils.bytesToStr(temp));
                buffer.get(temp);
                obj.setDstMsID(StringUtils.bytesToStr(temp));
                return buffer;
            } catch (Exception var4) {
                throw var4;
            }
        }
    }

    public static short getCRC16(ByteBuffer buffer, int contentLen) throws NullPointerException {
        if (buffer == null) {
            throw new NullPointerException("Data is Null!");
        } else {
            byte[] crcDatas = new byte[28 + contentLen];
            System.arraycopy(buffer.array(), 2, crcDatas, 0, crcDatas.length);
            return CRC16.crcTable(crcDatas);
        }
    }

    public static byte[] encryptAndDecrypt(byte[] data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("Data is Null!");
        } else {
            byte[] temps = new byte[data.length];

            for (int i = 0; i < data.length; ++i) {
                int j = i % key.length;
                temps[i] = (byte) (data[i] ^ key[j]);
            }

            return temps;
        }
    }

    public static byte[] encryptAndDecryptMess(byte[] data) throws NullPointerException, MessageMistakenException {
        if (data == null) {
            throw new NullPointerException("Data is Null!");
        } else {
            try {
                int bodyLen = data.length - 6;
                byte[] bodys = new byte[bodyLen];
                System.arraycopy(data, 4, bodys, 0, bodyLen);
                byte[] temps = new byte[data.length];
                System.arraycopy(data, 0, temps, 0, data.length);
                System.arraycopy(encryptAndDecrypt(bodys), 0, temps, 4, bodyLen);
                return temps;
            } catch (NullPointerException var4) {
                throw var4;
            } catch (NegativeArraySizeException var5) {
                throw new MessageMistakenException("Message len error!len:" + data.length);
            }
        }
    }

    public static synchronized short getFirstMessNo() {
        messNo.set(1);
        return (short) messNo.getAndIncrement();
    }

    public static synchronized short getMessNo() {
        return messNo.get() > 32767 ? getFirstMessNo() : (short) messNo.getAndIncrement();
    }
}
