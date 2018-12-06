package com.speedtalk.smartkab.ws.res;

import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.protocol.order.objs.OrderInteractive;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.MqUtils;
import com.speedtalk.smartkab.ws.Orders;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.dao.*;
import com.speedtalk.smartkab.ws.db.TabDriver;
import com.speedtalk.smartkab.ws.db.TabOrderTrack;
import com.speedtalk.smartkab.ws.db.TabPhonecallbuss;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.domain.*;

import javax.jms.JMSException;
import javax.ws.rs.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Path("order")
public class OrderResource {
    private OrderDao orderDao;
    private UserDao userDao;
    private BaseDao baseDao;
    private OrderTrackDao trackDao;
    private DriverDao driverDao;

    public OrderResource() {
        orderDao = new OrderDao();
        userDao = new UserDao();
        baseDao = new BaseDao();
        trackDao = new OrderTrackDao();
        driverDao = new DriverDao();
    }

    @POST
    @Path("new")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * submit a new order
     * @param order
     * @return if success return OrderResp,otherwise return empty OrderResp.
     */ public OrderResp newOrder(final Order order) {
        OrderResp resp = new OrderResp();
        try {
            TabPhoneuser user = userDao.getByAccount(order.getAccount());
            if (null == user) {
                resp.setCode(Constants.ACCOUNT_ERR_RESP);
                resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
                System.out.println(Utils.getLogFix() + "a incorrect user try to create order!" + order.getAccount());
                return resp;
            }
            TabPhonecallbuss tbOrder = orderDao.save(order);
            resp.setCode(Constants.SUCCESS_RESP);
            resp.setDesc(Constants.SUCCESS_DESC_RESP);
            resp.setOrderId(tbOrder.getBillid());
            System.out.println(Utils.getLogFix() + order.getAccount() + " new order success! OrderSerialNum:" + tbOrder.getBillid());

            NewOrder newOrder = new NewOrder(null, null, tbOrder.getClientmobile(), tbOrder.getSrcaddr(), String.valueOf(tbOrder
                    .getSrclg()), String.valueOf(tbOrder.getSrclt()), tbOrder.getAddress(), String.valueOf(tbOrder.getLg()), String
                    .valueOf(tbOrder.getLt()), DateUtils.getCommonTimeFormat()
                    .format(tbOrder.getCalltime()), order.getRemark(), String.valueOf(tbOrder.getOrdertype()));
            newOrder.setOrderNum(tbOrder.getBillid());
            try {
                MqUtils.getInstance().getSender().sendMessage(newOrder);
                System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + newOrder.toString());
            } catch (JMSException jmse) {
                try {
                    MqUtils.getInstance().getNewSender().sendMessage(newOrder);
                    System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + newOrder.toString());
                } catch (JMSException jmsee) {
                    System.out.println("Send new order occur exception" + tbOrder.getBillid());
                    jmsee.printStackTrace();
                }
            }

            TabOrderTrack track = new TabOrderTrack(order.getAccount(), tbOrder.getBillid(), OrderConstants.ORDER_TRACK_NEW, new Timestamp(System
                    .currentTimeMillis()), order.getRemark());
            baseDao.save(track);

            //			TabOrderTemp tempOrder = new TabOrderTemp(tbOrder.getBillid()
            //					,Constants.NEW_ORDER.byteValue(),tbOrder.getCalltime());
            //			tempDao.saveOrUpdateOrder(tempOrder);
            //
            //			Orders.getInstance().putOrder(tbOrder);

            //发送短信
            //			TabPhoneuser user = userDao.getByAccount(order.getAccount());
            //			int count = Sender.getInstance().sendOrder(orderSerialNum,(byte)1,
            //					user.getMobile(),order.getSrcaddr(),order.getSrclg().doubleValue(),
            //					order.getSrclt().doubleValue(),order.getDstaddr(),order.getDstlg().doubleValue(),
            //					order.getDstlt().doubleValue());
            //			System.out.println(Utils.getLogFix() + "Send sms :" + count);
        } catch (NullPointerException npe) {
            resp.setCode(Constants.ORDER_ERROR_RESP);
            resp.setDesc(Constants.ORDER_ERROR_DESC_RESP);
            npe.printStackTrace();
        } catch (IllegalArgumentException iae) {
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            iae.printStackTrace();
        } catch (Exception e) {
            resp.setCode(Constants.ORDER_FAILURE_RESP);
            resp.setDesc(Constants.ORDER_ERROR_DESC_RESP);
            e.printStackTrace();
        }
        return resp;
    }

    @POST
    @Path("neworder")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * submit a new order
     * @param order
     * @return if success return OrderResp,otherwise return empty OrderResp.
     */ public OrderResp newOrderExtend(final Order order) {
        OrderResp resp = new OrderResp();
        try {
            TabPhoneuser user = userDao.getByAccount(order.getAccount());
            if (null == user) {
                resp.setCode(Constants.ACCOUNT_ERR_RESP);
                resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
                System.out.println(Utils.getLogFix() + "a incorrect user try to create order!" + order.getAccount());
                return resp;
            }
            TabPhonecallbuss tbOrder = orderDao.save(order);
            resp.setCode(Constants.SUCCESS_RESP);
            resp.setDesc(Constants.SUCCESS_DESC_RESP);
            resp.setOrderId(tbOrder.getBillid());
            System.out.println(Utils.getLogFix() + order.getAccount() + " new order success! OrderSerialNum:" + tbOrder.getBillid());

            NewOrder newOrder = new NewOrder(null, null, tbOrder.getClientmobile(), tbOrder.getSrcaddr(), String.valueOf(tbOrder
                    .getSrclg()), String.valueOf(tbOrder.getSrclt()), tbOrder.getAddress(), String.valueOf(tbOrder.getLg()), String
                    .valueOf(tbOrder.getLt()), DateUtils.getCommonTimeFormat()
                    .format(tbOrder.getCalltime()), order.getRemark(), String.valueOf(tbOrder.getOrdertype()));
            newOrder.setOrderNum(tbOrder.getBillid());
            if (order.getDriver() != null && !order.getDriver().trim().equals(""))
                newOrder.setDriver(order.getDriver());
            try {
                MqUtils.getInstance().getSender().sendMessage(newOrder);
                System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + newOrder.toString());
            } catch (JMSException jmse) {
                try {
                    MqUtils.getInstance().getNewSender().sendMessage(newOrder);
                    System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + newOrder.toString());
                } catch (JMSException jmsee) {
                    System.out.println("Send new order occur exception" + tbOrder.getBillid());
                    jmsee.printStackTrace();
                }
            }

            TabOrderTrack track = new TabOrderTrack(order.getAccount(), tbOrder.getBillid(), OrderConstants.ORDER_TRACK_NEW, new Timestamp(System
                    .currentTimeMillis()), order.getRemark());
            baseDao.save(track);
        } catch (NullPointerException npe) {
            resp.setCode(Constants.ORDER_ERROR_RESP);
            resp.setDesc(Constants.ORDER_ERROR_DESC_RESP);
            npe.printStackTrace();
        } catch (IllegalArgumentException iae) {
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            iae.printStackTrace();
        } catch (Exception e) {
            resp.setCode(Constants.ORDER_FAILURE_RESP);
            resp.setDesc(Constants.ORDER_ERROR_DESC_RESP);
            e.printStackTrace();
        }
        return resp;
    }

    @PUT
    @Path("accept")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response acceptOrder(final AcceptOrder acceptOrder) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == acceptOrder) {
            System.out.println(Utils.getLogFix() + "accept order info error!");
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }
        TabPhoneuser user = userDao.getByAccount(acceptOrder.getAccount());
        if (null == user) {
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + "a incorrect user try to accept order!" + acceptOrder.getAccount());
            return resp;
        }
        if (null == acceptOrder.getMsId() || acceptOrder.getMsId().trim().equals("")) {
            System.out.println(Utils.getLogFix() + "accept order msid error!");
            resp.setCode(Constants.MSID_ERR_RESP);
            resp.setDesc(Constants.MSID_ERR_DESC_RESP);
            return resp;
        }
        TabPhonecallbuss order = orderDao.getOrder(acceptOrder.getOrderNum());
        if (null == order) {
            System.out.println(Utils.getLogFix() + "accept order serial num error!order num:" + acceptOrder.getOrderNum());
            resp.setCode(Constants.ORDER_NUM_ERR_RESP);
            resp.setDesc(Constants.ORDER_NUM_ERR_DESC_RESP);
            return resp;
        }
        order.setMsid(acceptOrder.getMsId());
        order.setCarbox(acceptOrder.getKabNum());
        try {
            order.setAnswerde(new Timestamp(Utils.getCommonsdf().parse(acceptOrder.getAcceptTime()).getTime()));
        } catch (ParseException pe) {
            order.setAnswerde(new Timestamp(System.currentTimeMillis()));
        }
        order.setStatus(Constants.FINISHED_ORDER);
        orderDao.update(order);

        //		tempDao.deleteOrder(order.getBillid());
        Orders.getInstance().finishOrder(order);

        System.out.println(Utils.getLogFix() + acceptOrder.getMsId() + "," + acceptOrder.getKabNum() + ",accept order:" + acceptOrder
                .getOrderNum());
        return resp;
    }

    @GET
    @Path("get")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public OrderInfo getOrder(@QueryParam("account") final String account) {
        OrderInfo info = new OrderInfo();
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get order!" + account);
            return info;
        }
        TabPhonecallbuss order = Orders.getInstance().getOrder();
        if (order != null) {
            info.setOrderNum(order.getBillid());
            info.setPhone(order.getClientmobile());
            info.setSrcAddr(order.getSrcaddr());
            info.setSrcLg(order.getSrclg());
            info.setSrcLt(order.getSrclt());
            info.setDstAddr(order.getAddress());
            info.setDstLg(order.getLg());
            info.setDstLt(order.getLt());
            info.setTime(Utils.getCommonsdf().format(order.getCalltime()));
            info.setType(order.getType().toString());
            info.setStatus(order.getStatus().toString());
            System.out.println(Utils.getLogFix() + account + " get a new order:" + info.toString());
        } else
            System.out.println(Utils.getLogFix() + account + " request a order,but there has no order!");

        return info;
    }

    @PUT
    @Path("drop")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response dropOrder(final DropOrder dropOrder) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == dropOrder) {
            System.out.println(Utils.getLogFix() + "drop order info error!");
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }
        TabPhonecallbuss order = orderDao.getOrder(dropOrder.getOrderNum());
        if (null == order) {
            System.out.println(Utils.getLogFix() + "drop order serial num error!order num:" + dropOrder.getOrderNum());
            resp.setCode(Constants.ORDER_NUM_ERR_RESP);
            resp.setDesc(Constants.ORDER_NUM_ERR_DESC_RESP);
            return resp;
        }
        if (null == dropOrder.getAccount() || dropOrder.getAccount()
                .trim()
                .equals("") || (order.getOpruser() != null && !order.getOpruser().equals(dropOrder.getAccount()))) {
            System.out.println(Utils.getLogFix() + "drop order account error!");
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            return resp;
        }
        if (order.getStatus() < Constants.DROPPED_ORDER) {
            order.setStatus(Constants.DROPPED_ORDER);
            String remark = null;
            if (null == order.getRemark() || order.getRemark().trim().equals(""))
                remark = "取消:" + dropOrder.getRemark() + "(" + Utils.getCommonsdf()
                        .format(System.currentTimeMillis()) + ")";
            else
                remark = order.getRemark() + "<br>取消:" + dropOrder.getRemark() + "(" + Utils.getCommonsdf()
                        .format(System.currentTimeMillis()) + ")";
            order.setRemark(remark);
            orderDao.update(order);

            com.speedtalk.protocol.order.objs.DropOrder dOrder = new com.speedtalk.protocol.order.objs.DropOrder(null, null, dropOrder
                    .getOrderNum(), dropOrder.getRemark());
            try {
                MqUtils.getInstance().getSender().sendMessage(dOrder);
                System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + dOrder.toString());
            } catch (JMSException jmse) {
                try {
                    MqUtils.getInstance().getNewSender().sendMessage(dOrder);
                    System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + dOrder.toString());
                } catch (JMSException jmsee) {
                    System.out.println("Send drop order occur exception" + dropOrder.getOrderNum());
                    jmsee.printStackTrace();
                }
            }
        }
        //		tempDao.deleteOrder(order.getBillid());
        Orders.getInstance().dropOrder(order);

        TabOrderTrack track = new TabOrderTrack(dropOrder.getAccount(), dropOrder.getOrderNum(), OrderConstants.ORDER_TRACK_PASSENGER_CANCLE, new Timestamp(System
                .currentTimeMillis()), dropOrder.getRemark());
        baseDao.save(track);

        //		if(driver != null && !driver.trim().equals(""))
        //		{
        //			try
        //			{
        //				Sender.getInstance().sendSms(order.getClientmobile(),order.getSrcaddr(),driver);
        //			}
        //			catch(Exception e)
        //			{
        //				e.printStackTrace();
        //			}
        //		}
        //		else
        //			System.out.println(Utils.getLogFix() + dropOrder.getAccount() + " driver msId is null,can't send sms! " +dropOrder.getOrderNum());
        System.out.println(Utils.getLogFix() + dropOrder.getAccount() + " drop order:" + dropOrder.getOrderNum());
        return resp;
    }

    @PUT
    @Path("evaluate")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response evaluateOrder(final EvaluateOrder evaluateOrder) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == evaluateOrder) {
            System.out.println(Utils.getLogFix() + "evaluate order info error!");
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }
        TabPhonecallbuss order = orderDao.getOrder(evaluateOrder.getOrderNum());
        if (null == order) {
            System.out.println(Utils.getLogFix() + "evaluate order serial num error!order num:" + evaluateOrder.getOrderNum());
            resp.setCode(Constants.ORDER_NUM_ERR_RESP);
            resp.setDesc(Constants.ORDER_NUM_ERR_DESC_RESP);
            return resp;
        }
        if (null == evaluateOrder.getAccount() || evaluateOrder.getAccount()
                .trim()
                .equals("") || (order.getOpruser() != null && !order.getOpruser().equals(evaluateOrder.getAccount()))) {
            System.out.println(Utils.getLogFix() + "evaluate order account error!");
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            return resp;
        }
        if (evaluateOrder.getEvaluate() > Constants.BEST)
            order.setEvaluate(Constants.BEST);
        else
            order.setEvaluate(evaluateOrder.getEvaluate());
        orderDao.update(order);
        System.out.println(Utils.getLogFix() + evaluateOrder.getAccount() + " evaluate order:" + evaluateOrder.getOrderNum() + "," + evaluateOrder
                .getEvaluate());
        return resp;
    }

    @GET
    @Path("driver")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Driver getDriver(@QueryParam("account") final String account, @QueryParam("orderNum") final String orderNum) {
        Driver driver = new Driver(orderNum);
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get driver! " + account);
            return driver;
        }
        TabPhonecallbuss order = orderDao.getOrder(orderNum);
        if (null == order) {
            System.out.println(Utils.getLogFix() + account + " get driver orderNum error! " + orderNum);
            return driver;
        }
        driver = orderDao.getDriver(account, orderNum);

        if (order.getOpruser() != null && !order.getOpruser().equals(account)) {
            System.out.println(Utils.getLogFix() + account + " get driver account error! " + orderNum);
            return driver;
        }
        System.out.println(Utils.getLogFix() + account + " query order:" + orderNum);
        return driver;
    }

    @GET
    @Path("getdriver")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public DriverExtend queryDriver(@QueryParam("account") final String account, @QueryParam("orderNum") final String orderNum) {
        DriverExtend driverExtend = new DriverExtend();
        driverExtend.setOrderNum(orderNum);
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            driverExtend.setCode(Constants.ACCOUNT_ERR_RESP);
            driverExtend.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + "a incorrect user try to get driver! " + account);
            return driverExtend;
        }
        TabPhonecallbuss order = orderDao.getOrder(orderNum);
        if (null == order) {
            driverExtend.setCode(Constants.ORDER_ERROR_RESP);
            driverExtend.setDesc(Constants.ORDER_ERROR_DESC_RESP);
            System.out.println(Utils.getLogFix() + account + " get driver orderNum error! " + orderNum);
            return driverExtend;
        }
        if (order.getStatus().intValue() == OrderConstants.NO_DRIVER.intValue()) {
            driverExtend.setCode(Constants.NO_DRIVER_RESP);
            driverExtend.setDesc(Constants.NO_DRIVER_DESC_RESP);
            System.out.println(Utils.getLogFix() + account + " no driver to send order," + orderNum);
            return driverExtend;
        }

        if (order.getOpruser() != null && !order.getOpruser().equals(account)) {
            driverExtend.setCode(Constants.ACCOUNT_ERR_RESP);
            driverExtend.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + account + " get driver account error! " + orderNum);
            return driverExtend;
        }
        Driver driver = orderDao.getDriver(account, orderNum);
        driverExtend.setMsId(driver.getMsId());
        driverExtend.setKabNum(driver.getKabNum());
        driverExtend.setDriverName(driver.getDriverName());
        driverExtend.setDriverSex(driver.getDriverSex());
        driverExtend.setDriverPhone(driver.getDriverPhone());
        driverExtend.setCompany(driver.getCompany());
        System.out.println(Utils.getLogFix() + account + " query order:" + orderNum);
        return driverExtend;
    }

    @POST
    @Path("track")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response orderTrack(final OrderTrack orderTrack) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == orderTrack) {
            System.out.println(Utils.getLogFix() + "order track info error!");
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }
        TabPhonecallbuss order = orderDao.getOrder(orderTrack.getOrderNum());
        if (null == order) {
            System.out.println(Utils.getLogFix() + "order serial num error!order num:" + orderTrack.getOrderNum());
            resp.setCode(Constants.ORDER_NUM_ERR_RESP);
            resp.setDesc(Constants.ORDER_NUM_ERR_DESC_RESP);
            return resp;
        }
        TabOrderTrack track = new TabOrderTrack(orderTrack.getAccount(), orderTrack.getOrderNum(), orderTrack.getNodeId(), new Timestamp(System
                .currentTimeMillis()), orderTrack.getRemark());
        baseDao.save(track);
        TabDriver tbDriver = driverDao.getDriver(order.getMsid());
        OrderInteractive interactive = new OrderInteractive(tbDriver.getAccount(), "", orderTrack.getOrderNum(), orderTrack
                .getNodeId(), "");
        try {
            MqUtils.getInstance().getSender().sendMessage(interactive);
            System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + interactive.toString());
        } catch (JMSException jmse) {
            try {
                MqUtils.getInstance().getNewSender().sendMessage(interactive);
                System.out.println(MqUtils.getInstance().getSenderInfo() + "--" + interactive.toString());
            } catch (JMSException jmsee) {
                System.out.println("Send order interactive occur exception" + orderTrack.getOrderNum());
                jmsee.printStackTrace();
            }
        }
        System.out.println(Utils.getLogFix() + orderTrack.getAccount() + " order track:" + orderTrack.getOrderNum() + "," + orderTrack
                .getNodeId() + "," + orderTrack.getRemark());
        return resp;
    }

    @GET
    @Path("status")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public OrderStatus getStatus(@QueryParam("account") final String account, @QueryParam("orderNum") final String orderNum) {
        OrderStatus status = new OrderStatus(orderNum, "0", "");
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get order status! " + account);
            return status;
        }
        TabPhonecallbuss order = orderDao.getOrder(orderNum);
        if (null == order) {
            System.out.println(Utils.getLogFix() + account + " get driver orderNum error! " + orderNum);
            return status;
        }
        TabOrderTrack orderTrack = trackDao.getOrderStatus(orderNum);
        if (orderTrack != null) {
            status.setStatus(String.valueOf(orderTrack.getNodeid()));
            if (orderTrack.getNodeid() == OrderConstants.ORDER_TRACK_DRIVER_CANCLE)
                status.setRemark(orderTrack.getRemark());
        }
        return status;
    }

    @GET
    @Path("porders")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * 乘客获取历史订单。
     * @param account 账号
     * @param orderNum 订单id。空值时，获取最新的count条订单；否则，获取orderNum后面的count条订单。
     * @param count 每次获取订单数。count <= 50。
     * @return
     */ public List<HisOrderInfo> getPassengerHisOrder(@QueryParam("account") final String account, @QueryParam("onum") final String orderNum, @QueryParam("count") final int count) {
        List<HisOrderInfo> list = new ArrayList<HisOrderInfo>();
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get his order! " + account);
            return list;
        }
        int tempCount = count > 50 ? 50 : count;
        list = orderDao.getHisOrder(account, orderNum, tempCount, Constants.PASSENGER);
        System.out.println(Utils.getLogFix() + account + " get history order:" + list.size());
        return list;
    }

    @GET
    @Path("dorders")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * 司机获取历史订单。
     * @param account 账号
     * @param orderNum 订单id。空值时，获取最新的count条订单；否则，获取orderNum后面的count条订单。
     * @param count 每次获取订单数。count <= 50。
     * @return
     */ public List<HisOrderInfo> getDriverHisOrder(@QueryParam("account") final String account, @QueryParam("onum") final String orderNum, @QueryParam("count") final int count) {
        List<HisOrderInfo> list = new ArrayList<HisOrderInfo>();
        TabDriver driver = driverDao.getDriverByAccount(account);
        if (null == driver) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get his order! " + account);
            return list;
        }
        int tempCount = count > 50 ? 50 : count;
        list = orderDao.getHisOrder(account, orderNum, tempCount, Constants.DRIVER);
        System.out.println(Utils.getLogFix() + account + " get history order:" + list.size());
        return list;
    }
}
