package com.speedtalk.pay.wechat;

import com.speedtalk.pay.wechat.domin.WeChatPay;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {


    public static String request(WeChatPay req, String reqAddr, String key) throws NullPointerException {
        if (null == req)
            throw new NullPointerException("req is null");
        if (null == reqAddr || reqAddr.trim().equals(""))
            throw new NullPointerException("reqAddr is null");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL urls = new URL(reqAddr);
            HttpURLConnection httpConn = (HttpURLConnection) urls.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            httpConn.setRequestProperty("charset", "UTF-8");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setReadTimeout(10000);
            httpConn.setConnectTimeout(10000);
            OutputStream out = httpConn.getOutputStream();
            DataOutputStream dataOs = new DataOutputStream(out);
            String sign = Utils.getSign(req, key);
            req.setSign(sign);
            dataOs.write(Utils.toXml(req).getBytes("utf-8"));
            dataOs.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String respStr;
            while ((respStr = in.readLine()) != null) {
                stringBuilder.append(respStr);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
