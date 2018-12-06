package com.speedtalk.smartkab.ws;

import com.speedtalk.utils.LoadXmlConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender {
    public static final String DEF_CHATSET = "UTF-8";
    private static final String SMS_URL = "http://v.juhe.cn/sms/send?mobile=phone&tpl_id=tplid&tpl_value=" + "%23code%23%3Dvalidatecode&key=99a3f5312d6ff8b76452a24461f7c97e&";

    public static String sendValidateCode(String mobile, String code) {
        String smsid = "22655";    //默认为打车易模版id
        if (LoadXmlConfig.getConfigHash().get("sms-tpl-id") != null)
            smsid = LoadXmlConfig.getConfigHash().get("sms-tpl-id");
        String realSmsUrl = SMS_URL.replace("phone", mobile).replace("tplid", smsid).replace("validatecode", code);
        StringBuilder result = new StringBuilder(realSmsUrl);
        HttpURLConnection conn;
        try {
            URL url = new URL(realSmsUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEF_CHATSET));
            String strRead;
            result.append("\n");
            while ((strRead = reader.readLine()) != null)
                result.append(strRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(SmsSender.sendValidateCode("15902075544", "6321"));
    }
}
