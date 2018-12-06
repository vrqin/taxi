package com.speedtalk.pay.wechat;

import com.speedtalk.pay.wechat.domin.WeChatPay;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Utils {
    private final static String RANDOM_CODE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static int RANDOM_SIZE = 62;
    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 生成随机数算法
     * 比如用于微信支付API接口协议中包含字段nonce_str。
     *
     * @param length 指定生成随机数的位数，最大32位。
     * @return IllegalArgumentException 当length < 0
     */
    public static String getRandomNum(int length) throws IllegalArgumentException {
        if (length < 0)
            throw new IllegalArgumentException();
        StringBuilder stringBuilder = new StringBuilder();
        int len = length > 32 ? 32 : length;
        for (int i = 0; i < len; i++)
            stringBuilder.append(RANDOM_CODE.charAt(random.nextInt(RANDOM_SIZE)));
        return stringBuilder.toString();
    }

    public static String getMD5Str(String str) throws NullPointerException {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
            return null;
        }
        byte[] md5Bs = md5.digest(str.getBytes());

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : md5Bs)
            stringBuilder.append(String.format("%02X", b));
        return stringBuilder.toString();
    }

    /**
     * 将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序）,
     * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串stringA
     *
     * @param m
     * @return
     * @throws NullPointerException map为空
     */
    public static String toUrlParams(Map<String, String> m) throws NullPointerException {
        if (null == m)
            throw new NullPointerException("m is null");
        Map<String, String> map;
        //按字典顺序排序
        if (!(m instanceof TreeMap)) {
            map = new TreeMap<>(m);
        } else {
            map = m;
        }
        StringBuilder buf = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (null == entry.getValue() || entry.getValue().trim().equals(""))
                continue;
            buf.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        int len = buf.length();
        if (len > 0)
            buf.setLength(len - 1);
        return buf.toString();
    }

    public static Map<String, String> toMap(WeChatPay pay) throws NullPointerException {
        if (null == pay)
            throw new NullPointerException("pay is null");
        Map<String, String> map = new TreeMap<>();
        try {
            String value;

            Class<Object> sClass = (Class<Object>) pay.getClass().getSuperclass();
            Field[] fields = sClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                value = (String) field.get(pay);
                if (value != null && !value.trim().equals(""))
                    map.put(field.getName(), value);
            }
            Class<WeChatPay> payClass = (Class<WeChatPay>) pay.getClass();
            fields = payClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                value = (String) field.get(pay);
                if (value != null && !value.trim().equals(""))
                    map.put(field.getName(), value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getSign(WeChatPay pay, String key) throws NullPointerException {
        if (null == pay)
            throw new NullPointerException("pay is null");
        if (null == key)
            throw new NullPointerException("key is null");
        Map<String, String> map = toMap(pay);
        String urlParams = toUrlParams(map);
        String stringSignTemp = urlParams + "&key=" + key;
        return getMD5Str(stringSignTemp).toUpperCase();
    }

    public static String getSign(Map<String, String> map, String key) throws NullPointerException {
        if (null == map)
            throw new NullPointerException("map is null");
        if (null == key)
            throw new NullPointerException("key is null");
        String urlParams = toUrlParams(map);
        String stringSignTemp = urlParams + "&key=" + key;

        return getMD5Str(stringSignTemp).toUpperCase();
    }

    public static String toXml(WeChatPay pay) throws NullPointerException {
        Map<String, String> map = toMap(pay);
        StringBuilder xml = new StringBuilder("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            xml.append("<")
                    .append(entry.getKey())
                    .append(">")
                    .append(entry.getValue())
                    .append("</")
                    .append(entry.getKey())
                    .append(">");
        }
        xml.append("</xml>");
        return xml.toString();
    }

    public static Map<String, String> parseXmlStr(String xmlStr) throws Exception {
        if (null == xmlStr)
            throw new NullPointerException("xmlStr is null");
        Map<String, String> map = new TreeMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException pce) {
            throw pce;
        }
        Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));

        Element root = doc.getDocumentElement();
        NodeList books = root.getChildNodes();
        if (books != null) {
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                map.put(book.getNodeName(), book.getFirstChild().getNodeValue());
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getRandomNum(32).toUpperCase());
    }
}
