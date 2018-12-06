package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.db.TabDriver;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.Resp;
import com.speedtalk.protocol.order.objs.UpdateDriverInfo;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class UpdateDriverHandler implements IOrderHandler {
    private DriverDao driverDao = new DriverDao();

    public static void main(String[] args) throws Exception {
        UpdateDriverInfo driverInfo = new UpdateDriverInfo(null, null, null, null, null);
        byte[] datas = {(byte) 0xAA, (byte) 0x7F, (byte) 0x32, (byte) 0x00, (byte) 0x44, (byte) 0x54, (byte) 0x65, (byte) 0x65, (byte) 0x15, (byte) 0x50, (byte) 0x5D, (byte) 0x5A, (byte) 0x62, (byte) 0x41, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x5D, (byte) 0x5D, (byte) 0x62, (byte) 0x42, (byte) 0x57, (byte) 0x53, (byte) 0x74, (byte) 0x50, (byte) 0x54, (byte) 0x51, (byte) 0x61, (byte) 0x41, (byte) 0x5F, (byte) 0x54, (byte) 0x67, (byte) 0x45, (byte) 0x03, (byte) 0x19, (byte) 0x37, (byte) 0x15, (byte) 0x17, (byte) 0x19, (byte) 0x64, (byte) 0x54, (byte) 0x10, (byte) 0x5A, (byte) 0x61, (byte) 0x43, (byte) 0x19, (byte) 0x19, (byte) 0xC8, (byte) 0xCA, (byte) 0x0D, (byte) 0x0A};
        System.out.println(driverInfo.bytesToObj(MessageUtils.encryptAndDecryptMess(datas)));

        //		UpdateDriverHandler handler = new UpdateDriverHandler();
        //		handler.handler(null,driverInfo);
    }

    @Override
    public void handler(IoSession session, TSCObject obj) {
        try {
            UpdateDriverInfo driverInfo = (UpdateDriverInfo) obj;
            OrderLogger.getLogger().debug(driverInfo.toString() + "--" + session.getRemoteAddress());
            TabDriver driver = driverDao.getByAccount(driverInfo.getSrcMsID());
            Resp resp = new Resp(driverInfo.getSrcMsID(), driverInfo.getMsName(), OrderMessConstants.UPDATE_DRIVER_INFO_RESP, null, null);
            resp.setMessNo(driverInfo.getMessNo());
            if (null == driver) {
                resp.setCode(OrderMessConstants.FAILURE);
                resp.setDesc(OrderMessConstants.E05);
            } else {
                String name = driverInfo.getDriverName();
                String kabNum = driverInfo.getVehicleNum();
                String phone = driverInfo.getDriverMobile();
                if (name != null && !name.trim().equals(""))
                    driver.setName(name.trim());
                if (kabNum != null && !kabNum.trim().equals(""))
                    driver.setKabnum(kabNum.trim());
                if (phone != null && !phone.trim().equals(""))
                    driver.setPhone(phone.trim());
                driverDao.update(driver);

                KabTeam.getInstance().getKab(driverInfo.getSrcMsID()).setName(driver.getName());

                resp.setCode(OrderMessConstants.SUCCESS);
            }
            session.write(resp);
            OrderLogger.getLogger().debug(resp.toString() + "--" + session.getRemoteAddress());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
