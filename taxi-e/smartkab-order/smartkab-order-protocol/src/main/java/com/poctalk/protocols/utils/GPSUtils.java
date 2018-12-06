package com.poctalk.protocols.utils;

import com.poctalk.protocols.exceptions.MessageErrorException;
import com.poctalk.protocols.gps.GpsConstants;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GPSUtils {
    public GPSUtils() {
    }

    public static byte[] dataToMoGPS(String msID, byte[] gpsData) throws NullPointerException {
        int totalLen = 42 + gpsData.length;
        ByteBuffer buffer = ByteBuffer.allocate(totalLen);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(totalLen);
        buffer.putInt(19);
        buffer.putInt(1);
        buffer.put((byte) 1);
        buffer.put(msID.getBytes());
        buffer.put(gpsData);
        buffer.put(GpsConstants.RESERVE);
        return buffer.array();
    }

    public static byte[] dataToMtGPS(byte[] gpsData) throws NullPointerException {
        if (gpsData == null) {
            throw new NullPointerException("gpsData is NULL!");
        } else {
            int totalLen = gpsData.length + 20;
            ByteBuffer buffer = ByteBuffer.allocate(totalLen);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putInt(totalLen);
            buffer.putInt(20);
            buffer.putInt(0);
            buffer.put(gpsData);
            buffer.put(GpsConstants.RESERVE);
            return buffer.array();
        }
    }

    public static byte[] totalLenToByte(int totalLen) {
        byte[] len = new byte[]{(byte) (totalLen & 255), (byte) (totalLen >>> 8 & 255), (byte) (totalLen >>> 16 & 255)};
        return len;
    }

    public static int parseTotalLen(byte[] data) throws NullPointerException, MessageErrorException {
        try {
            check(data);
            byte[] gpsLenBytes = new byte[3];
            System.arraycopy(data, 17, gpsLenBytes, 0, 3);
            return (gpsLenBytes[2] << 16) + (gpsLenBytes[1] << 8) + gpsLenBytes[0] - 1;
        } catch (NullPointerException var2) {
            throw var2;
        } catch (MessageErrorException var3) {
            throw var3;
        }
    }

    public static byte[] createNoParamResp(byte commandID, String vehicleNum)
            throws NullPointerException, IllegalArgumentException {
        ByteBuffer buffer = ByteBuffer.allocate(23);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(GpsConstants.HEAD);
        buffer.put((byte) 0);

        try {
            if (vehicleNum.length() != 12) {
                throw new IllegalArgumentException("非法车辆ID！");
            }

            buffer.put(vehicleNum.getBytes());
        } catch (NullPointerException var4) {
            throw new NullPointerException("车辆ID空值！");
        }

        buffer.put(totalLenToByte(1));
        buffer.put(commandID);
        buffer.put((byte) 0);
        buffer.put((byte) 59);
        return buffer.array();
    }

    public static byte[] alarmResp(String vehicleNum) throws NullPointerException, IllegalArgumentException {
        return createNoParamResp((byte) 15, vehicleNum);
    }

    public static byte[] smsResp(String vehicleNum) throws NullPointerException, IllegalArgumentException {
        return createNoParamResp((byte) -96, vehicleNum);
    }

    public static void check(byte[] data) throws NullPointerException, MessageErrorException {
        if (data == null) {
            throw new NullPointerException("协议数据为NULL！");
        } else {
            int length = data.length;
            if (length < 23) {
                throw new MessageErrorException("数据不全！");
            } else if (data[0] != -86 || data[1] != 85 || data[2] != -86 || data[3] != 85 || data[length - 1] != 59) {
                throw new MessageErrorException("数据错误！");
            }
        }
    }

    public static String getShortMsID(byte[] bkGpsData) throws NullPointerException {
        if (bkGpsData == null) {
            throw new NullPointerException("bkGpsData数据为空！");
        } else {
            try {
                byte[] msIDArray = new byte[12];
                System.arraycopy(bkGpsData, 5, msIDArray, 0, 12);
                return new String(msIDArray);
            } catch (Exception var2) {
                throw new NullPointerException("bkGpsData数据错误！");
            }
        }
    }
}
