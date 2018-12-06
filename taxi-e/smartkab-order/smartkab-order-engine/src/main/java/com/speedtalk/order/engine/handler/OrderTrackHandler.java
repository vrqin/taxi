package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.ScoreMqSender;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabOrderTrack;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.protocol.order.objs.Resp;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

import javax.jms.JMSException;
import java.sql.Timestamp;

public class OrderTrackHandler implements IOrderHandler {
    private final BaseDao baseDao = new BaseDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        TabOrderTrack track = null;
        try {
            Order order = (Order) obj;
            OrderLogger.getLogger().debug(order.toString() + "--" + session.getRemoteAddress());
            Resp resp = new Resp(order.getSrcMsID(), order.getMsName(), order.getOrderNum(), OrderMessConstants.SUCCESS, "");
            resp.setMessNo(order.getMessNo());
            if (order.getOrderMessId().equals(OrderMessConstants.GET_PASSENGER)) {
                track = new TabOrderTrack(order.getSrcMsID(), order.getOrderNum(), OrderConstants.ORDER_TRACK_FIND, new Timestamp(System
                        .currentTimeMillis()));
                resp.setOrderMessId(OrderMessConstants.GET_PASSENGER_RESP);
            } else if (order.getOrderMessId().equals(OrderMessConstants.ARRIVED)) {
                track = new TabOrderTrack(order.getSrcMsID(), order.getOrderNum(), OrderConstants.ORDER_TRACK_DRIVER_ARRIVED, new Timestamp(System
                        .currentTimeMillis()));
                KabInfo kabInfo = KabTeam.getInstance().getKab(order.getSrcMsID());
                kabInfo.setCarry(KabTeam.UNCARRY);

                resp.setOrderMessId(OrderMessConstants.ARRIVED_RESP);

                /**
                 * 按距离计算积分
                 */
                if ("1".equals(LoadXmlConfig.getConfigHash()
                        .get("is-score")) && "0".equals(LoadXmlConfig.getConfigHash().get("score-type"))) {
                    try {
                        ScoreMqSender.getInstance().sendMessage(order);
                    } catch (JMSException jmse) {
                        ExcepPrinter.print(jmse);
                        OrderLogger.getLogger().debug(order.getSrcMsID() + "完成订单!发送计算积分信息时队列发生异常!");
                    }
                }

                OrderLogger.getLogger().debug(order.getSrcMsID() + "完成订单!设置司机为空载!");
            }
            if (!resp.getOrderMessId().equals(""))
                session.write(resp);
            if (track != null)
                baseDao.save(track);
            if (order.getOrderMessId().equals(OrderMessConstants.ARRIVED)) {
                TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, order.getOrderNum());
                if (tbOrder.getStatus() != OrderConstants.FINISHED_ORDER) {
                    tbOrder.setStatus(OrderConstants.FINISHED_ORDER);
                    baseDao.update(tbOrder);
                }
            }
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
