package com.alipay.api.internal.util;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AlipayEncrypt {
    private static final String AES_ALG = "AES";
    private static final String AES_CBC_PCK_ALG = "AES/CBC/PKCS5Padding";
    /*  31 */   private static final byte[] AES_IV = initIv("AES/CBC/PKCS5Padding");


    public static String encryptContent(String content, String encryptType, String encryptKey, String charset)
            throws AlipayApiException {
        /*  46 */
        if ("AES".equals(encryptType)) {
            /*  48 */
            return aesEncrypt(content, encryptKey, charset);

        }

        /*  52 */
        throw new AlipayApiException("当前不支持该算法类型：encrypeType=" + encryptType);

    }


    public static String decryptContent(String content, String encryptType, String encryptKey, String charset)
            throws AlipayApiException {
        /*  70 */
        if ("AES".equals(encryptType)) {
            /*  72 */
            return aesDecrypt(content, encryptKey, charset);

        }

        /*  76 */
        throw new AlipayApiException("当前不支持该算法类型：encrypeType=" + encryptType);

    }


    private static String aesEncrypt(String content, String aesKey, String charset) throws AlipayApiException {

        try {
            /*  94 */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            /*  96 */
            IvParameterSpec iv = new IvParameterSpec(AES_IV);
            /*  97 */
            cipher.init(1, new SecretKeySpec(Base64.decodeBase64(aesKey.getBytes()), "AES"), iv);

            /* 100 */
            byte[] encryptBytes = cipher.doFinal(content.getBytes(charset));
            /* 101 */
            return new String(Base64.encodeBase64(encryptBytes));
        } catch (Exception e) {

        }
        /* 103 */
        throw new AlipayApiException("AES加密失败：Aescontent = " + content + "; charset = " + charset, e);

    }


    private static String aesDecrypt(String content, String key, String charset) throws AlipayApiException {

        try {
            /* 121 */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            /* 122 */
            IvParameterSpec iv = new IvParameterSpec(initIv("AES/CBC/PKCS5Padding"));
            /* 123 */
            cipher.init(2, new SecretKeySpec(Base64.decodeBase64(key.getBytes()), "AES"), iv);

            /* 126 */
            byte[] cleanBytes = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
            /* 127 */
            return new String(cleanBytes, charset);
        } catch (Exception e) {

        }
        /* 129 */
        throw new AlipayApiException("AES解密失败：Aescontent = " + content + "; charset = " + charset, e);

    }


    private static byte[] initIv(String fullAlg) {

        byte[] iv;

        try {
            /* 144 */
            Cipher cipher = Cipher.getInstance(fullAlg);
            /* 145 */
            int blockSize = cipher.getBlockSize();
            /* 146 */
            byte[] iv = new byte[blockSize];
            /* 147 */
            for (int i = 0; i < blockSize; i++) {
                /* 148 */
                iv[i] = 0;

            }
            /* 150 */
            return iv;

        } catch (Exception e) {
            /* 153 */
            int blockSize = 16;
            /* 154 */
            iv = new byte[blockSize];
            /* 155 */
            for (int i = 0; i < blockSize; i++)
                /* 156 */
                iv[i] = 0;

        }
        /* 158 */
        return iv;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AlipayEncrypt
 * JD-Core Version:    0.6.0
 */