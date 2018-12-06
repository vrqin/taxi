package com.spring.jersy.hibernate.publics.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class SmsSender {
    public static final String DEF_CHATSET = "UTF-8";
    //	public static final String SMS_ID="27015";
    public static final String SMS_ID = "31845";
    public static final String SMS_Key = "99a3f5312d6ff8b76452a24461f7c97e";
    //	private static final String SMS_URL = "http://v.juhe.cn/sms/send?mobile=cphone&tpl_id=17271&tpl_value="
    //			+ "tplvalue&key=99a3f5312d6ff8b76452a24461f7c97e&";
    private static final String SMS_URL = "http://v.juhe.cn/sms/send?mobile=cphone&tpl_id=smsid&tpl_value=" + "tplvalue&key=smskey&";
    //	private static final String TPL_VALUE_TEMP = "#kab#=inkab&#driver#=indriver&#phone#=inphone";
    private static final String TPL_VALUE_TEMP = "#minute#=inminute";

    public static String sendSms(String orderId, String mobile, String minute, String smsid, String smskey) throws UnsupportedEncodingException {
        String realTplValue = TPL_VALUE_TEMP.replace("inminute", minute);
        String realSmsUrl = SMS_URL.replace("cphone", mobile)
                .replace("smsid", smsid)
                .replace("tplvalue", URLEncoder.encode(realTplValue, DEF_CHATSET))
                .replace("smskey", smskey);
        StringBuffer result = new StringBuffer(orderId);
        result.append("--").append(realSmsUrl);
        HttpURLConnection conn;
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


    public static void main(String[] args) throws Exception {
        System.out.println(SmsSender.sendSms("170414144859009", "15992436468", "3", SMS_ID, SMS_Key));
        // System.out.println(SmsSender.sendSms("testorder","15902075544","粤A5544","陈师傅","15902075544","27015",));

    }
}
