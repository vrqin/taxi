package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.dao.OrderDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.db.TabOrderTrack;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.order.engine.setting.CompanySetting;
import com.speedtalk.order.engine.setting.Companys;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.DropOrder;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.protocol.order.objs.OrderSms;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

import java.sql.Timestamp;

public class DropOrderHandler implements IOrderHandler {
    private final BaseDao baseDao = new BaseDao();
    private OrderDao orderDao = new OrderDao();
    private DriverDao driverDao = new DriverDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            DropOrder dropOrder = (DropOrder) obj;
            OrderLogger.getLogger().debug(dropOrder.toString() + "--" + session.getRemoteAddress());
            Order resp = new Order(dropOrder.getSrcMsID(), dropOrder.getMsName(), OrderMessConstants.DROP_ORDER_RESP, dropOrder
                    .getOrderNum());
            resp.setMessNo(dropOrder.getMessNo());
            TabDriver driver = driverDao.getByAccount(dropOrder.getSrcMsID());
            TabPhonecallbuss order = orderDao.getOrder(dropOrder.getOrderNum());
            try {
                int status = order.getStatus();
                if (driver != null && driver.getKabnum()
                        .equals(order.getCarbox()) && status < OrderConstants.DROPPED_ORDER) {
                    order.setStatus(OrderConstants.DROPPED_ORDER);
                    TabOrderTrack track = new TabOrderTrack(dropOrder.getSrcMsID(), dropOrder.getOrderNum(), OrderConstants.ORDER_TRACK_DRIVER_CANCLE, new Timestamp(System
                            .currentTimeMillis()), dropOrder.getDesc());
                    baseDao.save(track);
                    baseDao.update(order);
                    KabInfo kabInfo = KabTeam.getInstance().getKab(dropOrder.getSrcMsID());
                    kabInfo.setCarry(KabTeam.UNCARRY);
                    kabInfo.dropOrder();
                    sendDropMessage(kabInfo);
                    OrderLogger.getLogger().debug(dropOrder.getSrcMsID() + "取消订单!设置司机为空载!");
                } else
                    OrderLogger.getLogger().debug(dropOrder.getSrcMsID() + "取消订单失败!");
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
            session.write(resp);
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    public void sendDropMessage(KabInfo kabInfo) {
        try {
            CompanySetting s = Companys.getInstance().getSetting(kabInfo.getClientId());
            String content = "您已取消电召单" + kabInfo.getDropcount() + "次,每天取消" + s.getDropOrder() + "次电召单,将被禁止派单" + s.getWaitMinute() + "分钟。";
            OrderSms sms = new OrderSms(kabInfo.getAccount(), kabInfo.getName(), content);
            kabInfo.getSession().write(sms);
            OrderLogger.getLogger().debug(content + " 发送给" + kabInfo.getAccount());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
