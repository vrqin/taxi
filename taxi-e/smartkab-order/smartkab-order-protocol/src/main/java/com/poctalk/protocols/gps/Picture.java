package com.poctalk.protocols.gps;

import com.poctalk.protocols.exceptions.MessageErrorException;
import com.poctalk.protocols.utils.GPSUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;

public class Picture {
    public Picture() {
    }

    public static byte[] parsePicCommand(byte[] data)
            throws NullPointerException, MessageErrorException, ParseException {
        try {
            GPSUtils.check(data);
        } catch (Exception var4) {
            throw var4;
        }


        if (data[20] != 9) {
            throw new MessageErrorException("非获取图片指令！");
        } else {
            byte[] resp = new byte[2];

            try {
                resp[0] = data[21];
                resp[1] = data[22];
                return resp;
            } catch (Exception var3) {
                throw new ParseException("解析获取图片指令异常！", 0);
            }
        }
    }

    public static byte[] pictureToBytes(String msID, byte channel, Gps gps, byte[] picData)
            throws NullPointerException {
        if (msID == null) {
            throw new NullPointerException("MSID NULL！");
        } else if (gps == null) {
            throw new NullPointerException("GPS 对象为NULL！");
        } else if (picData == null) {
            throw new NullPointerException("图片数据为空！");
        } else {
            try {
                byte[] tempGps = gps.parseBkPositionToBkGps();
                int gpsLength = tempGps.length - 23;
                byte[] gpsBytes = new byte[gpsLength];
                System.arraycopy(tempGps, 21, gpsBytes, 0, gpsLength);
                int dataLength = 1 + gpsLength + 1 + picData.length;
                ByteBuffer buffer = ByteBuffer.allocate(dataLength + 23);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.put(GpsConstants.HEAD);
                buffer.put((byte) 0);
                buffer.put(msID.substring(9).getBytes());
                buffer.put(GPSUtils.totalLenToByte(dataLength));
                buffer.put((byte) -119);
                buffer.put(gpsBytes);
                buffer.put(channel);
                buffer.put(picData);
                buffer.put((byte) 0);
                buffer.put((byte) 59);
                return buffer.array();
            } catch (Exception var9) {
                throw new IllegalArgumentException("封装数据异常！");
            }
        }
    }
}
