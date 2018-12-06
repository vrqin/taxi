package com.spring.jersy.hibernate.publics.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * 84转百度  底部有例子
 */
public class BaiduAPIConverter {
    public static List<JSONBean> testPost(String x, String y) throws IOException {
        List<JSONBean> jsonBeanList = new ArrayList<JSONBean>();
        try {
            //            URL url = new URL("http://api.map.baidu.com/geoconv/v1/?from=1&to=4&x="+ x + "&y=" + y);
            URL url = new URL("http://api.map.baidu.com/geoconv/v1/?coords=" + x + "," + y + "&from=1&to=5&output=json&ak=78OhopFWz7wPFKlaFXA1DYPU");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
            // remember to clean up
            out.flush();
            out.close();
            // 一旦发送成功，用以下方法就可以得到服务器的回应：
            String sCurrentLine, sTotalString;
            sCurrentLine = sTotalString = "";
            InputStream l_urlStream;
            l_urlStream = connection.getInputStream();
            BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
            while ((sCurrentLine = l_reader.readLine()) != null) {
                if (!sCurrentLine.equals(""))
                    sTotalString += sCurrentLine;
            }
                       System.out.println(sTotalString);

            JSONObject json;

            try {

                json = new JSONObject(sTotalString);
                JSONArray results = json.getJSONArray("result");
                for (int i = 0; i < results.length(); i++) {
                    JSONBean jsonBean = new JSONBean();
                    JSONObject result = results.getJSONObject(i);
                    System.out.println(result.getString("x") + " " + result.getString("y"));
                    jsonBean.setLon(result.getString("x"));
                    jsonBean.setLat(result.getString("y"));
                    jsonBeanList.add(jsonBean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonBeanList;
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        List<JSONBean> lists = testPost("113.428955", "23.168952");
        System.out.println("ok");
        for (JSONBean bean : lists) {
            System.out.println(bean.getLon() + "  ,  " + bean.getLat());
            System.out.println(bean.getLat() + "," + bean.getLon());

        }
    }


}
