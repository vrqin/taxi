package com.speedtalk.smartkab.score.ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class RouteMatrixRequester {
    private static final String BASE_PATH = "http://api.map.baidu.com/routematrix/v2/driving";
    private static RouteMatrixRequester instance = new RouteMatrixRequester();
    private Client client;
    private WebTarget target;

    private RouteMatrixRequester() {
        client = ClientBuilder.newClient();
        target = client.target(BASE_PATH);
    }

    public static RouteMatrixRequester getInstance() {
        if (null == instance)
            instance = new RouteMatrixRequester();
        return instance;
    }

    public static void main(String[] args) throws Exception {
        // RouteMatrixResp resp = getInstance().getRouteMatrix(40.45, 116.34, 40.34, 116.45);
        long start = System.currentTimeMillis();
        String resp = getInstance().getRouteMatrix(40.45, 116.34, 40.34, 116.45);
        System.out.println("resp:" + resp);
        System.out.println(getInstance().parseRouteMatrixDistance(resp));
        System.out.println("use time:" + (System.currentTimeMillis() - start));
    }

    /**
     * 调用百度的<Route Matrix API v2.0>接口
     *
     * @param oriLt 起点纬度
     * @param oriLg 起点经度
     * @param desLt 终点纬度
     * @param desLg 终点经度
     * @return
     */
    // public RouteMatrixResp getRouteMatrix(double oriLt, double oriLg, double desLt, double desLg) {
    //     RouteMatrixResp resp = null;
    //     resp = target.queryParam("output", "json")
    //             .queryParam("origins", oriLt + "," + oriLg)
    //             .queryParam("destinations", desLt + "," + desLg)
    //             .queryParam("coord_type", "wgs84")
    //             .queryParam("ak", "nintafs2kEDNcjP0GWT7bdwrUQx2Z3V8")
    //             .request()
    //             .get(RouteMatrixResp.class);
    //     return resp;
    // }

    /**
     * 调用百度的<Route Matrix API v2.0>接口
     *
     * @param oriLt 起点纬度
     * @param oriLg 起点经度
     * @param desLt 终点纬度
     * @param desLg 终点经度
     * @return json
     */
    public String getRouteMatrix(double oriLt, double oriLg, double desLt, double desLg) {
        String urlStr = "http://api.map.baidu.com/routematrix/v2/driving?output=json&origins=" + oriLt + "," + oriLg + "&destinations=" + desLt + "," + desLg + "&coord_type=wgs84&ak=nintafs2kEDNcjP0GWT7bdwrUQx2Z3V8";
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
            String line;
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
}
