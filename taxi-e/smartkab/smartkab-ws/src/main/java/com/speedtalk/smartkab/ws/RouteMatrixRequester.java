package com.speedtalk.smartkab.ws;
//
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class RouteMatrixRequester {
    private static RouteMatrixRequester instance = new RouteMatrixRequester();

    private RouteMatrixRequester() {
    }

    public static RouteMatrixRequester getInstance() {
        if (null == instance)
            instance = new RouteMatrixRequester();
        return instance;
    }

    public static void main(String[] args) throws Exception {
        // RouteMatrixResp resp = getInstance().getRouteMatrix(40.45, 116.34, 40.34, 116.45);
        // String resp = getInstance().getDirectionDistance("x", "y", 40.0401092268, 116.3022244351, 39.9905588135, 116.3035096458, "wgs84");
        // String resp = getInstance().getDirectionDistance("北京", "北京", "上地五街", "北京大学");
        // String resp = getInstance().getDirectionDistance("广州", "广州", "广东省广州市越秀区惠新西街54号", "广东省广州市越秀区东风东路728号");
        // String resp = getInstance().getDirectionDistance("肇庆","肇庆","广东省肇庆市端州区S272(大桥路)","广东省肇庆市高要市");
        String resp = getInstance().getDirectionDistance("广州", "广州", "23.127549", "113.274107", "23.136875", "113.303056", "bd09ll");
        System.out.println("resp:" + resp);
        System.out.println(getInstance().parseDirectionPrice(resp).toString());
        // String str = "abc(123)";
        // System.out.println(str.substring(str.indexOf("(") + 1,str.indexOf(")")));
    }

    /**
     * 调用百度的<Route Matrix API v2.0>接口
     *
     * @param oriLt 起点纬度
     * @param oriLg 起点经度
     * @param desLt 终点纬度
     * @param desLg 终点经度
     * @return 接口返回的原始json
     */
    public String getRouteMatrix(double oriLt, double oriLg, double desLt, double desLg, String coordType) {
        String urlStr = "http://api.map.baidu.com/routematrix/v2/driving?output=json&origins=" + oriLt + "," + oriLg + "&destinations=" + desLt + "," + desLg + "&coord_type=" + coordType + "&ak=nintafs2kEDNcjP0GWT7bdwrUQx2Z3V8";
        BufferedReader in = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null)
                resp.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return resp.toString();
    }

    /**
     * 调用百度的<Direction API v1.0>接口
     *
     * @param srcCity 起点城市
     * @param dstCity 终点城市
     * @param src     起点地址
     * @param dst     终点地址
     * @return 接口返回的原始json
     */
    public String getDirectionDistance(String srcCity, String dstCity, String src, String dst) {
        String urlStr = "http://api.map.baidu.com/direction/v1?mode=driving" + "&origin=" + src + "&destination=" + dst + "&origin_region=" + srcCity + "&destination_region=" + dstCity + "&output=json&ak=7gavIDCBITo9y0yMtpGRB3L878V85T81";
        BufferedReader in = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null)
                resp.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return resp.toString();
    }

    /**
     * 调用百度的<Direction API v1.0>接口
     *
     * @param srcCity   起点城市
     * @param dstCity   终点城市
     * @param srcLt     起点纬度
     * @param srcLg     起点经度
     * @param dstLt     终点纬度
     * @param dstLg     终点经度
     * @param coordType 坐标类型
     * @return 接口返回的原始json
     */
    public String getDirectionDistance(String srcCity, String dstCity, String srcLt, String srcLg, String dstLt, String dstLg, String coordType) {
        String urlStr = "http://api.map.baidu.com/direction/v1?mode=driving" + "&origin=X|" + srcLt + "," + srcLg + "&destination=Y|" + dstLt + "," + dstLg + "&origin_region=" + srcCity + "&destination_region=" + dstCity + "&output=json&coord_type=" + coordType + "&ak=7gavIDCBITo9y0yMtpGRB3L878V85T81";
        BufferedReader in = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null)
                resp.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return resp.toString();
    }

    /**
     * 解析调用百度的<Route Matrix API v2.0>接口
     *
     * @param routeMatrixResp
     * @return 返回距离(米)
     * @throws NullPointerException
     * @throws JsonProcessingException
     * @throws IOException
     */
    public int parseRouteMatrixDistance(String routeMatrixResp) throws Exception {
        if (null == routeMatrixResp || routeMatrixResp.trim().equals(""))
            throw new NullPointerException("routeMatrixResp is null");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(routeMatrixResp);
            node = mapper.readTree(node.get("result").get(0).toString());
            Map<String, Object> map = mapper.readValue(node.get("distance").toString(), Map.class);
            return (int) map.get("value");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 解析调用百度的<Direction API v1.0>接口
     *
     * @param directionResp
     * @return 返回距离(米)
     * @throws NullPointerException
     * @throws JsonProcessingException
     * @throws IOException
     */
    public int parseDirectionDistance(String directionResp) throws Exception {
        if (null == directionResp || directionResp.trim().equals(""))
            throw new NullPointerException("directionResp is null");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(directionResp);
            node = mapper.readTree(node.get("result").get("routes").get(0).toString());
            return Integer.parseInt(node.get("distance").toString());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 解析调用百度的<Direction API v1.0>接口中的金额
     *
     * @param resp
     * @return
     * @throws NullPointerException
     * @throws JsonProcessingException
     * @throws IOException
     * @throws IllegalArgumentException 参数错误
     */
    public Price parseDirectionPrice(String resp) throws Exception {
        Price price = new Price();
        if (null == resp || resp.trim().equals(""))
            throw new NullPointerException("resp is null");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(resp);
            String status = node.get("status").toString();
            if (!"0".equals(status))    //status=0调用成功
            {
                price.setStatus(status);
                return price;
            }
            String type = node.get("type").toString();
            if (!"2".equals(type))    //type=2，起始点明确
            {
                price.setType(type);
                return price;
            }
            node = mapper.readTree(node.get("result").get("taxi").toString());
            /**
             * 提取接口的第一个价格，不区别时间段
             */
            //			String dayStr = node.get("detail").get(0).get("desc").toString();
            //			price.setDay(dayStr.substring(dayStr.indexOf("（") + 1,dayStr.indexOf("）")));
            price.setDayPrice(node.get("detail").get(0).get("total_price").toString().replace("\"", ""));

            //			String nightStr = node.get("detail").get(1).get("desc").toString();
            //			price.setNight(nightStr.substring(nightStr.indexOf("（") + 1,nightStr.indexOf("）")));
            //			price.setNightPrice(node.get("detail").get(1).get("total_price").toString().replace("\"",""));
        } catch (Exception e) {
            throw e;
        }
        return price;
    }

    public int getRouteMatrixDis(double oriLt, double oriLg, double desLt, double desLg, String coordType)
            throws Exception {
        return parseRouteMatrixDistance(getRouteMatrix(oriLt, oriLg, desLt, desLg, coordType));
    }

    public int getDircetionDis(String srcCity, String dstCity, String oriLt, String oriLg, String desLt, String desLg, String coordType)
            throws Exception {
        return parseDirectionDistance(getDirectionDistance(srcCity, dstCity, oriLt, oriLg, desLt, desLg, coordType));
    }

    public int getDircetionDis(String resp) throws Exception {
        return parseDirectionDistance(resp);
    }

    public Price getDircetionPrice(String resp) throws Exception {
        return parseDirectionPrice(resp);
    }
}
