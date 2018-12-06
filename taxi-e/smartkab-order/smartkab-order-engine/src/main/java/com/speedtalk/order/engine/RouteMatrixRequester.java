package com.speedtalk.order.engine;

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
        //		RouteMatrixResp resp = getInstance().getRouteMatrix(40.45,116.34,40.34,116.45);
        //		String resp = getInstance().getDirectionDistance("x","y",22.602954,114.054289,22.607028,114.065591,"wgs84");
        //		System.out.println("resp:" + resp);
        //		System.out.println(getInstance().parseDirectionDistance(resp));
        //		int dis = getInstance().getDircetionDis("广州","广州",22.581741,113.920689,22.582437,113.923161,"bd09ll");
        //		System.out.println(dis);

        String resp = getInstance().getGeocoding("bd09ll", 23.17182122202054, 113.44128061463594);
        //		System.out.println(resp);
        System.out.println(getInstance().parseAreaFromGeocodingAPI(resp));

        //		StringBuilder buf = new StringBuilder("renderReverse&&renderReverse({\"stat}us\":0,}}}})");
        //		int first = buf.indexOf("{");
        //		buf.delete(0,first);
        //		int end = buf.lastIndexOf(("}"));
        ////		buf.delete(end,buf.length() - 1);
        //		buf.setLength(end + 1);
        //		System.out.println(buf.toString());
    }

    /**
     * 调用百度的<Route Matrix API v2.0>接口
     * http://lbsyun.baidu.com/index.php?title=webapi/direction-api-v2
     *
     * @param oriLt 起点纬度
     * @param oriLg 起点经度
     * @param desLt 终点纬度
     * @param desLg 终点经度
     * @return json
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
     * http://lbsyun.baidu.com/index.php?title=webapi/direction-api
     *
     * @param oriLt 起点纬度
     * @param oriLg 起点经度
     * @param desLt 终点纬度
     * @param desLg 终点经度
     * @return json
     */
    public String getDirectionDistance(String srcCity, String dstCity, double oriLt, double oriLg, double desLt, double desLg, String coordType) {
        String urlStr = "http://api.map.baidu.com/direction/v1?mode=driving" + "&origin=X|" + oriLt + "," + oriLg + "&destination=Y|" + desLt + "," + desLg + "&origin_region=" + srcCity + "&destination_region=" + dstCity + "&output=json&coord_type=" + coordType + "&ak=7gavIDCBITo9y0yMtpGRB3L878V85T81";
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
     * 调用百度的<Geocoding API>接口
     * http://lbsyun.baidu.com/index.php?title=
     * webapi/guide/webservice-geocoding&qq-pf-to=pcqq.c2c
     *
     * @param coordtype 坐标的类型
     *                  (包括：bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、
     *                  gcj02ll（国测局经纬度坐标）、wgs84ll（ GPS经纬度） )
     * @param lt        终点纬度
     * @param lg        起点经度
     * @return json
     */
    public String getGeocoding(String coordtype, double lt, double lg) {
        StringBuilder reqBuf = new StringBuilder("http://api.map.baidu.com/geocoder/v2/?callback=" + "renderReverse");
        if (coordtype != null && !coordtype.trim().equals(""))
            reqBuf.append("&coordtype=").append(coordtype);
        reqBuf.append("&location=")
                .append(lt)
                .append(",")
                .append(lg)
                .append("&output=json&pois=1&ak=")
                .append("GhTZUGdxU5hKtKdmmxO2eypi94FgpG0X");
        System.out.println(reqBuf.toString());
        BufferedReader in = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = new URL(reqBuf.toString());
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

    public int parseRouteMatrixDistance(String routeMatrixResp)
            throws NullPointerException, JsonProcessingException, IOException {
        if (null == routeMatrixResp || routeMatrixResp.trim().equals(""))
            throw new NullPointerException("routeMatrixResp is null");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(routeMatrixResp);
            node = mapper.readTree(node.get("result").get(0).toString());
            Map<String, Object> map = mapper.readValue(node.get("distance").toString(), Map.class);
            return (int) map.get("value");
        } catch (JsonProcessingException jpe) {
            throw jpe;
        } catch (IOException ioe) {
            throw ioe;
        }
    }

    public int parseDirectionDistance(String directionResp)
            throws NullPointerException, JsonProcessingException, IOException {
        if (null == directionResp || directionResp.trim().equals(""))
            throw new NullPointerException("directionResp is null");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(directionResp);
            node = mapper.readTree(node.get("result").get("routes").get(0).toString());
            return Integer.parseInt(node.get("distance").toString());
        } catch (JsonProcessingException jpe) {
            throw jpe;
        } catch (IOException ioe) {
            throw ioe;
        }
    }

    public int getRouteMatrixDis(double oriLt, double oriLg, double desLt, double desLg, String coordType)
            throws IOException {
        return parseRouteMatrixDistance(getRouteMatrix(oriLt, oriLg, desLt, desLg, coordType));
    }

    public int getDircetionDis(String srcCity, String dstCity, double oriLt, double oriLg, double desLt, double desLg, String coordType)
            throws IOException {
        return parseDirectionDistance(getDirectionDistance(srcCity, dstCity, oriLt, oriLg, desLt, desLg, coordType));
    }

    public String parseAreaFromGeocodingAPI(String resp)
            throws NullPointerException, JsonProcessingException, IOException {
        if (null == resp || resp.trim().equals(""))
            throw new NullPointerException("resp is null");
        //		System.out.println(resp.toString());
        //替换返回值开头的renderReverse&&renderReverse
        StringBuilder buf = new StringBuilder(resp);
        int first = buf.indexOf("{");
        buf.delete(0, first);
        int end = buf.lastIndexOf(("}"));
        buf.setLength(end + 1);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        try {
            node = mapper.readTree(buf.toString());
            int status = Integer.parseInt(node.get("status").toString());
            //			System.out.println("status:" + status);
            if (status == 0) {
                node = mapper.readTree(node.get("result").get("addressComponent").get("adcode").toString());
                return node.toString().replace("\"", "");
            } else
                return null;
        } catch (JsonProcessingException jpe) {
            throw jpe;
        } catch (IOException ioe) {
            throw ioe;
        }
    }
}
