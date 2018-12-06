package com.speedtalk.protocol.ws;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class Utility {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public Utility() {
    }

    public static String byteToStr(byte[] datas) throws NullPointerException {
        try {
            StringBuilder buffer = new StringBuilder();
            String str = null;
            byte[] var6 = datas;
            int var5 = datas.length;

            for (int var4 = 0; var4 < var5; ++var4) {
                byte b = var6[var4];
                str = Integer.toHexString(b & 255);
                if (str.length() == 1) {
                    buffer.append("0");
                }

                buffer.append(str);
                buffer.append(" ");
            }

            return buffer.toString().toUpperCase();
        } catch (NullPointerException var7) {
            throw var7;
        }
    }

    public static byte[] strToByte(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException();
        } else {
            byte[] bytes = null;

            try {
                int len = str.length() / 2;
                bytes = new byte[len];
                int temp = false;

                for (int i = 0; i < len; ++i) {
                    int temp = Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
                    bytes[i] = (byte) temp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bytes;
        }
    }

    public static void main(String[] args) {
        Utility utility = new Utility();
        String msId = "12345601005";
        String pwd = "123456";
        System.out.println(utility.encryptAuthId(msId, pwd, utility.getAuthDateStr()));
        msId = "1";
        pwd = "192.168.1.251";
        System.out.println(utility.encryptAuthId(msId, pwd, utility.getAuthDateStr()));
    }

    private String getAuthDateStr() {
        return this.sdf.format(System.currentTimeMillis());
    }

    public String encryptAuthId(String msId, String pwd, String date) throws NullPointerException {
        if (msId != null && pwd != null && date != null) {
            String authId = msId + ":" + pwd + ":" + date;

            try {
                return this.encrypt(authId, "SpeedTalk");
            } catch (NullPointerException var6) {
                throw var6;
            }
        } else {
            throw new NullPointerException();
        }
    }

    private String encrypt(String data, String key) throws NullPointerException {
        if (data != null && key != null) {
            try {
                String md5Key = byteToStr(this.getMD5(key.getBytes()));
                byte[] keys = md5Key.replace(" ", "").substring(0, 8).getBytes();
                byte[] encryptData = this.cbcEncrypt(data.getBytes(), keys, keys);
                return byteToStr(encryptData).replace(" ", "");
            } catch (NullPointerException var6) {
                throw var6;
            }
        } else {
            throw new NullPointerException();
        }
    }

    private byte[] cbcEncrypt(byte[] datas, byte[] key, byte[] iv) throws NullPointerException {
        if (datas != null && key != null && iv != null) {
            try {
                DESKeySpec keySpec = new DESKeySpec(key);
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                SecretKey secretKey = keyFactory.generateSecret(keySpec);
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                IvParameterSpec ivSpec = new IvParameterSpec(iv);
                cipher.init(1, secretKey, ivSpec);
                return cipher.doFinal(datas);
            } catch (Exception var9) {
                return null;
            }
        } else {
            throw new NullPointerException();
        }
    }

    private byte[] getMD5(byte[] source) {
        byte[] md5Byte = null;
        if (source != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(source);
                md5Byte = md.digest();
            } catch (NoSuchAlgorithmException var4) {
                return null;
            }
        }

        return md5Byte;
    }
}
