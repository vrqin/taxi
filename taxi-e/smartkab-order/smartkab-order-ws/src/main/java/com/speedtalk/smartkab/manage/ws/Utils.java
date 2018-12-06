package com.speedtalk.smartkab.manage.ws;

public class Utils {
    private static byte[] key = {0x63, 0x68, 0x65, 0x6E, 0x5F, 0x70, 0x69};

    public static byte[] encrypt(byte[] data) throws NullPointerException {
        if (data == null)
            throw new NullPointerException("Data is Null!");
        byte[] temps = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            int j = i % key.length;
            temps[i] = (byte) (data[i] ^ key[j]);
        }
        return temps;
    }

    public static void main(String[] args) {
        System.out.println(new String(encrypt("RQW@nFQMYK_oISRXU^eA".getBytes())));
    }
}
