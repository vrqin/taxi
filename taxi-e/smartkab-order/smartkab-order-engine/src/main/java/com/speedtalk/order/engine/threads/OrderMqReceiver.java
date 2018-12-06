package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.OrderSentRecorder;
import com.speedtalk.order.engine.Orders;
import com.speedtalk.order.engine.dao.OrderDao;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.mq.MQReceiver;
import com.speedtalk.protocol.order.objs.DropOrder;
import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.protocol.order.objs.OrderInteractive;
import com.speedtalk.protocol.order.objs.OrderMess;
import com.speedtalk.utils.ExcepPrinter;

import javax.jms.JMSException;
import java.util.List;

public class OrderMqReceiver implements Runnable {
    private String mqAddr;
    private String queueName;
    private MQReceiver receiver;
    private OrderDao orderDao;

    public OrderMqReceiver(String mqAddr, String queueName) {
        this.mqAddr = mqAddr;
        this.queueName = queueName;
        orderDao = new OrderDao();
        try {
            initMqReceiver();
        } catch (JMSException jme) {
            ExcepPrinter.print(jme);
            OrderLogger.getLogger().debug("init OrderMqReceiver occur exception!!!");
        }
    }

    private void initMqReceiver() throws JMSException {
        receiver = new MQReceiver(mqAddr, queueName);
    }

    @Override
    public void run() {
        OrderLogger.log("OrderMqReceiver is running...");
        OrderMess mess = null;
        while (true) {
            if (null == receiver) {
                try {
                    initMqReceiver();
                } catch (JMSException jme) {
                    OrderLogger.getLogger().debug("***********init OrderMqReceiver occur exception!!!");
                    continue;
                }
            }

            try {
                mess = (OrderMess) receiver.revMessage();
                OrderLogger.getLogger().debug("OrderMqReceiver receive new mess:" + mess.toString());
            } catch (NullPointerException e) {
                continue;
            } catch (JMSException jmse) {
                receiver = null;
                continue;
            } catch (Exception e) {
                ExcepPrinter.print(e);
                continue;
            }
            try {
                if (mess instanceof NewOrder)
                    newOrderMess(mess);
                else if (mess instanceof DropOrder)
                    dropOrderMess(mess);
                else if (mess instanceof OrderInteractive)
                    orderInteractive(mess);
                else
                    otherOrderMess(mess);
            }
            //			catch(NullPointerException npe){}
            catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
    }

    //	private long updateSleep()
    //	{
    //		try
    //		{
    //			return Long.parseLong(LoadXmlConfig.getConfigHash().get("mqreceiver-sleep"));
    //		}
    //		catch(Exception e)
    //		{
    //			return 1000l;
    //		}
    //	}

    private void newOrderMess(OrderMess mess) {
        String orderNum = ((NewOrder) mess).getOrderNum();
        TabPhonecallbuss order = orderDao.getOrder(orderNum);
        if (order != null)
            Orders.getInstance().putNewOrder(order);
        else
            OrderLogger.getLogger().debug("Can't get order info from db!" + orderNum);
    }

    private void dropOrderMess(OrderMess mess) {
        try {
            DropOrder dropOrder = ((DropOrder) mess);
            TabPhonecallbuss order = orderDao.getOrder(dropOrder.getOrderNum());
            if (order != null) {
                Orders.getInstance().removeWaitOrder(order);
                OrderLogger.getLogger().debug("客户取消订单:" + dropOrder.getOrderNum() + "," + order.getStatus() + ",");
                if (order.getStatus().intValue() == OrderConstants.DROPPED_ORDER) {
                    List<String> list = OrderSentRecorder.getInstance().removeRecord(order.getBillid());
                    OrderInteractive interactive = null;
                    KabInfo kab = null;
                    StringBuilder buf = new StringBuilder("通知司机取消订单【");
                    buf.append(order.getBillid()).append("】:");
                    if (null == list)    //司机已抢单
                    {
                        String msId = order.getMsid();
                        try {
                            KabInfo kabInfo = KabTeam.getInstance().getKabByMsId(msId);
                            dropOrder.setSrcMsID(kabInfo.getAccount());
                            dropOrder.setMsName(kabInfo.getName());
                            kabInfo.getSession().write(dropOrder);
                            kabInfo.setCarry(KabTeam.UNCARRY);
                            OrderLogger.getLogger()
                                    .debug("Drop order,send to driver:" + dropOrder.toString() + "\n设置司机为空载!");
                        } catch (NullPointerException npe) {
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    } else        //司机未抢单
                    {
                        OrderLogger.getLogger().debug("司机列表:" + list.toString());
                        try {
                            for (String account : list) {
                                try {
                                    kab = KabTeam.getInstance().getKab(account);
                                    interactive = new OrderInteractive(account, account, order.getBillid(), OrderConstants.ORDER_TRACK_PASSENGER_CANCLE, dropOrder
                                            .getDesc());
                                    kab.getSession().write(interactive);
                                    buf.append(account).append(",").append(kab.getSessionInfo()).append(";");
                                } catch (Exception e) {
                                    ExcepPrinter.print(e);
                                }
                            }
                            OrderLogger.getLogger().debug(buf.toString());
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }

                    }
                } else
                    OrderLogger.getLogger().debug(dropOrder.getOrderNum() + "取消订单失败!");
            } else
                OrderLogger.getLogger().debug("Can't get order info from db!" + dropOrder.getOrderNum());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    private void orderInteractive(OrderMess mess) {
        String orderNum = ((OrderInteractive) mess).getOrderNum();
        TabPhonecallbuss order = orderDao.getOrder(orderNum);
        if (order != null) {
            try {
                OrderLogger.getLogger().debug("Order interactive:" + mess.toString());
                KabTeam.getInstance().getKab(mess.getSrcMsID()).getSession().write(mess);
                OrderLogger.getLogger().debug("Order interactive,send to driver:" + mess.toString());
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        } else
            OrderLogger.getLogger().debug("Can't get order info from db!" + orderNum);
    }

    private void otherOrderMess(OrderMess mess) {
        OrderLogger.getLogger().debug("OrderMqReceiver rev other mess!" + mess.toString());
    }

}
