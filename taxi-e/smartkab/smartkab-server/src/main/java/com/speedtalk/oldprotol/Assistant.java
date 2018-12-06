package com.speedtalk.oldprotol;

import java.io.UnsupportedEncodingException;

public class Assistant {
    public static byte[] strToBytes(String str, String charsetName, int len) throws UnsupportedEncodingException {
        if (null == str)
            return new byte[len];
        byte[] srcs = null;
        if (null == charsetName || charsetName.trim().equals(""))
            srcs = str.getBytes();
        else
            srcs = str.getBytes(charsetName);
        byte[] bytes = null;
        if (len < 0)
            bytes = new byte[srcs.length];
        else
            bytes = new byte[len];
        if (len < 0 || len > srcs.length)
            len = srcs.length;

        System.arraycopy(str.getBytes(), 0, bytes, 0, len);
        return bytes;
    }

    public static String bytesToStr(byte[] bs, String charsetName) throws UnsupportedEncodingException {
        if (null == bs)
            return null;
        int position = 0;
        for (byte b : bs)
            if (b != 0x0)
                position++;
        byte[] newBs = new byte[position];
        System.arraycopy(bs, 0, newBs, 0, position);
        if (null == charsetName || charsetName.trim().equals(""))
            return new String(newBs);
        else
            return new String(newBs, charsetName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Assistant.strToBytes("a", null, -3).length);
        System.out.println(Assistant.strToBytes("a", null, 0).length);
        System.out.println(Assistant.strToBytes("a", null, 1).length);
        System.out.println(Assistant.strToBytes("a", null, 3).length);
    }
}
