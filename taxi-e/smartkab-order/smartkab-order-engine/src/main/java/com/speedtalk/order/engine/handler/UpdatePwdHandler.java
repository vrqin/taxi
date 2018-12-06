package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.Resp;
import com.speedtalk.protocol.order.objs.UpdatePwd;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class UpdatePwdHandler implements IOrderHandler {
    private DriverDao driverDao = new DriverDao();

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            UpdatePwd driverInfo = (UpdatePwd) obj;
            OrderLogger.getLogger().debug(driverInfo.toString() + "--" + session.getRemoteAddress());
            TabDriver driver = driverDao.getByAccount(driverInfo.getSrcMsID());
            Resp resp = new Resp(driverInfo.getSrcMsID(), driverInfo.getMsName(), OrderMessConstants.UPDATE_PWD_RESP, OrderMessConstants.FAILURE, null);
            resp.setMessNo(driverInfo.getMessNo());
            if (null == driver) {
                resp.setDesc(OrderMessConstants.E05);
            } else {
                String oldPwd = driverInfo.getOldPwd();
                if (null == oldPwd || !oldPwd.trim().equals(driver.getPwd()))
                    resp.setDesc(OrderMessConstants.E03);
                else {
                    String newPwd = driverInfo.getNewPwd();
                    if (null == newPwd || newPwd.trim().equals(""))
                        resp.setDesc(OrderMessConstants.E06);
                    else {
                        driver.setPwd(newPwd.trim());
                        driverDao.update(driver);

                        resp.setCode(OrderMessConstants.SUCCESS);
                    }
                }
            }
            session.write(resp);
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
