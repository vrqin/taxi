package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.OrderLogout;
import com.speedtalk.protocol.order.objs.Resp;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class LogoutHandler implements IOrderHandler {
    private DriverDao driverDao = new DriverDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            OrderLogout logout = (OrderLogout) obj;
            OrderLogger.getLogger().debug(logout.toString() + "--" + session.getRemoteAddress());
            Resp resp = new Resp(logout.getSrcMsID(), logout.getMsName(), OrderMessConstants.LOGOUT_RESP, OrderMessConstants.SUCCESS, null);
            resp.setMessNo(logout.getMessNo());
            session.write(resp);
            KabInfo kabInfo = KabTeam.getInstance().getKab(logout.getSrcMsID());
            if (kabInfo != null) {
                kabInfo.setOnline(KabTeam.OFFLINE);
                driverDao.updateOnlineStatus(logout.getSrcMsID(), KabTeam.OFFLINE);
            }

            OrderLogger.getLogger()
                    .debug(resp.toString() + "--" + session.getRemoteAddress() + "," + kabInfo.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
