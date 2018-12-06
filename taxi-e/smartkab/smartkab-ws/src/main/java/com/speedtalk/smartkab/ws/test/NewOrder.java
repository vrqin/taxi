package com.speedtalk.smartkab.ws.test;

import com.speedtalk.smartkab.ws.domain.Driver;

public class NewOrder {
    // private static Client client;
    // private static WebTarget target;
    // public static final String BASE_PATH =
    // "http://192.168.1.231:9999/smartkab";
    public NewOrder() {
        // client = ClientBuilder.newClient();
        // target = client.target(BASE_PATH);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Order order = new Order();
        // order.setAccount("12345678910");
        // order.setSrclt(111.123456);
        // order.setSrclg(222.123456);
        // order.setSrcaddr("广州市");
        // order.setDstlt(333.123456);
        // order.setDstlg(444.123456);
        // order.setDstaddr("汕尾市");
        // order.setType((byte) 0);
        // Entity<Order> entity = Entity.entity(order, ClientTarget.getInstance().getMediaType());
        // OrderResp resp = ClientTarget.getInstance()
        //         .getTarget()
        //         .path("order")
        //         .path("neworder")
        //         .request()
        //         .put(entity, OrderResp.class);
        // System.out.println(resp.getCode() + "," + resp.getDesc() + "," + resp.getOrderId());
        //
        // DropOrder order = new DropOrder();
        // order.setAccount("1234567891");
        // order.setOrderNum("160222154434000");
        // Entity<DropOrder> entity = Entity.entity(order, ClientTarget.getInstance().getMediaType());
        // Response resp = ClientTarget.getInstance()
        //         .getTarget()
        //         .path("order")
        //         .path("drop")
        //         .request()
        //         .post(entity, Response.class);
        // System.out.println(resp.getCode() + "," + resp.getDesc());
        //
        // AcceptOrder order = new AcceptOrder();
        // order.setOrderNum("160222154639000");
        // order.setMsId("11419018901");
        // order.setKabNum("粤A11111");
        // order.setAcceptTime("2016-02-23 16:37:00");
        // Entity<AcceptOrder> entity = Entity.entity(order, ClientTarget.getInstance().getMediaType());
        // Response resp = ClientTarget.getInstance()
        //         .getTarget()
        //         .path("order")
        //         .path("accept")
        //         .request()
        //         .post(entity, Response.class);
        // System.out.println(resp.getCode() + "," + resp.getDesc());
        //
        // EvaluateOrder order = new EvaluateOrder();
        // order.setAccount("1234567891");
        // order.setOrderNum("160222154639000");
        // order.setEvaluate((byte) 3);
        // Entity<EvaluateOrder> entity = Entity.entity(order, ClientTarget.getInstance().getMediaType());
        // Response resp = ClientTarget.getInstance()
        //         .getTarget()
        //         .path("order")
        //         .path("evaluate")
        //         .request()
        //         .post(entity, Response.class);
        // System.out.println(resp.getCode() + "," + resp.getDesc());

        Driver driver = ClientTarget.getInstance()
                .getTarget()
                .path("order")
                .path("driver")
                .queryParam("account", "15992436468")
                .queryParam("orderNum", "160530142820061")
                .request()
                .get(Driver.class);
        System.out.println(driver.toString());
    }
}
