package com.poctalk.protocols.gps;

import com.poctalk.protocols.exceptions.MessageErrorException;
import com.poctalk.protocols.utils.GPSUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;

public class SMS {
    public SMS() {
    }

    public static String getSMSContent(byte[] data) throws NullPointerException, MessageErrorException, ParseException {
        try {
            GPSUtils.check(data);
        } catch (NullPointerException var5) {
            throw var5;
        } catch (MessageErrorException var6) {
            throw var6;
        }

        if (data[20] != 32) {
            throw new MessageErrorException("非短信指令！");
        } else {
            int contentLength = data.length - 23;
            if (contentLength == 0) {
                return "";
            } else {
                byte[] content = new byte[contentLength];
                System.arraycopy(data, 21, content, 0, contentLength);

                try {
                    return new String(content, "GBK");
                } catch (UnsupportedEncodingException var4) {
                    return new String(content);
                }
            }
        }
    }

    public static byte[] getSMSContentBytes(byte[] data)
            throws NullPointerException, MessageErrorException, ParseException {
        try {
            GPSUtils.check(data);
        } catch (NullPointerException var3) {
            throw var3;
        } catch (MessageErrorException var4) {
            throw var4;
        }

        if (data[20] != 32) {
            throw new MessageErrorException("非短信指令！");
        } else {
            int contentLength = data.length - 23;
            if (contentLength == 0) {
                return null;
            } else {
                byte[] content = new byte[contentLength];
                System.arraycopy(data, 21, content, 0, contentLength);
                return content;
            }
        }
    }

    public static byte[] smsToBytes(String shortMSID, String sms)
            throws NullPointerException, IllegalArgumentException {
        if (shortMSID == null) {
            throw new NullPointerException("MSID NULL！");
        } else if (shortMSID.length() != 12) {
            throw new IllegalArgumentException("非12位的MSID！");
        } else if (sms == null) {
            throw new NullPointerException("短信内容为NULL！");
        } else {
            ByteBuffer buffer = ByteBuffer.allocate(512);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            byte[] smsBytes = (byte[]) null;

            try {
                smsBytes = sms.getBytes("GBK");
            } catch (UnsupportedEncodingException var5) {
                smsBytes = sms.getBytes();
            }

            buffer.put(GpsConstants.HEAD);
            buffer.put((byte) 0);
            buffer.put(shortMSID.getBytes());
            buffer.put(GPSUtils.totalLenToByte(smsBytes.length + 1));
            buffer.put((byte) 32);
            buffer.put(smsBytes);
            buffer.put((byte) 0);
            buffer.put((byte) 59);
            int totalLength = buffer.position();
            smsBytes = new byte[totalLength];
            System.arraycopy(buffer.array(), 0, smsBytes, 0, totalLength);
            return smsBytes;
        }
    }

    public static byte[] smsToBytes(String shortMSID, byte[] sms)
            throws NullPointerException, IllegalArgumentException {
        if (shortMSID == null) {
            throw new NullPointerException("MSID NULL！");
        } else if (shortMSID.length() != 12) {
            throw new IllegalArgumentException("非12位的MSID！");
        } else if (sms == null) {
            throw new NullPointerException("短信内容为NULL！");
        } else {
            ByteBuffer buffer = ByteBuffer.allocate(512);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.put(GpsConstants.HEAD);
            buffer.put((byte) 0);
            buffer.put(shortMSID.getBytes());
            buffer.put(GPSUtils.totalLenToByte(sms.length + 1));
            buffer.put((byte) 32);
            buffer.put(sms);
            buffer.put((byte) 0);
            buffer.put((byte) 59);
            int totalLength = buffer.position();
            byte[] smsBytes = new byte[totalLength];
            System.arraycopy(buffer.array(), 0, smsBytes, 0, totalLength);
            return smsBytes;
        }
    }
}
