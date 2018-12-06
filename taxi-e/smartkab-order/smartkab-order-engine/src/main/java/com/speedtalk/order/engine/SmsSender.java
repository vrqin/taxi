package com.speedtalk.order.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsSender {
    public static final String DEF_CHATSET = "UTF-8";
    //	private static final String SMS_URL = "http://v.juhe.cn/sms/send?mobile=cphone&tpl_id=17271&tpl_value="
    //			+ "tplvalue&key=99a3f5312d6ff8b76452a24461f7c97e&";
    private static final String SMS_URL = "http://v.juhe.cn/sms/send?mobile=cphone&tpl_id=smsid&tpl_value=" + "tplvalue&key=smskey&";
    private static final String TPL_VALUE_TEMP = "#kab#=inkab&#driver#=indriver&#phone#=inphone";
    private static final String TPL_VALUE_EXPIRED = "#minute#=inminute";

    public static String sendSms(String smsid, String smskey, String orderId, String mobile, String kab, String driver, String phone)
            throws UnsupportedEncodingException {
        String realTplValue = TPL_VALUE_TEMP.replace("inkab", kab)
                .replace("indriver", driver)
                .replace("inphone", phone);
        String realSmsUrl = SMS_URL.replace("cphone", mobile)
                //				.replace("smsid",LoadXmlConfig.getConfigHash().get("sms-id"))
                .replace("smsid", smsid)
                .replace("tplvalue", URLEncoder.encode(realTplValue, DEF_CHATSET))
                .replace("smskey", smskey);
        //				.replace("smskey",LoadXmlConfig.getConfigHash().get("sms-key"));
        StringBuilder result = new StringBuilder(orderId);
        result.append("--").append(realSmsUrl);
        HttpURLConnection conn = null;
        try {
            URL url = new URL(realSmsUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEF_CHATSET));
            String strRead = null;
            result.append("\n");
            while ((strRead = reader.readLine()) != null)
                result.append(strRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 没有司机抢单,发送短信通知电话下单的乘客
     *
     * @param orderId
     * @param mobile
     * @param kab
     * @param driver
     * @param phone
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String sendSmsToPassenger(String smsid, String smskey, String orderId, String mobile, String minute)
            throws UnsupportedEncodingException {
        String realTplValue = TPL_VALUE_EXPIRED.replace("inminute", minute);
        String realSmsUrl = SMS_URL.replace("cphone", mobile)
                //				.replace("smsid",LoadXmlConfig.getConfigHash().get("expired-sms-id"))
                .replace("smsid", smsid)
                .replace("tplvalue", URLEncoder.encode(realTplValue, DEF_CHATSET))
                .replace("smskey", smskey);
        //				.replace("smskey",LoadXmlConfig.getConfigHash().get("sms-key"));
        StringBuilder result = new StringBuilder(orderId);
        result.append("--").append(realSmsUrl);
        HttpURLConnection conn = null;
        try {
            URL url = new URL(realSmsUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEF_CHATSET));
            String strRead = null;
            result.append("\n");
            while ((strRead = reader.readLine()) != null)
                result.append(strRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    //	public static String urlencode(Map<String,Object>data) {
    //        StringBuilder sb = new StringBuilder();
    //        for (Map.Entry i : data.entrySet()) {
    //            try {
    //                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
    //            } catch (UnsupportedEncodingException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //        return sb.toString();
    //    }

    public static void main(String[] args) throws Exception {
        System.out.println(SmsSender.sendSms("31845", "99a3f5312d6ff8b76452a24461f7c97e", "testorder", "15902075544", "粤A5544", "陈师傅", "15902075544"));
        //		System.out.println(SmsSender.sendSmsToPassenger("testorder","15902075544","2"));

        //		Map<String,Object> map = new ConcurrentHashMap<String,Object>();
        //		map.put("kab","粤A11111");
        //		map.put("driver","陈先生");
        //		map.put("phone","123455");
        //		System.out.println(URLEncoder.encode("#kab#=粤A11111&#driver#=陈先生&#phone#=123455",DEF_CHATSET));
    }
}
