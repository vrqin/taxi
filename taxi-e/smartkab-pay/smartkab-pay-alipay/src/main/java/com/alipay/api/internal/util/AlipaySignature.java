package com.alipay.api.internal.util;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.codec.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;


public class AlipaySignature {
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;


    public static String getSignatureContent(RequestParametersHolder requestHolder) {
        /*  43 */
        return getSignContent(getSortedMap(requestHolder));

    }


    public static Map<String, String> getSortedMap(RequestParametersHolder requestHolder) {
        /*  47 */
        Map sortedParams = new TreeMap();
        /*  48 */
        AlipayHashMap appParams = requestHolder.getApplicationParams();
        /*  49 */
        if ((appParams != null) && (appParams.size() > 0)) {
            /*  50 */
            sortedParams.putAll(appParams);

        }
        /*  52 */
        AlipayHashMap protocalMustParams = requestHolder.getProtocalMustParams();
        /*  53 */
        if ((protocalMustParams != null) && (protocalMustParams.size() > 0)) {
            /*  54 */
            sortedParams.putAll(protocalMustParams);

        }
        /*  56 */
        AlipayHashMap protocalOptParams = requestHolder.getProtocalOptParams();
        /*  57 */
        if ((protocalOptParams != null) && (protocalOptParams.size() > 0)) {
            /*  58 */
            sortedParams.putAll(protocalOptParams);

        }

        /*  61 */
        return sortedParams;

    }


    public static String getSignContent(Map<String, String> sortedParams) {
        /*  70 */
        StringBuilder content = new StringBuilder();
        /*  71 */
        List keys = new ArrayList(sortedParams.keySet());
        /*  72 */
        Collections.sort(keys);
        /*  73 */
        int index = 0;
        /*  74 */
        for (int i = 0; i < keys.size(); i++) {
            /*  75 */
            String key = (String) keys.get(i);
            /*  76 */
            String value = (String) sortedParams.get(key);
            /*  77 */
            if (StringUtils.areNotEmpty(new String[]{key, value})) {
                /*  78 */
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                /*  79 */
                index++;

            }

        }
        /*  82 */
        return content.toString();

    }


    public static String rsaSign(String content, String privateKey, String charset, String signType)
            throws AlipayApiException {
        /*  97 */
        if ("RSA".equals(signType)) {
            /*  99 */
            return rsaSign(content, privateKey, charset);
            /* 100 */
        }
        if ("RSA2".equals(signType)) {
            /* 102 */
            return rsa256Sign(content, privateKey, charset);

        }

        /* 105 */
        throw new AlipayApiException("Sign Type is Not Support : signType=" + signType);

    }


    public static String rsa256Sign(String content, String privateKey, String charset) throws AlipayApiException {

        try {
            /* 123 */
            PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

            /* 126 */
            Signature signature = Signature.getInstance("SHA256WithRSA");

            /* 129 */
            signature.initSign(priKey);

            /* 131 */
            if (StringUtils.isEmpty(charset))
                /* 132 */
                signature.update(content.getBytes());

            else {
                /* 134 */
                signature.update(content.getBytes(charset));

            }

            /* 137 */
            byte[] signed = signature.sign();

            /* 139 */
            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {

        }
        /* 141 */
        throw new AlipayApiException("RSAcontent = " + content + "; charset = " + charset, e);

    }


    public static String rsaSign(String content, String privateKey, String charset) throws AlipayApiException {

        try {
            /* 158 */
            PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

            /* 161 */
            Signature signature = Signature.getInstance("SHA1WithRSA");

            /* 164 */
            signature.initSign(priKey);

            /* 166 */
            if (StringUtils.isEmpty(charset))
                /* 167 */
                signature.update(content.getBytes());

            else {
                /* 169 */
                signature.update(content.getBytes(charset));

            }

            /* 172 */
            byte[] signed = signature.sign();

            /* 174 */
            return new String(Base64.encodeBase64(signed));

        } catch (InvalidKeySpecException ie) {
            /* 176 */
            throw new AlipayApiException("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", ie);
        } catch (Exception e) {

        }
        /* 178 */
        throw new AlipayApiException("RSAcontent = " + content + "; charset = " + charset, e);

    }


    public static String rsaSign(Map<String, String> params, String privateKey, String charset)
            throws AlipayApiException {
        /* 184 */
        String signContent = getSignContent(params);

        /* 186 */
        return rsaSign(signContent, privateKey, charset);

    }


    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        /* 192 */
        if ((ins == null) || (StringUtils.isEmpty(algorithm))) {
            /* 193 */
            return null;

        }

        /* 196 */
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        /* 198 */
        byte[] encodedKey = StreamUtil.readText(ins).getBytes();

        /* 200 */
        encodedKey = Base64.decodeBase64(encodedKey);

        /* 202 */
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));

    }


    public static String getSignCheckContentV1(Map<String, String> params) {
        /* 206 */
        if (params == null) {
            /* 207 */
            return null;

        }

        /* 210 */
        params.remove("sign");
        /* 211 */
        params.remove("sign_type");

        /* 213 */
        StringBuilder content = new StringBuilder();
        /* 214 */
        List keys = new ArrayList(params.keySet());
        /* 215 */
        Collections.sort(keys);

        /* 217 */
        for (int i = 0; i < keys.size(); i++) {
            /* 218 */
            String key = (String) keys.get(i);
            /* 219 */
            String value = (String) params.get(key);
            /* 220 */
            content.append((i == 0 ? "" : "&") + key + "=" + value);

        }

        /* 223 */
        return content.toString();

    }


    public static String getSignCheckContentV2(Map<String, String> params) {
        /* 227 */
        if (params == null) {
            /* 228 */
            return null;

        }

        /* 231 */
        params.remove("sign");

        /* 233 */
        StringBuilder content = new StringBuilder();
        /* 234 */
        List keys = new ArrayList(params.keySet());
        /* 235 */
        Collections.sort(keys);

        /* 237 */
        for (int i = 0; i < keys.size(); i++) {
            /* 238 */
            String key = (String) keys.get(i);
            /* 239 */
            String value = (String) params.get(key);
            /* 240 */
            content.append((i == 0 ? "" : "&") + key + "=" + value);

        }

        /* 243 */
        return content.toString();

    }


    public static boolean rsaCheckV1(Map<String, String> params, String publicKey, String charset)
            throws AlipayApiException {
        /* 248 */
        String sign = (String) params.get("sign");
        /* 249 */
        String content = getSignCheckContentV1(params);

        /* 251 */
        return rsaCheckContent(content, sign, publicKey, charset);

    }


    public static boolean rsaCheckV2(Map<String, String> params, String publicKey, String charset)
            throws AlipayApiException {
        /* 256 */
        String sign = (String) params.get("sign");
        /* 257 */
        String content = getSignCheckContentV2(params);

        /* 259 */
        return rsaCheckContent(content, sign, publicKey, charset);

    }


    public static boolean rsaCheck(String content, String sign, String publicKey, String charset, String signType)
            throws AlipayApiException {
        /* 265 */
        if ("RSA".equals(signType)) {
            /* 267 */
            return rsaCheckContent(content, sign, publicKey, charset);

        }
        /* 269 */
        if ("RSA2".equals(signType)) {
            /* 271 */
            return rsa256CheckContent(content, sign, publicKey, charset);

        }

        /* 275 */
        throw new AlipayApiException("Sign Type is Not Support : signType=" + signType);

    }


    public static boolean rsa256CheckContent(String content, String sign, String publicKey, String charset)
            throws AlipayApiException {

        try {
            /* 283 */
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

            /* 286 */
            Signature signature = Signature.getInstance("SHA256WithRSA");

            /* 289 */
            signature.initVerify(pubKey);

            /* 291 */
            if (StringUtils.isEmpty(charset))
                /* 292 */
                signature.update(content.getBytes());

            else {
                /* 294 */
                signature.update(content.getBytes(charset));

            }

            /* 297 */
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {

        }
        /* 299 */
        throw new AlipayApiException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);

    }


    public static boolean rsaCheckContent(String content, String sign, String publicKey, String charset)
            throws AlipayApiException {

        try {
            /* 307 */
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

            /* 310 */
            Signature signature = Signature.getInstance("SHA1WithRSA");

            /* 313 */
            signature.initVerify(pubKey);

            /* 315 */
            if (StringUtils.isEmpty(charset))
                /* 316 */
                signature.update(content.getBytes());

            else {
                /* 318 */
                signature.update(content.getBytes(charset));

            }

            /* 321 */
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {

        }
        /* 323 */
        throw new AlipayApiException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);

    }


    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        /* 330 */
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        /* 332 */
        StringWriter writer = new StringWriter();
        /* 333 */
        StreamUtil.io(new InputStreamReader(ins), writer);

        /* 335 */
        byte[] encodedKey = writer.toString().getBytes();

        /* 337 */
        encodedKey = Base64.decodeBase64(encodedKey);

        /* 339 */
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

    }


    public static String checkSignAndDecrypt(Map<String, String> params, String alipayPublicKey, String cusPrivateKey, boolean isCheckSign, boolean isDecrypt)
            throws AlipayApiException {
        /* 365 */
        String charset = (String) params.get("charset");
        /* 366 */
        String bizContent = (String) params.get("biz_content");
        /* 367 */
        if ((isCheckSign) &&
                /* 368 */       (!rsaCheckV2(params, alipayPublicKey, charset))) {
            /* 369 */
            throw new AlipayApiException("rsaCheck failure:rsaParams=" + params);

        }

        /* 373 */
        if (isDecrypt) {
            /* 374 */
            return rsaDecrypt(bizContent, cusPrivateKey, charset);

        }

        /* 377 */
        return bizContent;

    }


    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset, boolean isEncrypt, boolean isSign)
            throws AlipayApiException {
        /* 404 */
        StringBuilder sb = new StringBuilder();
        /* 405 */
        if (StringUtils.isEmpty(charset)) {
            /* 406 */
            charset = "GBK";

        }
        /* 408 */
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        /* 409 */
        if (isEncrypt) {
            /* 410 */
            sb.append("<alipay>");
            /* 411 */
            String encrypted = rsaEncrypt(bizContent, alipayPublicKey, charset);
            /* 412 */
            sb.append("<response>" + encrypted + "</response>");
            /* 413 */
            sb.append("<encryption_type>RSA</encryption_type>");
            /* 414 */
            if (isSign) {
                /* 415 */
                String sign = rsaSign(encrypted, cusPrivateKey, charset);
                /* 416 */
                sb.append("<sign>" + sign + "</sign>");
                /* 417 */
                sb.append("<sign_type>RSA</sign_type>");

            }
            /* 419 */
            sb.append("</alipay>");
            /* 420 */
        } else if (isSign) {
            /* 421 */
            sb.append("<alipay>");
            /* 422 */
            sb.append("<response>" + bizContent + "</response>");
            /* 423 */
            String sign = rsaSign(bizContent, cusPrivateKey, charset);
            /* 424 */
            sb.append("<sign>" + sign + "</sign>");
            /* 425 */
            sb.append("<sign_type>RSA</sign_type>");
            /* 426 */
            sb.append("</alipay>");

        } else {
            /* 428 */
            sb.append(bizContent);

        }
        /* 430 */
        return sb.toString();

    }


    public static String rsaEncrypt(String content, String publicKey, String charset) throws AlipayApiException {

        try {
            /* 445 */
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

            /* 447 */
            Cipher cipher = Cipher.getInstance("RSA");
            /* 448 */
            cipher.init(1, pubKey);
            /* 449 */
            byte[] data = StringUtils.isEmpty(charset) ? content.getBytes() : content.getBytes(charset);

            /* 451 */
            int inputLen = data.length;
            /* 452 */
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            /* 453 */
            int offSet = 0;

            /* 455 */
            int i = 0;

            /* 457 */
            while (inputLen - offSet > 0) {

                byte[] cache;

                byte[] cache;
                /* 458 */
                if (inputLen - offSet > 117)
                    /* 459 */
                    cache = cipher.doFinal(data, offSet, 117);

                else {
                    /* 461 */
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);

                }
                /* 463 */
                out.write(cache, 0, cache.length);
                /* 464 */
                i++;
                /* 465 */
                offSet = i * 117;

            }
            /* 467 */
            byte[] encryptedData = Base64.encodeBase64(out.toByteArray());
            /* 468 */
            out.close();

            /* 470 */
            return StringUtils.isEmpty(charset) ? new String(encryptedData) : new String(encryptedData, charset);

        } catch (Exception e) {

        }
        /* 473 */
        throw new AlipayApiException("EncryptContent = " + content + ",charset = " + charset, e);

    }


    public static String rsaDecrypt(String content, String privateKey, String charset) throws AlipayApiException {

        try {
            /* 490 */
            PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

            /* 492 */
            Cipher cipher = Cipher.getInstance("RSA");
            /* 493 */
            cipher.init(2, priKey);
            /* 494 */
            byte[] encryptedData = StringUtils.isEmpty(charset) ? Base64.decodeBase64(content.getBytes()) : Base64.decodeBase64(content
                    .getBytes(charset));

            /* 497 */
            int inputLen = encryptedData.length;
            /* 498 */
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            /* 499 */
            int offSet = 0;

            /* 501 */
            int i = 0;

            /* 503 */
            while (inputLen - offSet > 0) {

                byte[] cache;

                byte[] cache;
                /* 504 */
                if (inputLen - offSet > 128)
                    /* 505 */
                    cache = cipher.doFinal(encryptedData, offSet, 128);

                else {
                    /* 507 */
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);

                }
                /* 509 */
                out.write(cache, 0, cache.length);
                /* 510 */
                i++;
                /* 511 */
                offSet = i * 128;

            }
            /* 513 */
            byte[] decryptedData = out.toByteArray();
            /* 514 */
            out.close();

            /* 516 */
            return StringUtils.isEmpty(charset) ? new String(decryptedData) : new String(decryptedData, charset);

        } catch (Exception e) {

        }
        /* 519 */
        throw new AlipayApiException("EncodeContent = " + content + ",charset = " + charset, e);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AlipaySignature
 * JD-Core Version:    0.6.0
 */