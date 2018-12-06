package com.speedtalk.protocol.utils;

import java.nio.ByteBuffer;

public class StringUtils {
    private static String encoding = System.getProperty("file.encoding");

    public StringUtils() {
    }

    public static String getEncoding() {
        return encoding;
    }

    public static void setEncoding(String encoding) {
        encoding = encoding;
    }

    public static String bytesToStr(byte[] datas) {
        if (datas == null) {
            return "";
        } else {
            int i = 0;
            byte[] var5 = datas;
            int var4 = datas.length;

            for (int var3 = 0; var3 < var4; ++var3) {
                byte b = var5[var3];
                if (b == 0) {
                    break;
                }

                ++i;
            }

            try {
                byte[] temp = new byte[i];
                System.arraycopy(datas, 0, temp, 0, i);
                return new String(temp, encoding);
            } catch (Exception var6) {
                return "";
            }
        }
    }

    public static void clearBuffer(ByteBuffer buffer) {
        buffer.compact();
        buffer.clear();
    }

    public static String bytesToHexStr(byte[] data) {
        StringBuilder buffer = new StringBuilder();
        String temp = null;

        try {
            byte[] var6 = data;
            int var5 = data.length;

            for (int var4 = 0; var4 < var5; ++var4) {
                byte b = var6[var4];
                temp = Integer.toHexString(b & 255);
                if (temp.length() == 1) {
                    buffer.append("0");
                    buffer.append(temp);
                } else {
                    buffer.append(temp);
                }

                buffer.append(" ");
            }
        } catch (Exception var7) {
            ;
        }

        return buffer.toString().toUpperCase();
    }

    public static byte[] strToBytes(String str, int length) {
        byte[] temp = new byte[length];

        try {
            byte[] strTemp = str.getBytes(encoding);
            if (strTemp.length > length) {
                System.arraycopy(strTemp, 0, temp, 0, length);
            } else {
                System.arraycopy(strTemp, 0, temp, 0, strTemp.length);
            }
        } catch (Exception var4) {
            ;
        }

        return temp;
    }
}
