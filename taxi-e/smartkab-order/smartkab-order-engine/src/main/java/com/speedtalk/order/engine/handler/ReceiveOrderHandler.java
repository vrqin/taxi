package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.protocol.order.objs.Order;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class ReceiveOrderHandler implements IOrderHandler {
    private BaseDao baseDao = new BaseDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            Order order = (Order) obj;
            OrderLogger.getLogger().debug(order.toString() + "--" + session.getRemoteAddress());
            TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, order.getOrderNum());
            if (tbOrder.getStatus().intValue() == OrderConstants.NEW_ORDER.intValue()) {
                tbOrder.setStatus(OrderConstants.SENTED_ORDER);
                baseDao.update(tbOrder);
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
